package so.sonya.muswebapp2.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Сообщение в обсуждении")
public record MessageResponse(
    @Schema(description = "Уникальный идентификатор сообщения", example = "1ee88313-424a-49d0-b80b-f30c5d793d6a")
    UUID id,

    @Schema(description = "Текст сообщения")
    String text,

    @Schema(description = "Уникальный идентификатор автора сообщения", example = "1ee88313-424a-49d0-b80b-f30c5d793d6a")
    UUID authorId
) {}
