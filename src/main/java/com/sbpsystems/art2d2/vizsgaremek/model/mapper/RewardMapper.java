package com.sbpsystems.art2d2.vizsgaremek.model.mapper;

import com.sbpsystems.art2d2.vizsgaremek.model.dto.RewardDto;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.Reward;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface RewardMapper {

    RewardDto toRewardDto(Reward reward);

    Set<RewardDto> toRewardDtoList(Set<Reward> rewardList);

}
