package so.sonya.muswebapp2.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Форма входа")
public class SignInForm {
    @Schema(description = "Почта", example = "example@gmail.com")
    String email;
    @Schema(description = "Пароль", example = "password")
    String password;
}
