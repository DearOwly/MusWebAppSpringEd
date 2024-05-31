package so.sonya.muswebapp2.api;


import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import so.sonya.muswebapp2.dto.request.CreateThreadRequest;
import so.sonya.muswebapp2.dto.request.UpdateThreadRequest;
import so.sonya.muswebapp2.dto.response.ThreadResponse;

import java.util.UUID;

import static so.sonya.muswebapp2.api.util.Constants.THREAD_API_URL;

@Api(tags = "Thread | Обсуждение", value = "Thread")
@RequestMapping(THREAD_API_URL)
public interface ThreadApi {
    ThreadResponse getById(@PathVariable("id") UUID id);
    Page<ThreadResponse> getAll(Integer pageNumber, Integer pageSize);
    ThreadResponse updateInfo(@RequestBody UpdateThreadRequest updateThreadRequest);
    ThreadResponse getByAuthorId(UUID authorId);
    void delete(UUID id);
    ThreadResponse create(@RequestBody CreateThreadRequest createThreadRequest);
}
