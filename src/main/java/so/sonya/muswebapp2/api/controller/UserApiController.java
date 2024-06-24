package so.sonya.muswebapp2.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import so.sonya.muswebapp2.api.UserApi;
import so.sonya.muswebapp2.dto.request.UpdateUserRequest;
import so.sonya.muswebapp2.dto.response.UserResponse;
import so.sonya.muswebapp2.security.details.UserDetailsWithId;
import so.sonya.muswebapp2.service.UserService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserApiController implements UserApi {
    private final UserService service;

    @Override
    public UserResponse getById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Page<UserResponse> getAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @Override
    public UserResponse update(UpdateUserRequest updateUserRequest, UserDetailsWithId user) {
        return service.update(user.getId(), updateUserRequest);
    }

    @Override
    public UserResponse getByEmail(String email) {
        return service.findByEmail(email);
    }

    @Override
    public void delete(UserDetailsWithId user) {
        service.deleteById(user.getId());
    }
}
