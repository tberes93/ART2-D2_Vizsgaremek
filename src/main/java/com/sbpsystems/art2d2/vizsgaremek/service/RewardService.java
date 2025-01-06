package com.sbpsystems.art2d2.vizsgaremek.service;

import com.sbpsystems.art2d2.vizsgaremek.model.entity.AppUser;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.Reward;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.enums.RewardType;
import com.sbpsystems.art2d2.vizsgaremek.model.repository.AppUserRepository;
import com.sbpsystems.art2d2.vizsgaremek.model.repository.RewardRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class RewardService {

	@Autowired
	private RewardRepository rewardRepository;

	@Autowired
	private AppUserRepository userRepository;

	public void updateUserRewards(AppUser appUser) {
		updateRewardByType(appUser, RewardType.PRACTICEDAYS_REWARD);
		updateRewardByType(appUser, RewardType.CONSECUTIVEDAYS_REWARD);
	}

	protected void updateRewardByType(AppUser appUser, RewardType type) {
		List<Reward> rewardList = findLastRewardOptByUserAndType(appUser, type);
		if (CollectionUtils.isEmpty(rewardList)) {
			return;
		}
		Reward lastReward = rewardList.get(0);
		//mar elnyerte ezt?
		if (appUser.getRewardSet().contains(lastReward)) {
			return;
		}
		addRewardToUser(appUser, lastReward);
	}

	protected void addRewardToUser(AppUser appUser, Reward reward) {
		appUser.getRewardSet().add(reward);
		userRepository.save(appUser);
	}

	protected List<Reward> findLastRewardOptByUserAndType(AppUser appUser, RewardType type) {
		if (RewardType.PRACTICEDAYS_REWARD.equals(type)) {
			return rewardRepository.findAllAchievedRewardByTypeAndUserExerciseNum(
				RewardType.PRACTICEDAYS_REWARD, appUser.getNumberOfPracticeDays());
		} else if (RewardType.CONSECUTIVEDAYS_REWARD.equals(type)) {
			return rewardRepository.findAllAchievedRewardByTypeAndUserExerciseNum(
				RewardType.CONSECUTIVEDAYS_REWARD, appUser.getNumberOfConsecutiveDays());
		}
		throw new UnsupportedOperationException("Ismeretlen nyeremény típus: " + type.name());
	}

}
