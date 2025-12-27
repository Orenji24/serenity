package com.serenity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SerenityController {

    // Stores mood values (1–5)
    private List<Integer> moodHistory = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("moods", moodHistory);
        return "index";
    }

    @PostMapping("/addMood")
    public String addMood(@RequestParam("mood") int mood) {
        moodHistory.add(mood);
        return "redirect:/";
    }

    @GetMapping("/journal")
    public String journal() {
        return "journal";
    }

    @GetMapping("/resources")
    public String resources() {
        return "resources";
    }
}
