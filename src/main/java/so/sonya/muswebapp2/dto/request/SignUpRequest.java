package so.sonya.muswebapp2.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SignUpRequest(
    String email,

    @JsonProperty("given_name")
    String givenName,

    @JsonProperty("family_name")
    String familyName,

    @JsonProperty("nickname")
    String nickName,

    String password,

    @JsonProperty("password_confirmation")
    String passwordConfirmation
) {}
