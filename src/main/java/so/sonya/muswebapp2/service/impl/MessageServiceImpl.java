package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.dto.MessageDto;
import so.sonya.muswebapp2.exception.notFound.MessageNotFoundException;
import so.sonya.muswebapp2.mapper.MessageMapper;
import so.sonya.muswebapp2.repository.MessageRepository;
import so.sonya.muswebapp2.service.MessageService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    @Override
    public MessageDto findByAuthorId(UUID authorId) {
        return messageMapper.toDto(
                messageRepository.findByAuthor_Uuid(authorId)
                        .orElseThrow(() -> new MessageNotFoundException()));
    }

    @Override
    public MessageDto findById(UUID id) {
        return messageMapper.toDto(
                messageRepository.findById(id)
                        .orElseThrow(() -> new MessageNotFoundException()));
    }

    @Override
    public UUID save(MessageDto messageDto) {
        return messageRepository
                .save(messageMapper.toEntity(messageDto)).getUuid();
    }

    @Override
    public void deleteById(UUID  id) {
        messageRepository.deleteById(id);
    }

    @Override
    public MessageDto update(UUID uuid, MessageDto messageDto) {
        return null;
    }
}
