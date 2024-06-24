package so.sonya.muswebapp2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import so.sonya.muswebapp2.dto.request.EditMessageRequest;
import so.sonya.muswebapp2.dto.request.PostMessageRequest;
import so.sonya.muswebapp2.dto.response.MessageResponse;
import so.sonya.muswebapp2.mapper.base.UpdatingEntityMapper;
import so.sonya.muswebapp2.mapper.config.EntityMapperConfig;
import so.sonya.muswebapp2.model.Message;

@Mapper(config = EntityMapperConfig.class)
public interface MessageMapper
    extends UpdatingEntityMapper<Message, PostMessageRequest, EditMessageRequest, MessageResponse> {
    @Override
    @Mapping(source = "author.id", target = "authorId")
    MessageResponse toResponse(Message message);

    @Override
    @Mapping(target = "id", ignore = true)
    Message update(@MappingTarget Message message, EditMessageRequest updateMessageRequest);
}
