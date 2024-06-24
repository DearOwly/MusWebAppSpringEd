package so.sonya.muswebapp2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import so.sonya.muswebapp2.dto.request.CreatePostRequest;
import so.sonya.muswebapp2.dto.request.UpdatePostRequest;
import so.sonya.muswebapp2.dto.response.PostResponse;
import so.sonya.muswebapp2.mapper.base.UpdatingEntityMapper;
import so.sonya.muswebapp2.mapper.config.EntityMapperConfig;
import so.sonya.muswebapp2.model.Post;

@Mapper(config = EntityMapperConfig.class)
public interface PostMapper
    extends UpdatingEntityMapper<Post, CreatePostRequest, UpdatePostRequest, PostResponse> {
    @Override
    @Mapping(source = "author.id", target = "authorId")
    PostResponse toResponse(Post post);

    @Override
    @Mapping(target = "id", ignore = true)
    Post update(@MappingTarget Post post, UpdatePostRequest updatePostRequest);
}
