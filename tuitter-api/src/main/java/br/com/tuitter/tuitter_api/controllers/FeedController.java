package br.com.tuitter.tuitter_api.controllers;

import br.com.tuitter.tuitter_api.dtos.TuitterResponse;
import br.com.tuitter.tuitter_api.entities.Tuitter;
import br.com.tuitter.tuitter_api.repositories.TuitterRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedController {

    private final TuitterRepository tuitterRepository;

    public FeedController(TuitterRepository tuitterRepository) {
        this.tuitterRepository = tuitterRepository;
    }

    @GetMapping("/feed")
    public List<TuitterResponse> feed(){
        return tuitterRepository.findAll().stream().map(TuitterResponse::new).toList();
    }
}
