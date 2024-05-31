package so.sonya.muswebapp2.service;

import so.sonya.muswebapp2.dto.request.CreateMessageRequest;
import so.sonya.muswebapp2.dto.response.MessageResponse;
import so.sonya.muswebapp2.service.base.GenericService;

import java.util.UUID;

public interface MessageService extends GenericService<UUID, CreateMessageRequest, MessageResponse> {
    MessageResponse findByAuthorId(UUID authorId);
}
