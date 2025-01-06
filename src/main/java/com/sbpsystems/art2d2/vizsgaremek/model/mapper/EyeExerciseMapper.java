package com.sbpsystems.art2d2.vizsgaremek.model.mapper;

import com.sbpsystems.art2d2.vizsgaremek.model.dto.EyeExerciseDto;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.EyeExercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EyeExerciseMapper {

    // Térképezés EyeExercise -> EyeExerciseDto
    @Mapping(target = "eyePracticeId", source = "eyePractice.id")  // Átadjuk az EyePractice id-t EyeExerciseDto-ban eyePracticeId néven
    @Mapping(target = "images", source = "imagesSet")               // imagesSet -> images
    EyeExerciseDto toEyeExerciseDto(EyeExercise eyeExercise);

    // Térképezés listákra
    List<EyeExerciseDto> toEyeExerciseDtoList(List<EyeExercise> eyeExerciseList);

    // Térképezés EyeExerciseDto -> EyeExercise
    @Mapping(target = "eyePractice.id", source = "eyePracticeId")  // EyeExerciseDto eyePracticeId -> EyeExercise eyePractice.id
    @Mapping(target = "imagesSet", source = "images")               // EyeExerciseDto images -> EyeExercise imagesSet
    EyeExercise toEyeExercise(EyeExerciseDto dto);
}
