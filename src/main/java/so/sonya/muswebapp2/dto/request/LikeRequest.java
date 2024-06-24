package so.sonya.muswebapp2.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LikeRequest(
    @NotNull
    UUID resourceId,

    @NotNull
    UUID id,

    @NotNull
    Boolean like
) {}
