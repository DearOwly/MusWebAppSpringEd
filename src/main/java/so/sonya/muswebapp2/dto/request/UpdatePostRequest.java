package so.sonya.muswebapp2.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdatePostRequest(
    @NotNull
    UUID id,

    @Size(max = 255)
    String text
) {}
