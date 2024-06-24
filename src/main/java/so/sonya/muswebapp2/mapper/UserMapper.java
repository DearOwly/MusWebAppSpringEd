package so.sonya.muswebapp2.mapper;

import org.mapstruct.Mapper;
import so.sonya.muswebapp2.dto.request.SignUpRequest;
import so.sonya.muswebapp2.dto.request.UpdateUserRequest;
import so.sonya.muswebapp2.dto.response.UserResponse;
import so.sonya.muswebapp2.mapper.base.UpdatingEntityMapper;
import so.sonya.muswebapp2.mapper.config.EntityMapperConfig;
import so.sonya.muswebapp2.model.user.User;

@Mapper(config = EntityMapperConfig.class)
public interface UserMapper
    extends UpdatingEntityMapper<User, SignUpRequest, UpdateUserRequest, UserResponse> {}
