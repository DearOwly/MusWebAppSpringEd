package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.dto.request.CreateThreadRequest;
import so.sonya.muswebapp2.dto.response.ThreadResponse;
import so.sonya.muswebapp2.exception.ThreadNotFoundException;
import so.sonya.muswebapp2.mapper.ThreadMapper;
import so.sonya.muswebapp2.model.Thread;
import so.sonya.muswebapp2.repository.ThreadRepository;
import so.sonya.muswebapp2.service.ThreadService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ThreadServiceImpl implements ThreadService {
    private final ThreadRepository threadRepository;
    private final ThreadMapper threadMapper;

    @Override
    public ThreadResponse findById(UUID id) {
        return threadMapper.toResponse(
                threadRepository.findById(id)
                            .orElseThrow(ThreadNotFoundException::new));
    }

    @Override
    public ThreadResponse findByAuthorId(UUID authorId) {
        return threadMapper.toResponse(
                threadRepository.findByAuthorId(authorId)
                            .orElseThrow(ThreadNotFoundException::new));
    }

    @Override
    public ThreadResponse findByTitle(String title) {
        return threadMapper.toResponse(
                threadRepository.findByTitle(title)
                            .orElseThrow(ThreadNotFoundException::new));
    }

    @Override
    public ThreadResponse save(CreateThreadRequest createThreadRequest) {
        return threadMapper.toResponse(
                threadRepository.save(
                        threadMapper.toEntity(createThreadRequest)));
    }

    @Override
    public void deleteById(UUID id) {
       threadRepository.deleteById(id);
    }
}
