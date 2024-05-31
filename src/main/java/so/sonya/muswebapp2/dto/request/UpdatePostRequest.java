package so.sonya.muswebapp2.dto.request;

import java.util.UUID;

public record UpdatePostRequest(
    UUID id,
    String text
) { }
