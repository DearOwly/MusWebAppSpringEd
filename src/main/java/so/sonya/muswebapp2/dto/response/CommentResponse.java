package so.sonya.muswebapp2.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Комментарий")
public record CommentResponse(
    @Schema(description = "Уникальный индентификатор комментария")
    UUID id,

    @Schema(description = "Текст комментария")
    String text,

    @Schema(description = "Уникальный идентификатор автора комментария")
    UUID authorId
){}
