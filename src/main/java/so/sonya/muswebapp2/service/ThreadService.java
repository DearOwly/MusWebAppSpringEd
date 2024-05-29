package so.sonya.muswebapp2.service;

import so.sonya.muswebapp2.dto.ThreadDto;

import java.util.UUID;

public interface ThreadService extends StandartService<ThreadDto, UUID>{
    ThreadDto findByAuthorId(UUID authorId);
    ThreadDto findByTitle(String title);
}
