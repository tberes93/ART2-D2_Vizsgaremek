package com.sbpsystems.art2d2.vizsgaremek.model.mapper;

import com.sbpsystems.art2d2.vizsgaremek.model.dto.EyePracticeDto;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.EyePractice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EyePracticeMapper {

    @Mapping(target = "id",source = "id")
    EyePracticeDto toEyePracticeDto(EyePractice eyePractice);

    EyePractice toEyePractice(EyePracticeDto dto);

}
