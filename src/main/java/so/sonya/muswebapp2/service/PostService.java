package so.sonya.muswebapp2.service;

import so.sonya.muswebapp2.dto.PostDto;

import java.util.UUID;

public interface PostService extends StandartService<PostDto, UUID>{
    PostDto findByAuthorId(UUID authorId);
}
