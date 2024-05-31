package so.sonya.muswebapp2.api;

import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import so.sonya.muswebapp2.dto.request.CreatePostRequest;
import so.sonya.muswebapp2.dto.request.UpdatePostRequest;
import so.sonya.muswebapp2.dto.response.PostResponse;

import java.util.UUID;

import static so.sonya.muswebapp2.api.util.Constants.POST_API_URL;

@Api(tags = "Post | П", value = "Post")
@RequestMapping(POST_API_URL)
public interface PostApi {
    PostResponse getById(@PathVariable("id") UUID id);
    Page<PostResponse> getAll(Integer pageNumber, Integer pageSize);
    PostResponse updateInfo(@RequestBody UpdatePostRequest updatePostRequest);
    PostResponse getByAuthorId(UUID authorId);
    void delete(UUID id);
    PostResponse create(@RequestBody CreatePostRequest createPostRequest);
}
