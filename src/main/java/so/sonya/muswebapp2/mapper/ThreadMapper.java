package so.sonya.muswebapp2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import so.sonya.muswebapp2.dto.request.CreateThreadRequest;
import so.sonya.muswebapp2.dto.request.UpdateThreadRequest;
import so.sonya.muswebapp2.dto.response.ThreadResponse;
import so.sonya.muswebapp2.mapper.base.GenericUpdatingMapper;
import so.sonya.muswebapp2.model.Thread;

@Mapper(componentModel = "spring")
public interface ThreadMapper extends GenericUpdatingMapper<Thread, CreateThreadRequest, UpdateThreadRequest, ThreadResponse> {
    @Override
    @Mapping(source = "author.id", target = "authorId")
    ThreadResponse toResponse(Thread thread);

    @Override
    @Mapping(target = "id", ignore = true)
    Thread update(@MappingTarget Thread thread, UpdateThreadRequest updateThreadRequest);
}
