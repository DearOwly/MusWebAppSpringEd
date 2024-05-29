package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.dto.ThreadDto;
import so.sonya.muswebapp2.exception.notFound.ThreadNotFoundException;
import so.sonya.muswebapp2.mapper.ThreadMapper;
import so.sonya.muswebapp2.repository.ThreadRepository;
import so.sonya.muswebapp2.service.ThreadService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ThreadServiceImpl implements ThreadService {
    private final ThreadRepository threadRepository;
    private final ThreadMapper threadMapper;
    @Override
    public ThreadDto findById(UUID id) {
        return threadMapper.toDto(
                threadRepository.findById(id)
                        .orElseThrow(() -> new ThreadNotFoundException()));
    }

    @Override
    public UUID save(ThreadDto threadDto) {
        return threadRepository.save(
                threadMapper.toEntity(threadDto)).getUuid();
    }

    @Override
    public void deleteById(UUID id) {
       threadRepository.deleteById(id);
    }

    @Override
    public ThreadDto update(UUID uuid, ThreadDto threadDto) {
        return null;
    }

    @Override
    public ThreadDto findByAuthorId(UUID authorId) {
        return threadMapper.toDto(
                threadRepository.findByAuthor_Uuid(authorId)
                        .orElseThrow(() -> new ThreadNotFoundException()));
    }

    @Override
    public ThreadDto findByTitle(String title) {
        return threadMapper.toDto(
                threadRepository.findByTitle(title)
                        .orElseThrow(() -> new ThreadNotFoundException()));
    }
}
