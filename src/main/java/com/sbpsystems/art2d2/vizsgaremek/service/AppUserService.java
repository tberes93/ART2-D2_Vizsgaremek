package com.sbpsystems.art2d2.vizsgaremek.service;

import com.sbpsystems.art2d2.vizsgaremek.model.dto.RewardDto;
import com.sbpsystems.art2d2.vizsgaremek.model.dto.StartExerciseDto;
import com.sbpsystems.art2d2.vizsgaremek.model.dto.UserDto;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.AppUser;
import com.sbpsystems.art2d2.vizsgaremek.model.mapper.AppUserMapper;
import com.sbpsystems.art2d2.vizsgaremek.model.mapper.RewardMapper;
import com.sbpsystems.art2d2.vizsgaremek.model.repository.AppUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Transactional
@Service
public class AppUserService {

	@Autowired
	private AppUserRepository userRepository;

	@Autowired
	AppUserMapper appUserMapper;

	@Autowired
	RewardService rewardService;

	@Autowired
	RewardMapper rewardMapper;

	public UserDto getUserData(Long userId) {
		return appUserMapper.toUserDto(getAppUserById(userId));
	}

	public AppUser getAppUserById(Long userId) {
		validateUserId(userId);
		return findAppUserById(userId);
	}

	public List<UserDto> getTop10() {
		return userRepository.findTopUsersWithScore(PageRequest.of(0,10));
	}

	public List<UserDto> getAllUsers(){
		return appUserMapper.toUserDtoList(userRepository.findAll());
	}

	public Set<RewardDto> getAllRewardByUser(Long userId) {
		AppUser appUser = getAppUserById(userId);
		return rewardMapper.toRewardDtoList(appUser.getRewardSet());
	}

	private AppUser findAppUserById(Long userId) {
		Optional<AppUser> userOpt = userRepository.findById(userId);
		if (userOpt.isEmpty()) {
			throw new IllegalArgumentException("Az alábbi azonosítóval nem található felhasználó: " + userId);
		}
		return userOpt.get();
	}

	public void startExerciseByUser(StartExerciseDto startExerciseDto) {
		validateStartExerciseDto(startExerciseDto);
		AppUser appUser = getAppUserById(startExerciseDto.getUserId());
		updateAppUserPracticeData(appUser);
	}

	private void updateAppUserPracticeData(AppUser appUser) {
		//ma már gyakorolt
		if (appUser.getLastPracticeDate() != null && getCalendarDaysNumBetweenDates(appUser.getLastPracticeDate(), new Date()) == 0) {
			return;
		}
		appUser.setNumberOfPracticeDays(appUser.getNumberOfPracticeDays() == null ? 1L : appUser.getNumberOfPracticeDays() + 1);
		appUser.setNumberOfConsecutiveDays(calculateNewConsecutiveDaysByUser(appUser));
		appUser.setLastPracticeDate(new Date());
		rewardService.updateUserRewards(userRepository.save(appUser));
	}

	private Long calculateNewConsecutiveDaysByUser(AppUser appUser) {
		if (appUser.getLastPracticeDate() == null
			|| getCalendarDaysNumBetweenDates(appUser.getLastPracticeDate(), new Date()) > 1
			|| appUser.getNumberOfConsecutiveDays() == null) {
			return 0L;
		}
		return appUser.getNumberOfConsecutiveDays() + 1;
	}

	private Long getCalendarDaysNumBetweenDates(Date date1, Date date2) {
		return ChronoUnit.DAYS.between(date1.toInstant(), date2.toInstant());
	}

	private void validateUserId(Long userId) {
		if (userId == null) {
			throw new IllegalArgumentException("A felhasználó azonosító megadása kötelező!");
		}
	}

	private void validateStartExerciseDto(StartExerciseDto startExerciseDto) {
		if (startExerciseDto == null || startExerciseDto.getUserId() == null) {
			throw new IllegalArgumentException("A felhasználó azonosító megadása kötelező!");
		}
	}

}
