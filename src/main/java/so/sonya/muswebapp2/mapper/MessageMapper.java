package so.sonya.muswebapp2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import so.sonya.muswebapp2.dto.request.CreateMessageRequest;
import so.sonya.muswebapp2.dto.request.UpdateMessageRequest;
import so.sonya.muswebapp2.dto.response.MessageResponse;
import so.sonya.muswebapp2.mapper.base.GenericUpdatingMapper;
import so.sonya.muswebapp2.model.Message;

@Mapper(componentModel = "spring")
public interface MessageMapper extends GenericUpdatingMapper<Message, CreateMessageRequest, UpdateMessageRequest, MessageResponse> {
    @Override
    @Mapping(source = "author.id", target = "authorId")
    MessageResponse toResponse(Message message);

    @Override
    @Mapping(target = "id", ignore = true)
    Message update(@MappingTarget Message message, UpdateMessageRequest updateMessageRequest);
}
