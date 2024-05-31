package so.sonya.muswebapp2.dto.request;

import java.util.UUID;

public record UpdateThreadRequest(
    UUID id,
    String title,
    String description
) { }
