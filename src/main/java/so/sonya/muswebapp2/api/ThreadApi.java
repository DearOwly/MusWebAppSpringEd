package so.sonya.muswebapp2.api;

import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import so.sonya.muswebapp2.dto.request.CreateThreadRequest;
import so.sonya.muswebapp2.dto.request.EditMessageRequest;
import so.sonya.muswebapp2.dto.request.PostMessageRequest;
import so.sonya.muswebapp2.dto.request.UpdateThreadRequest;
import so.sonya.muswebapp2.dto.response.MessageResponse;
import so.sonya.muswebapp2.dto.response.ThreadResponse;
import so.sonya.muswebapp2.security.details.UserDetailsWithId;

import java.util.UUID;

import static so.sonya.muswebapp2.api.util.Contants.THREAD_API_URL;

@Api(tags = "Thread | Обсуждение", value = "Thread")
@RequestMapping(THREAD_API_URL)
public interface ThreadApi {
    @GetMapping(value = "/list", params = {"!author_id"})
    Page<ThreadResponse> getAll(
        Pageable pageable
    );

    @GetMapping(value = "/list", params = {"author_id"})
    Page<ThreadResponse> getAllByAuthorId(
        @RequestParam("author_id")
        UUID authorId,

        Pageable pageable
    );

    @GetMapping("/get")
    ThreadResponse getById(
        @RequestParam
        UUID id
    );

    @PutMapping
    ThreadResponse create(
        @RequestBody
        @Valid
        CreateThreadRequest createThreadRequest,

        @AuthenticationPrincipal
        UserDetailsWithId user
    );

    @PatchMapping
    ThreadResponse update(
        @RequestBody
        @Valid
        UpdateThreadRequest updateThreadRequest,

        @AuthenticationPrincipal
        UserDetailsWithId user
    );

    @DeleteMapping
    void delete(
        @RequestParam
        UUID id,

        @AuthenticationPrincipal
        UserDetailsWithId user
    );

    @GetMapping("/{thread_id}")
    Page<MessageResponse> getMessages(
        @PathVariable("thread_id")
        UUID threadId,

        Pageable pageable
    );

    @PutMapping("/{thread_id}")
    MessageResponse postMessage(
        @PathVariable("thread_id")
        UUID threadId,

        @RequestBody
        @Valid
        PostMessageRequest postMessageRequest,

        @AuthenticationPrincipal
        UserDetailsWithId user
    );

    @PatchMapping("/{thread_id}")
    MessageResponse editMessage(
        @PathVariable("thread_id")
        UUID threadId,

        @RequestBody
        @Valid
        EditMessageRequest editMessageRequest,

        @AuthenticationPrincipal
        UserDetailsWithId user
    );

    @DeleteMapping("/{thread_id}")
    void deleteMessageById(
        @PathVariable("thread_id")
        UUID threadId,

        @RequestParam
        UUID id,

        @AuthenticationPrincipal
        UserDetailsWithId user
    );
}
