package so.sonya.muswebapp2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import so.sonya.muswebapp2.dto.PostDto;
import so.sonya.muswebapp2.model.PostEntity;

@Component
@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(source = "id", target = "uuid")
    @Mapping(source = "authorId", target = "author.uuid")
    PostEntity toEntity(PostDto postDto);

    @Mapping(source = "uuid", target = "id")
    @Mapping(source = "author.uuid", target = "authorId")
    PostDto toDto(PostEntity postEntity);
}
