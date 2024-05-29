package so.sonya.muswebapp2.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Комментарий")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentDto {
    @Schema(description = "Уникальный индентификатор комментария")
    UUID id;
    @Schema(description = "Текст комментария")
    String text;
    @Schema(description = "Уникальный идентификатор автора комментария")
    UUID authorId;
}
