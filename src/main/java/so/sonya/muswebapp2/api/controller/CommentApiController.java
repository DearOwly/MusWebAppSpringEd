package so.sonya.muswebapp2.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import so.sonya.muswebapp2.api.CommentApi;
import so.sonya.muswebapp2.dto.request.LikeRequest;
import so.sonya.muswebapp2.security.details.UserDetailsWithId;
import so.sonya.muswebapp2.service.CommentService;

@RestController
@RequiredArgsConstructor
public class CommentApiController implements CommentApi {
    private final CommentService service;

    @Override
    public void like(LikeRequest request, UserDetailsWithId user) {
        service.like(request, user.getId());
    }
}
