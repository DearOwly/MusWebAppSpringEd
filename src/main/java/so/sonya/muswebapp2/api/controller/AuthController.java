
package so.sonya.muswebapp2.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.sonya.muswebapp2.api.AuthApi;
import so.sonya.muswebapp2.dto.request.SignUpRequest;
import so.sonya.muswebapp2.dto.response.UserResponse;
import so.sonya.muswebapp2.service.SignUpService;

@RestController
@AllArgsConstructor
public class AuthController implements AuthApi {
    private final SignUpService service;

    @Override
    public UserResponse signUp(@RequestBody SignUpRequest signUpRequest) {
        return service.signUp(signUpRequest);
    }
}
