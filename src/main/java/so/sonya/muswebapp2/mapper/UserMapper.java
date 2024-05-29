package so.sonya.muswebapp2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import so.sonya.muswebapp2.dto.user.SignUpForm;
import so.sonya.muswebapp2.dto.user.UserDto;
import so.sonya.muswebapp2.model.UserEntity;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "id", target = "uuid")
    UserEntity toEntity(UserDto userDto);

    @Mapping(source = "uuid", target = "id")
    UserDto toDto(UserEntity userEntity);

    UserEntity fromFormToEntity(SignUpForm signUpForm);

}
