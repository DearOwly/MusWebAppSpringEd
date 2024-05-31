package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.dto.request.CreateThreadRequest;
import so.sonya.muswebapp2.dto.request.UpdateThreadRequest;
import so.sonya.muswebapp2.dto.response.ThreadResponse;
import so.sonya.muswebapp2.exception.ThreadNotFoundException;
import so.sonya.muswebapp2.mapper.ThreadMapper;
import so.sonya.muswebapp2.repository.ThreadRepository;
import so.sonya.muswebapp2.service.ThreadService;
import so.sonya.muswebapp2.model.Thread;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ThreadServiceImpl implements ThreadService {
    private final ThreadRepository repository;
    private final ThreadMapper mapper;

    @Override
    public ThreadResponse findById(UUID id) {
        return mapper.toResponse(
                repository.findById(id)
                            .orElseThrow(ThreadNotFoundException::new));
    }

    @Override
    public ThreadResponse findByAuthorId(UUID authorId) {
        return mapper.toResponse(
                repository.findByAuthorId(authorId)
                            .orElseThrow(ThreadNotFoundException::new));
    }

    @Override
    public ThreadResponse findByTitle(String title) {
        return mapper.toResponse(
                repository.findByTitle(title)
                            .orElseThrow(ThreadNotFoundException::new));
    }

    @Override
    public ThreadResponse save(CreateThreadRequest createThreadRequest) {
        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(createThreadRequest)));
    }

    @Override
    public void deleteById(UUID id) {
       repository.deleteById(id);
    }

    @Override
    public ThreadResponse update(UUID uuid, UpdateThreadRequest updateThreadRequest) {
        Thread thread = repository.getReferenceById(uuid);
        mapper.update(thread, updateThreadRequest);
        return mapper.toResponse(repository.save(thread));
    }

    @Override
    public Page<ThreadResponse> findAll(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository
                .findAll(pageable)
                .map(mapper::toResponse);
    }
}
