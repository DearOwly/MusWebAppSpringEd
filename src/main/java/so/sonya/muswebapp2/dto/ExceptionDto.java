package so.sonya.muswebapp2.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Исключения")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExceptionDto {
    @Schema(description = "Сообщение об ошибке", example = "Пользователь не найден")
    String message;
    @Schema(description = "Код ошибки", example = "404")
    int status;
}
