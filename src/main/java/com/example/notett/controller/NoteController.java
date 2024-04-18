package com.example.notett.controller;

import com.example.notett.model.Note;
import com.example.notett.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public String listNotes(Model model) {
        List<Note> notes = noteService.getAllNotes();
        model.addAttribute("notes", notes);
        return "index";
    }

    @GetMapping("/note/{id}")
    public String viewNote(@PathVariable Long id, Model model){
        Note note = noteService.getNoteById(id);
        model.addAttribute("note", note);
        return "view_note";
    }

    @GetMapping("/note/new")
    public String showCreateNoteForm(Model model) {
        model.addAttribute("note", new Note());
        return "create_note";
    }

    @PostMapping("/note/new")
    public String createNote(@ModelAttribute Note note){
        Boolean isBold = note.getIsBold();
        Boolean isItalic = note.getIsItalic();
        noteService.saveNote(note);
        return "redirect:/";
    }
    @GetMapping("/note/{id}/edit")
    public String showEditNoteForm(@PathVariable Long id, Model model) {
        Note note = noteService.getNoteById(id);
        model.addAttribute("note", note);
        return "edit_note";
    }

    @PostMapping("/note/{id}/edit")
    public String updateNote(@PathVariable Long id, @ModelAttribute Note note) {
        note.setId(id);
        noteService.saveNote(note);
        return "redirect:/";
    }

    @GetMapping("/note/{id}/delete")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNoteById(id);
        return "redirect:/";
    }
}
