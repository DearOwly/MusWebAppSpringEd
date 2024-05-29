package so.sonya.muswebapp2.service;

import so.sonya.muswebapp2.dto.MessageDto;

import java.util.UUID;

public interface MessageService extends StandartService<MessageDto, UUID>{
    MessageDto findByAuthorId(UUID authorId);
}
