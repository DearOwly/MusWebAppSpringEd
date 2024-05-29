package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.dto.user.SignUpForm;
import so.sonya.muswebapp2.dto.user.UserDto;
import so.sonya.muswebapp2.exception.notFound.UserNotFoundException;
import so.sonya.muswebapp2.mapper.UserMapper;
import so.sonya.muswebapp2.repository.UserRepository;
import so.sonya.muswebapp2.service.UserService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto findById(UUID id) {
        return userMapper.toDto(
                userRepository.findById(id)
                        .orElseThrow(() -> new UserNotFoundException())
        );
    }

    @Override
    public UserDto findByEmail(String email) {
        return userMapper.toDto(
                userRepository.findByEmail(email)
                        .orElseThrow(() -> new UserNotFoundException())
        );
    }

    @Override
    public UserDto findByNickname(String nickname) {
        return userMapper.toDto(
                userRepository.findByNickname(nickname)
                        .orElseThrow(() -> new UserNotFoundException()));
    }

    @Override
    public UUID save(UserDto user) {
        return userRepository.save(
                userMapper.toEntity(user)).getUuid();
    }

    public UUID registration(SignUpForm signUpForm){
        return userRepository.save(
                userMapper.fromFormToEntity(signUpForm)).getUuid();
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto update(UUID id, UserDto user) {
        return null;
    }
}
