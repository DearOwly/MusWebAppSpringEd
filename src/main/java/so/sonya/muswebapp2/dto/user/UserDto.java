package so.sonya.muswebapp2.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Пользователь")
public class UserDto {
    @Schema(description = "Идентификатор пользователя", example = "ecbc5124-6879-480e-a7d9-816ebb3bf93f")
    UUID id;
    @Schema(description = "Никнейм", example = "IvanIvanov")
    String nickname;
    @Schema(description = "Почта", example = "example@gmail.com")
    String email;
}
