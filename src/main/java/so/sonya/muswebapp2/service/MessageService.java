package so.sonya.muswebapp2.service;

import so.sonya.muswebapp2.dto.request.CreateMessageRequest;
import so.sonya.muswebapp2.dto.request.UpdateMessageRequest;
import so.sonya.muswebapp2.dto.request.UpdateUserRequest;
import so.sonya.muswebapp2.dto.response.MessageResponse;
import so.sonya.muswebapp2.service.base.GenericPagingService;
import so.sonya.muswebapp2.service.base.GenericService;
import so.sonya.muswebapp2.service.base.GenericUpdatingService;

import java.util.UUID;

public interface MessageService extends
        GenericService<UUID, CreateMessageRequest, MessageResponse>,
        GenericUpdatingService<UUID, UpdateMessageRequest, MessageResponse>,
        GenericPagingService<MessageResponse>
{
    MessageResponse findByAuthorId(UUID authorId);
}
