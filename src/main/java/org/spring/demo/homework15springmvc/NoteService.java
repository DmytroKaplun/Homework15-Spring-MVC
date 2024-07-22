package org.spring.demo.homework15springmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NoteService {
    private final Map<Long, Note> notes;
    private final Random r;
    private static final Logger logger = LoggerFactory.getLogger(NoteService.class);

    public NoteService() {
        this.notes = new HashMap<>();
        this.r = new Random();
        add(new Note(null, "Sample Note 1", "Content of Sample Note 1"));
        add(new Note(null, "Sample Note 2", "Content of Sample Note 2"));
        add(new Note(null, "Sample Note 3", "Content of Sample Note 3"));
        add(new Note(null, "Sample Note 4", "Content of Sample Note 4"));
    }

    public Note add(Note note) {
        note.setId(r.nextLong());
        notes.put(note.getId(), note);
        logger.info("Note added: {}", note);
        return note;
    }

    public Note getById(long id) {
        return Optional.ofNullable(notes.get(id)).orElseThrow(NoSuchElementException::new);
    }

    public void update(Note note) {
        if (notes.containsKey(note.getId())) {
            notes.put(note.getId(), note);
            logger.info("Note updated: {}", note);
        } else throw new NoSuchElementException();
    }

    public void deleteById(long id) {
        if (notes.containsKey(id)) {
            notes.remove(id);
            logger.info("Note deleted with id: {}", id);
        } else throw new NoSuchElementException();
    }

    public Optional<List<Note>> listAll() {
        List<Note> noteList = new ArrayList<>(notes.values());
        logger.info("Listing all notes: {}", noteList);
        return Optional.of(noteList);
    }
}
