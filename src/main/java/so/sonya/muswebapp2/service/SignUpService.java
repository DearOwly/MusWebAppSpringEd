package so.sonya.muswebapp2.service;

import so.sonya.muswebapp2.dto.request.SignUpRequest;
import so.sonya.muswebapp2.dto.response.UserResponse;

public interface SignUpService {
    UserResponse signUp(SignUpRequest signUpRequest);
}
