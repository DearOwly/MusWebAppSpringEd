package so.sonya.muswebapp2.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SignUpRequest(
    @Email
    String email,

    @NotBlank
    @Size(min = 5, max = 255)
    String givenName,

    @NotBlank
    @Size(min = 5, max = 255)
    String familyName,

    @NotBlank
    @Size(min = 5, max = 255)
    String nickName,

    // TODO: validate
    String password
) {}
