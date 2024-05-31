package so.sonya.muswebapp2.dto.request;

import java.util.UUID;

public record UpdateMessageRequest(
    UUID id,
    String text
) { }
