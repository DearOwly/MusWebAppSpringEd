package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.dto.request.UpdateUserRequest;
import so.sonya.muswebapp2.dto.response.UserResponse;
import so.sonya.muswebapp2.exception.UserNotFoundException;
import so.sonya.muswebapp2.mapper.UserMapper;
import so.sonya.muswebapp2.model.User;
import so.sonya.muswebapp2.repository.UserRepository;
import so.sonya.muswebapp2.service.UserService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserResponse findById(UUID id) {
        User user = repository.findById(id)
                        .orElseThrow(UserNotFoundException::new);

        return mapper.toResponse(user);
    }

    @Override
    public UserResponse findByEmail(String email) {
        User user = repository.findByEmail(email)
                        .orElseThrow(UserNotFoundException::new);

        return mapper.toResponse(user);
    }

    @Override
    public UserResponse findByNickname(String nickname) {
        User user = repository.findByNickName(nickname)
                        .orElseThrow(UserNotFoundException::new);

        return mapper.toResponse(user);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public UserResponse update(UUID uuid, UpdateUserRequest updateUserRequest) {
        User user = repository.getReferenceById(uuid);
        mapper.update(user, updateUserRequest);
        return mapper.toResponse(repository.save(user));
    }

    @Override
    public Page<UserResponse> findAll(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository
                .findAll(pageable)
                .map(mapper::toResponse);
    }
}
