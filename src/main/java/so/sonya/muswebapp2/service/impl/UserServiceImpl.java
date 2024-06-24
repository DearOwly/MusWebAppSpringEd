package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.dto.request.UpdateUserRequest;
import so.sonya.muswebapp2.dto.response.UserResponse;
import so.sonya.muswebapp2.exception.notfound.UserNotFoundException;
import so.sonya.muswebapp2.mapper.UserMapper;
import so.sonya.muswebapp2.repository.UserRepository;
import so.sonya.muswebapp2.service.UserService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public Page<UserResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                         .map(mapper::toResponse);
    }

    @Override
    public UserResponse findById(UUID id) {
        return mapper.toResponse(
            repository.findById(id)
                      .orElseThrow(UserNotFoundException::new)
        );
    }

    @Override
    public UserResponse findByEmail(String email) {
        return mapper.toResponse(
            repository.findByEmail(email)
                      .orElseThrow(UserNotFoundException::new)
        );
    }

    @Override
    public UserResponse update(UUID id, UpdateUserRequest request) {
        return mapper.toResponse(repository.save(mapper.update(
            repository.findById(id)
                      .orElseThrow(UserNotFoundException::new),
            request
        )));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
