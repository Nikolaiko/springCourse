package com.example.jokeapp.controllers;

import com.example.jokeapp.services.JokesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {
    private final JokesService jokesService;

    public JokesController(JokesService jokesService) {
        this.jokesService = jokesService;
    }

    @RequestMapping("/")
    public String getJokeView(Model model) {
        model.addAttribute("joke", jokesService.getRandomJoke());
        return "chucknorris";
    }
}
