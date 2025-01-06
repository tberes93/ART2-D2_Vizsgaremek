package com.sbpsystems.art2d2.vizsgaremek.model.mapper;

import com.sbpsystems.art2d2.vizsgaremek.model.dto.UserDto;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.AppUser;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppUserMapper {

    UserDto toUserDto(AppUser appUser);

    List<UserDto> toUserDtoList(List<AppUser> appUserList);

    AppUser toAppUser(UserDto dto);

    @AfterMapping
    default void mapToUserDto(AppUser appUser, @MappingTarget UserDto userDto) {
        userDto.setAdmin(appUser.getId() < 0);
    }

}
