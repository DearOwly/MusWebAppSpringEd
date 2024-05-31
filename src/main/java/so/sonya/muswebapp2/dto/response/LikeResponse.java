package so.sonya.muswebapp2.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Лайк")
public record LikeResponse(
    @Schema(description = "Уникальный идентификатор лайка", example = "ecbc5124-6879-480e-a7d9-816ebb3bf93f")
    UUID id,

    @Schema(description = "Уникальный идентификатор поставившего")
    UUID authorId
) { }
