package com.example.jokeapp.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokesService {
    private final ChuckNorrisQuotes chuckNorrisQuotes = new ChuckNorrisQuotes();

    public String getRandomJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}
