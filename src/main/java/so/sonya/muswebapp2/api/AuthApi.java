package so.sonya.muswebapp2.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import so.sonya.muswebapp2.dto.request.SignUpRequest;
import so.sonya.muswebapp2.dto.response.UserResponse;

import static so.sonya.muswebapp2.api.util.Constants.AUTH_API_URL;

@RequestMapping(AUTH_API_URL)
public interface AuthApi {
    @PostMapping("/signup")
    UserResponse signUp(@RequestBody SignUpRequest signUpRequest);
}
