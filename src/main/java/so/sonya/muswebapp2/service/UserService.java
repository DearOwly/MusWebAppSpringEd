package so.sonya.muswebapp2.service;

import so.sonya.muswebapp2.dto.user.SignUpForm;
import so.sonya.muswebapp2.dto.user.UserDto;

import java.util.UUID;

public interface UserService extends StandartService<UserDto, UUID> {
    UserDto findByEmail(String email);
    UserDto findByNickname(String nickname);
}
