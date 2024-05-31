package so.sonya.muswebapp2.dto.request;

import java.util.UUID;

public record UpdateCommentRequest(
    UUID id,
    String text
) { }
