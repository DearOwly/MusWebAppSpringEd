package so.sonya.muswebapp2.api;

import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import so.sonya.muswebapp2.dto.request.UpdateUserRequest;
import so.sonya.muswebapp2.dto.response.UserResponse;
import so.sonya.muswebapp2.security.details.UserDetailsWithId;

import java.util.UUID;

import static so.sonya.muswebapp2.api.util.Contants.USER_API_URL;

@Api(tags = "User | Пользователь", value = "User")
@RequestMapping(USER_API_URL)
public interface UserApi {
    @GetMapping("/list")
    Page<UserResponse> getAll(
        Pageable pageable
    );

    @GetMapping(params = {"id"})
    UserResponse getById(
        @RequestParam
        UUID id
    );

    @GetMapping(params = {"email"})
    UserResponse getByEmail(
        @RequestParam
        @Email
        String email
    );

    @PatchMapping
    UserResponse update(
        @RequestBody
        @Valid
        UpdateUserRequest updateUserRequest,

        @AuthenticationPrincipal
        UserDetailsWithId user
    );

    @DeleteMapping
    void delete(
        @AuthenticationPrincipal
        UserDetailsWithId user
    );
}
