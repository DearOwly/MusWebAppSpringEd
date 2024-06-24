package so.sonya.muswebapp2.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateThreadRequest(
    @NotBlank
    @Size(max = 255)
    String title,

    @NotBlank
    @Size(max = 255)
    String description
) {}
