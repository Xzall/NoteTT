package com.example.notett.service;

import com.example.notett.model.Note;
import com.example.notett.repository.NoteRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public void saveNote(Note note) {
        noteRepository.save(note);
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
