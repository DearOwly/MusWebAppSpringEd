package so.sonya.muswebapp2.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Пользователь")
public record UserResponse(
    @Schema(description = "Идентификатор пользователя", example = "ecbc5124-6879-480e-a7d9-816ebb3bf93f")
    UUID id,

    @Schema(description = "Имя", example = "Иван")
    String givenName,

    @Schema(description = "Фамилия", example = "Иванов")
    String familyName,

    @Schema(description = "Никнейм", example = "IvanIvanov")
    String nickName,

    @Schema(description = "Почта", example = "example@gmail.com")
    String email
) {}
