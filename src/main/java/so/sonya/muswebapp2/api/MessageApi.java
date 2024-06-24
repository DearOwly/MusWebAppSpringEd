package so.sonya.muswebapp2.api;

import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import so.sonya.muswebapp2.dto.request.LikeRequest;
import so.sonya.muswebapp2.security.details.UserDetailsWithId;

import static so.sonya.muswebapp2.api.util.Contants.MESSAGE_API_URL;

@Api(tags = "Message | Сообщение", value = "Message")
@RequestMapping(MESSAGE_API_URL)
public interface MessageApi {
    @PostMapping
    void like(
        @RequestBody
        @Valid
        LikeRequest request,

        @AuthenticationPrincipal
        UserDetailsWithId user
    );
}
