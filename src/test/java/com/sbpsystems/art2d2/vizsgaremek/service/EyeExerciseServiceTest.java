package com.sbpsystems.art2d2.vizsgaremek.service;

import com.sbpsystems.art2d2.vizsgaremek.model.dto.EyeExerciseDto;
import com.sbpsystems.art2d2.vizsgaremek.model.mapper.EyeExerciseMapper;
import com.sbpsystems.art2d2.vizsgaremek.model.repository.EyeExerciseRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("EyeExerciseService Test Suite")
class EyeExerciseServiceTest {

    @Mock
    private EyeExerciseRepository eyeExerciseRepository;

    @Mock
    private EyeExerciseMapper eyeExerciseMapper;

    @InjectMocks
    private EyeExerciseService eyeExerciseService;

    @Nested
    @DisplayName("getAllEyeExerciseByEyePracticeId Method Tests")
    class GetAllEyeExerciseByEyePracticeIdTests {
        @Test
        @DisplayName("Should return exercises for valid eyePracticeId")
        void testGetAllEyeExerciseByEyePracticeId(TestReporter testReporter) {
            testReporter.publishEntry("Running test: Should return exercises for valid eyePracticeId");
            Long eyePracticeId = 1L;
            List<EyeExerciseDto> eyeExerciseDtos = Collections.emptyList();

            when(eyeExerciseRepository.findAllByEyePracticeIdOrderByOrderNumberAsc(eyePracticeId))
                    .thenReturn(Collections.emptyList());
            when(eyeExerciseMapper.toEyeExerciseDtoList(anyList())).thenReturn(eyeExerciseDtos);

            List<EyeExerciseDto> result = eyeExerciseService.getAllEyeExerciseByEyePracticeId(eyePracticeId);

            assertNotNull(result);
            assertEquals(eyeExerciseDtos, result);
            verify(eyeExerciseRepository, times(1))
                    .findAllByEyePracticeIdOrderByOrderNumberAsc(eyePracticeId);
            verify(eyeExerciseMapper, times(1)).toEyeExerciseDtoList(anyList());
        }

        @Test
        @DisplayName("Should throw exception for null eyePracticeId")
        void testGetAllEyeExerciseByEyePracticeId_NullId(TestReporter testReporter) {
            testReporter.publishEntry("Running test: Should throw exception for null eyePracticeId");

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                eyeExerciseService.getAllEyeExerciseByEyePracticeId(null)
            );

            assertEquals("A szemtorna azonosító megadása kötelező!", exception.getMessage());
            verify(eyeExerciseRepository, never())
                    .findAllByEyePracticeIdOrderByOrderNumberAsc(anyLong());
            verify(eyeExerciseMapper, never()).toEyeExerciseDtoList(anyList());
        }
    }
}
