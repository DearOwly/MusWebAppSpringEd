package so.sonya.muswebapp2.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Сообщение в обсуждении")
public class MessageDto {
    @Schema(description = "Уникальный идентификатор сообщения", example = "1ee88313-424a-49d0-b80b-f30c5d793d6a")
    UUID id;
    @Schema(description = "Текст сообщения")
    String text;
    @Schema(description = "Уникальный идентификатор автора сообщения", example = "1ee88313-424a-49d0-b80b-f30c5d793d6a")
    UUID authorId;
}
