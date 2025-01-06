package com.sbpsystems.art2d2.vizsgaremek.service;

import com.sbpsystems.art2d2.vizsgaremek.model.entity.AppUser;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.Reward;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.enums.RewardType;
import com.sbpsystems.art2d2.vizsgaremek.model.repository.AppUserRepository;
import com.sbpsystems.art2d2.vizsgaremek.model.repository.RewardRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("RewardService Test Suite")
class RewardServiceTest {

    @Mock
    private RewardRepository rewardRepository;

    @Mock
    private AppUserRepository userRepository;

    @InjectMocks
    private RewardService rewardService;

    @Nested
    @DisplayName("addRewardToUser Method Tests")
    class AddRewardToUserTests {
        @Test
        @DisplayName("Should add reward to user")
        void testAddRewardToUser(TestReporter testReporter) {
            testReporter.publishEntry("Running test: Should add reward to user");
            AppUser appUser = new AppUser();
            appUser.setRewardSet(new HashSet<>());

            Reward reward = new Reward();
            rewardService.addRewardToUser(appUser, reward);

            assertTrue(appUser.getRewardSet().contains(reward));
            verify(userRepository, times(1)).save(appUser);
        }
    }

    @Nested
    @DisplayName("findLastRewardOptByUserAndType Method Tests")
    class FindLastRewardOptByUserAndTypeTests {
        @Test
        @DisplayName("Should return rewards for valid type")
        void testFindLastRewardOptByUserAndType(TestReporter testReporter) {
            testReporter.publishEntry("Running test: Should return rewards for valid type");
            AppUser appUser = new AppUser();
            appUser.setNumberOfPracticeDays(10L);
            RewardType type = RewardType.PRACTICEDAYS_REWARD;

            Reward reward = new Reward();
            List<Reward> rewardList = Collections.singletonList(reward);

            when(rewardRepository.findAllAchievedRewardByTypeAndUserExerciseNum(eq(type), eq(appUser.getNumberOfPracticeDays())))
                    .thenReturn(rewardList);

            List<Reward> result = rewardService.findLastRewardOptByUserAndType(appUser, type);

            assertNotNull(result);
            assertEquals(rewardList, result);
            verify(rewardRepository, times(1))
                    .findAllAchievedRewardByTypeAndUserExerciseNum(eq(type), eq(appUser.getNumberOfPracticeDays()));
        }

    }
}
