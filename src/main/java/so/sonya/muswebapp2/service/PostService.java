package so.sonya.muswebapp2.service;

import so.sonya.muswebapp2.dto.request.CreatePostRequest;
import so.sonya.muswebapp2.dto.request.UpdatePostRequest;
import so.sonya.muswebapp2.dto.response.PostResponse;
import so.sonya.muswebapp2.service.base.GenericPagingService;
import so.sonya.muswebapp2.service.base.GenericService;
import so.sonya.muswebapp2.service.base.GenericUpdatingService;

import java.util.UUID;

public interface PostService extends
        GenericService<UUID, CreatePostRequest, PostResponse>,
        GenericUpdatingService<UUID, UpdatePostRequest, PostResponse>,
        GenericPagingService<PostResponse>
{
    PostResponse findByAuthorId(UUID authorId);
}
