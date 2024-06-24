package so.sonya.muswebapp2.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Обсуждение")
public record ThreadResponse(
    @Schema(description = "Уникальный индентификатор обсуждения",
            example = "1ee88313-424a-49d0-b80b-f30c5d793d6a")
    UUID id,

    @Schema(description = "Название обсуждения",
            example = "Название/Title")
    String title,

    @Schema(description = "Описание обсуждения")
    String description,

    @Schema(description = "Уникальный идентификатор автора обсуждения")
    UUID authorId
) {}
