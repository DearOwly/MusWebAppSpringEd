package so.sonya.muswebapp2.service;

import so.sonya.muswebapp2.dto.request.LikeRequest;

import java.util.UUID;

public interface CommentService {
    void like(LikeRequest request, UUID userId);
}
