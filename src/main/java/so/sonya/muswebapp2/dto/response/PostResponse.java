package so.sonya.muswebapp2.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Пост в профиле")
public record PostResponse(
    @Schema(description = "Уникальный идентификатор поста")
    UUID id,

    @Schema(description = "Текст поста")
    String text,

    @Schema(description = "Уникальный идентификатор автора поста", example = "Название")
    UUID authorId
) {}
