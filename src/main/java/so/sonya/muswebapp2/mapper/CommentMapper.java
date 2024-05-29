package so.sonya.muswebapp2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import so.sonya.muswebapp2.dto.CommentDto;
import so.sonya.muswebapp2.model.CommentEntity;

@Component
@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(source = "id", target = "uuid")
    @Mapping(source = "authorId", target = "author.uuid")
    CommentEntity toEntity(CommentDto commentDto);

    @Mapping(source = "uuid", target = "id")
    @Mapping(source = "author.uuid", target = "authorId")
    CommentDto toDto(CommentEntity commentEntity);
}
