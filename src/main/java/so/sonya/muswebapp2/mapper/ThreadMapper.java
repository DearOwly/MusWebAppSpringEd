package so.sonya.muswebapp2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import so.sonya.muswebapp2.dto.ThreadDto;
import so.sonya.muswebapp2.model.ThreadEntity;

@Component
@Mapper(componentModel = "spring")
public interface ThreadMapper {
    @Mapping(source = "id", target = "uuid")
    @Mapping(source = "authorId", target = "author.uuid")
    ThreadEntity toEntity(ThreadDto threadDto);

    @Mapping(source = "uuid", target = "id")
    @Mapping(source = "author.uuid", target = "authorId")
    ThreadDto toDto(ThreadEntity threadEntity);
}
