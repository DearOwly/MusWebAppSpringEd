package so.sonya.muswebapp2.api;

import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import so.sonya.muswebapp2.dto.request.UpdateUserRequest;
import so.sonya.muswebapp2.dto.response.UserResponse;

import java.security.Principal;
import java.util.UUID;

import static so.sonya.muswebapp2.api.util.Constants.USER_API_URL;

@Api(tags = "User | Пользователь", value = "User")
@RequestMapping(USER_API_URL)
public interface UserApi {
    UserResponse getById(@PathVariable("id") UUID id);
    Page<UserResponse> getAll(Integer pageNumber, Integer pageSize);
    UserResponse updateInfo(@RequestBody UpdateUserRequest updateUserRequest, @AuthenticationPrincipal Principal principal);
    UserResponse getByEmail(String email);
    void delete(@AuthenticationPrincipal Principal principal);
}
