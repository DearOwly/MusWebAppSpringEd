package so.sonya.muswebapp2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import so.sonya.muswebapp2.dto.request.*;
import so.sonya.muswebapp2.dto.response.MessageResponse;
import so.sonya.muswebapp2.dto.response.ThreadResponse;

import java.util.UUID;

public interface ThreadService {
    Page<ThreadResponse> findAll(Pageable pageable);

    ThreadResponse findById(UUID id);

    Page<ThreadResponse> findAllByAuthorId(UUID authorId, Pageable pageable);

    ThreadResponse create(CreateThreadRequest request, UUID authorId);

    ThreadResponse update(UpdateThreadRequest request, UUID authorId);

    void deleteById(UUID id, UUID authorId);

    Page<MessageResponse> findAllMessagesByThreadId(UUID id, Pageable pageable);

    MessageResponse postMessage(UUID id, PostMessageRequest request, UUID userId);

    MessageResponse editMessage(UUID id, EditMessageRequest request, UUID userId);

    void deleteMessageById(UUID id, UUID messageId, UUID userId);
}
