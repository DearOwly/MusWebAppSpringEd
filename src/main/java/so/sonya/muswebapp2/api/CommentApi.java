package so.sonya.muswebapp2.api;

import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import so.sonya.muswebapp2.dto.request.LikeRequest;
import so.sonya.muswebapp2.security.details.UserDetailsWithId;

import static so.sonya.muswebapp2.api.util.Contants.COMMENT_API_URL;

@Api(tags = "Comment | Комментарий", value = "Comment")
@RequestMapping(COMMENT_API_URL)
public interface CommentApi {
    @PostMapping
    void like(
        @RequestBody
        @Valid
        LikeRequest request,

        @AuthenticationPrincipal
        UserDetailsWithId user
    );
}
