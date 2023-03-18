package homework.services;

import homework.note.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final List<Note> notes;

    public List<Note> listAll() {
        return notes;
    }

    public Note add(Note note) {
        note.setId(UUID.randomUUID().variant());
        notes.add(note);
        return note;
    }

    public void deleteById(long id) {
        Note note = notes.stream().filter(n -> n.getId() == id).findFirst().orElse(null);
        if (note == null) {
            throw new IllegalArgumentException("Note with '" + id + "' does not exist");
        }
        notes.remove(note);
        System.out.println("Note with '" + id + "' was successfully deleted");
    }

    public void update(Note note) {
        int index = notes.indexOf(note);
        if (index == -1) {
            throw new IllegalArgumentException("Note with '" + note.getId() + "' does not exist");
        }
        notes.set(index, note);
        System.out.println("Note with '" + note.getId() + "' was successfully updated");
    }

    public Note getById(long id) {
        Note note = notes.stream().filter(n -> n.getId() == id).findFirst().orElse(null);
        if (note == null) {
            throw new IllegalArgumentException("Note with '" + id + "' does not exist");
        }
        return note;
    }
}
