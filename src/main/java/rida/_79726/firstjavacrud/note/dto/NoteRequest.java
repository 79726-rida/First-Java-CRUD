package rida._79726.firstjavacrud.note.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Payload for creating or updating a note")
public record NoteRequest(

        @Schema(description = "Note title", example = "Grocery list")
        @NotBlank(message = "Title must not be blank")
        String title,

        @Schema(description = "Note content", example = "Milk, eggs, bread")
        String content
) {
}
