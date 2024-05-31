package so.sonya.muswebapp2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import so.sonya.muswebapp2.dto.request.SignUpRequest;
import so.sonya.muswebapp2.dto.request.UpdateUserRequest;
import so.sonya.muswebapp2.dto.response.UserResponse;
import so.sonya.muswebapp2.mapper.base.GenericUpdatingMapper;
import so.sonya.muswebapp2.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericUpdatingMapper<User, SignUpRequest, UpdateUserRequest, UserResponse> {
    @Override
    @Mapping(target = "id", ignore = true)
    User update(@MappingTarget User user, UpdateUserRequest updateUserRequest);
}
