package so.sonya.muswebapp2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import so.sonya.muswebapp2.dto.request.UpdateUserRequest;
import so.sonya.muswebapp2.dto.response.UserResponse;

import java.util.UUID;

public interface UserService {
    Page<UserResponse> findAll(Pageable pageable);

    UserResponse findById(UUID id);

    UserResponse findByEmail(String email);

    UserResponse update(UUID id, UpdateUserRequest request);

    void deleteById(UUID id);
}
