package so.sonya.muswebapp2.api;


import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import so.sonya.muswebapp2.dto.request.CreateMessageRequest;
import so.sonya.muswebapp2.dto.request.UpdateMessageRequest;
import so.sonya.muswebapp2.dto.response.MessageResponse;

import java.util.UUID;

import static so.sonya.muswebapp2.api.util.Constants.MESSAGE_API_URL;

@Api(tags = "Message | Сообщение", value = "Message")
@RequestMapping(MESSAGE_API_URL)
public interface MessageApi {
    MessageResponse getById(@PathVariable("id") UUID id);
    Page<MessageResponse> getAll(Integer pageNumber, Integer pageSize);
    MessageResponse updateInfo(@RequestBody UpdateMessageRequest updateMessageRequest);
    MessageResponse getByAuthorId(UUID authorId);
    void delete(UUID id);
    MessageResponse create(@RequestBody CreateMessageRequest createMessageRequest);
}
