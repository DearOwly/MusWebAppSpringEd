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
@Schema(description = "Лайк")
public class LikeDto {
    @Schema(description = "Уникальный идентификатор лайка", example = "ecbc5124-6879-480e-a7d9-816ebb3bf93f")
    UUID id;
    @Schema(description = "Уникальный идентификатор поставившего")
    UUID authorId;
}
