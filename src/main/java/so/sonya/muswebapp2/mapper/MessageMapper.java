package so.sonya.muswebapp2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import so.sonya.muswebapp2.dto.MessageDto;
import so.sonya.muswebapp2.model.MessageEntity;

@Component
@Mapper(componentModel = "spring")
public interface MessageMapper {
    @Mapping(source = "uuid", target = "id")
    @Mapping(source = "author.uuid", target = "authorId")
    MessageDto toDto(MessageEntity messageEntity);

    @Mapping(source = "id", target = "uuid")
    @Mapping(source = "authorId", target = "author.uuid")
    MessageEntity toEntity(MessageDto messageDto);
}
