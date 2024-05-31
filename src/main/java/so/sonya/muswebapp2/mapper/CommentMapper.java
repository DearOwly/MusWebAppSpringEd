package so.sonya.muswebapp2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import so.sonya.muswebapp2.dto.request.CreateCommentRequest;
import so.sonya.muswebapp2.dto.request.UpdateCommentRequest;
import so.sonya.muswebapp2.dto.response.CommentResponse;
import so.sonya.muswebapp2.mapper.base.GenericMapper;
import so.sonya.muswebapp2.mapper.base.GenericUpdatingMapper;
import so.sonya.muswebapp2.model.Comment;

@Mapper(componentModel = "spring")
public interface CommentMapper extends GenericUpdatingMapper<Comment, CreateCommentRequest, UpdateCommentRequest, CommentResponse> {
    @Override
    @Mapping(source = "author.id", target = "authorId")
    CommentResponse toResponse(Comment comment);

    @Override
    @Mapping(target = "id", ignore = true)
    Comment update(@MappingTarget Comment comment, UpdateCommentRequest updateCommentRequest);
}
