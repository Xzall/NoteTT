package com.example.notett;

import com.example.notett.model.Note;
import com.example.notett.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final NoteService noteService;

    @Autowired
    public DataInitializer(NoteService noteService) {
        this.noteService = noteService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (noteService.getAllNotes().isEmpty()) {
            Note testNote = new Note();
            testNote.setTitle("Тестовая заметка");
            testNote.setContent("Это тестовая заметка, созданная при первом запуске приложения");
            noteService.saveNote(testNote);
        }
    }
}