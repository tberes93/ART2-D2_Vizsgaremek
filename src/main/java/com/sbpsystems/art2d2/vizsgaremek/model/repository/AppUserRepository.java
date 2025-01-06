package com.sbpsystems.art2d2.vizsgaremek.model.repository;


import com.sbpsystems.art2d2.vizsgaremek.model.dto.UserDto;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.AppUser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	AppUser findByUserName(String username);
	Boolean existsByUserName(String username);

	@Query("SELECT new com.sbpsystems.art2d2.vizsgaremek.model.dto.UserDto(" +
			"u.id, u.userName, u.firstName, u.lastName, u.password, " +
			"u.lastPracticeDate, u.numberOfConsecutiveDays, " +
			"u.numberOfPracticeDays, u.iconImgName, " +
			"COALESCE(u.numberOfPracticeDays, 0) + (COALESCE(u.numberOfConsecutiveDays, 0) * 10)), " +
			"CASE WHEN (u.id < 0) THEN TRUE ELSE FALSE END " +
			"FROM AppUser u " +
			"ORDER BY COALESCE(u.numberOfPracticeDays, 0) + (COALESCE(u.numberOfConsecutiveDays, 0) * 10) DESC")
	List<UserDto> findTopUsersWithScore(Pageable pageable);

}
