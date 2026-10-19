package rida._79726.firstjavacrud.note;

public class NoteNotFoundException extends RuntimeException {

    public NoteNotFoundException(Long id) {
        super("Note not found with id: " + id);
    }
}
