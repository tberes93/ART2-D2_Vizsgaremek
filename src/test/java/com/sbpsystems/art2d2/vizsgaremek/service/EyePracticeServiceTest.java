package com.sbpsystems.art2d2.vizsgaremek.service;

import com.sbpsystems.art2d2.vizsgaremek.model.dto.EyePracticeDto;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.EyePractice;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.enums.EyePracticeType;
import com.sbpsystems.art2d2.vizsgaremek.model.mapper.EyePracticeMapper;
import com.sbpsystems.art2d2.vizsgaremek.model.repository.EyePracticeRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("EyePracticeService Test Suite")
class EyePracticeServiceTest {

    @Mock
    private EyePracticeRepository eyePracticeRepository;

    @Mock
    private EyePracticeMapper eyePracticeMapper;

    @InjectMocks
    private EyePracticeService eyePracticeService;

    @Nested
    @DisplayName("getPracticeByType Method Tests")
    class GetPracticeByTypeTests {
        @Test
        @DisplayName("Should return practice for valid type")
        void testGetPracticeByType(TestReporter testReporter) {
            testReporter.publishEntry("Running test: Should return practice for valid type");
            String type = "OLVASAS";
            EyePracticeType eyePracticeType = EyePracticeType.getEyePracticeTypeByKod(type);
            EyePracticeDto eyePracticeDto = new EyePracticeDto();

            EyePractice eyePractice = new EyePractice();
            eyePractice.setType(EyePracticeType.OLVASAS);
            eyePractice.setName("teszt");

            when(eyePracticeRepository.findByType(eyePracticeType)).thenReturn(eyePractice);
            when(eyePracticeMapper.toEyePracticeDto(any())).thenReturn(eyePracticeDto);

            EyePracticeDto result = eyePracticeService.getPracticeByType(type);

            assertNotNull(result);
            assertEquals(eyePracticeDto, result);
            verify(eyePracticeRepository, times(1)).findByType(eyePracticeType);
            verify(eyePracticeMapper, times(1)).toEyePracticeDto(any());
        }

        @Test
        @DisplayName("Should return null for invalid type")
        void testGetPracticeByType_InvalidType(TestReporter testReporter) {
            testReporter.publishEntry("Running test: Should return null for invalid type");
            String type = "INVALID_TYPE";

            EyePracticeDto result = eyePracticeService.getPracticeByType(type);

            assertNull(result);
            verify(eyePracticeRepository, never()).findByType(any());
            verify(eyePracticeMapper, never()).toEyePracticeDto(any());
        }
    }
}
