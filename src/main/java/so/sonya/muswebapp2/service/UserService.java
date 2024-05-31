package so.sonya.muswebapp2.service;

import so.sonya.muswebapp2.dto.request.UpdateUserRequest;
import so.sonya.muswebapp2.dto.response.UserResponse;
import so.sonya.muswebapp2.service.base.GenericPagingService;
import so.sonya.muswebapp2.service.base.GenericUpdatingService;

import java.util.UUID;

public interface UserService extends
        GenericUpdatingService<UUID, UpdateUserRequest, UserResponse>,
        GenericPagingService<UserResponse>{
    UserResponse findById(UUID uuid);

    UserResponse findByEmail(String email);

    UserResponse findByNickname(String nickname);

    void deleteById(UUID uuid);
}
