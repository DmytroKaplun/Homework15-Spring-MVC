package org.spring.demo.homework15springmvc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Note> noteList = noteService.listAll().orElseThrow(NoSuchElementException::new);
        modelAndView.addObject("action", "findAll");
        modelAndView.addObject("notes", noteList);
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView editNoteForm(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("action", "edit");
        Note byId = noteService.getById(id);
        modelAndView.addObject("note", byId);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}
