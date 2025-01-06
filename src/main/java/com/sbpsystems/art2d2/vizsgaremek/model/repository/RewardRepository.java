package com.sbpsystems.art2d2.vizsgaremek.model.repository;

import com.sbpsystems.art2d2.vizsgaremek.model.entity.Reward;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.enums.RewardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RewardRepository extends JpaRepository<Reward, Long> {

	@Query("SELECT reward FROM Reward reward WHERE reward.type = :type AND reward.numberToAchieve <= :userExerciseNum order by numberToAchieve desc")
	List<Reward> findAllAchievedRewardByTypeAndUserExerciseNum(RewardType type, Long userExerciseNum);

}
