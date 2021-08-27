package com.github.lyllyannyfranca.consultacidadesapi.states;

import com.github.lyllyannyfranca.consultacidadesapi.states.repository.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/estados")
@AllArgsConstructor
public class StateResource {

    private final StateRepository repository;

    @GetMapping
    public List<State> states() {
        return repository.findAll();
    }
}
