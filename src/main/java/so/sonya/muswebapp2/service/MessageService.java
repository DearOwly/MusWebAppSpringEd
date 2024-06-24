package so.sonya.muswebapp2.service;

import so.sonya.muswebapp2.dto.request.LikeRequest;

import java.util.UUID;

public interface MessageService {
    void like(LikeRequest request, UUID userId);
}
