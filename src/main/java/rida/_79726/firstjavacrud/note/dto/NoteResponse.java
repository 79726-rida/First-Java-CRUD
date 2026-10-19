package rida._79726.firstjavacrud.note.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;

@Schema(description = "A note returned by the API")
public record NoteResponse(
        Long id,
        String title,
        String content,
        Instant createdAt,
        Instant updatedAt
) {
}
