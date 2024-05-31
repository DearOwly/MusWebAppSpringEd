package so.sonya.muswebapp2.service;

import so.sonya.muswebapp2.dto.request.CreatePostRequest;
import so.sonya.muswebapp2.dto.response.PostResponse;
import so.sonya.muswebapp2.service.base.GenericService;

import java.util.UUID;

public interface PostService extends GenericService<UUID, CreatePostRequest, PostResponse> {
    PostResponse findByAuthorId(UUID authorId);
}
