package so.sonya.muswebapp2.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import so.sonya.muswebapp2.api.AuthApi;
import so.sonya.muswebapp2.dto.request.SignUpRequest;
import so.sonya.muswebapp2.dto.response.UserResponse;
import so.sonya.muswebapp2.service.SignUpService;

@RestController
@RequiredArgsConstructor
public class AuthApiController implements AuthApi {
    private final SignUpService service;

    @Override
    public UserResponse signUp(SignUpRequest signUpRequest) {
        return service.signUp(signUpRequest);
    }
}
