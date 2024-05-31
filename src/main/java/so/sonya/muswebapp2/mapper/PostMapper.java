package so.sonya.muswebapp2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import so.sonya.muswebapp2.dto.request.CreatePostRequest;
import so.sonya.muswebapp2.dto.request.UpdatePostRequest;
import so.sonya.muswebapp2.dto.response.PostResponse;
import so.sonya.muswebapp2.mapper.base.GenericUpdatingMapper;
import so.sonya.muswebapp2.model.Post;

@Mapper(componentModel = "spring")
public interface PostMapper extends GenericUpdatingMapper<Post, CreatePostRequest, UpdatePostRequest, PostResponse> {
    @Override
    @Mapping(source = "author.id", target = "authorId")
    PostResponse toResponse(Post post);

    @Override
    @Mapping(target = "id", ignore = true)
    Post update(@MappingTarget Post post, UpdatePostRequest updatePostRequest);
}
