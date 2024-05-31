package so.sonya.muswebapp2.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.dto.request.SignUpRequest;
import so.sonya.muswebapp2.dto.response.UserResponse;
import so.sonya.muswebapp2.exception.AlreadyRegistredException;
import so.sonya.muswebapp2.exception.PasswordMismatchException;
import so.sonya.muswebapp2.mapper.UserMapper;
import so.sonya.muswebapp2.model.AuthProvider;
import so.sonya.muswebapp2.model.Role;
import so.sonya.muswebapp2.model.User;
import so.sonya.muswebapp2.repository.UserRepository;
import so.sonya.muswebapp2.service.SignUpService;

import java.util.Set;

@Service
@AllArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse signUp(SignUpRequest signUpRequest) {
        String email = signUpRequest.email();

        if (repository.existsByEmail(email)) {
            throw new AlreadyRegistredException(email);
        }

        if (!signUpRequest.password().equals(signUpRequest.passwordConfirmation())) {
            throw new PasswordMismatchException();
        }

        User user = mapper.toEntity(signUpRequest);
        user.setEmailVerified(true);
        user.setAuthProvider(AuthProvider.LOCAL);
        user.setRoles(Set.of(Role.USER));
        user.setPasswordHash(passwordEncoder.encode(signUpRequest.password()));

        return mapper.toResponse(user);
    }
}
