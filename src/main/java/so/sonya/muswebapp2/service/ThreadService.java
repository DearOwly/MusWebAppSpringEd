package so.sonya.muswebapp2.service;

import so.sonya.muswebapp2.dto.request.CreateThreadRequest;
import so.sonya.muswebapp2.dto.request.UpdateThreadRequest;
import so.sonya.muswebapp2.dto.response.ThreadResponse;
import so.sonya.muswebapp2.service.base.GenericPagingService;
import so.sonya.muswebapp2.service.base.GenericService;
import so.sonya.muswebapp2.service.base.GenericUpdatingService;

import java.util.UUID;

public interface ThreadService extends
        GenericService<UUID, CreateThreadRequest, ThreadResponse>,
        GenericUpdatingService<UUID, UpdateThreadRequest, ThreadResponse>,
        GenericPagingService<ThreadResponse> {
    ThreadResponse findByAuthorId(UUID authorId);

    ThreadResponse findByTitle(String title);
}
