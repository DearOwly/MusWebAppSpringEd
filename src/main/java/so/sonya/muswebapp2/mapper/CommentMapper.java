package so.sonya.muswebapp2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import so.sonya.muswebapp2.dto.request.EditCommentRequest;
import so.sonya.muswebapp2.dto.request.PostCommentRequest;
import so.sonya.muswebapp2.dto.response.CommentResponse;
import so.sonya.muswebapp2.mapper.base.UpdatingEntityMapper;
import so.sonya.muswebapp2.mapper.config.EntityMapperConfig;
import so.sonya.muswebapp2.model.Comment;

@Mapper(config = EntityMapperConfig.class)
public interface CommentMapper
    extends UpdatingEntityMapper<Comment, PostCommentRequest, EditCommentRequest, CommentResponse> {
    @Override
    @Mapping(source = "author.id", target = "authorId")
    CommentResponse toResponse(Comment comment);

    @Override
    @Mapping(target = "id", ignore = true)
    Comment update(@MappingTarget Comment comment, EditCommentRequest updateCommentRequest);
}
