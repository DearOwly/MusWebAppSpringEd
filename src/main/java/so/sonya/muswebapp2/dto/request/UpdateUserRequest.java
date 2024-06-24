package so.sonya.muswebapp2.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdateUserRequest(
    @Size(min = 5, max = 255)
    String givenName,

    @Size(min = 5, max = 255)
    String familyName,

    @Size(min = 5, max = 255)
    String nickName
) {}
