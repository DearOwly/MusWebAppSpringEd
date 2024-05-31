package so.sonya.muswebapp2.dto.request;

import java.util.UUID;

public record UpdateUserRequest(
    UUID id,
    String givenName,
    String familyName,
    String nickName
) {}
