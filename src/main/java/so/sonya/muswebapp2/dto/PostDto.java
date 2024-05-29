package so.sonya.muswebapp2.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Пост в профиле")
public class PostDto {
    @Schema(description = "Уникальный идентификатор поста")
    UUID id;
    @Schema(description = "Текст поста")
    String text;
    @Schema(description = "Уникальный идентификатор автора поста", example = "Название")
    UUID authorId;
}
