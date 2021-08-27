package com.github.lyllyannyfranca.consultacidadesapi.countries;

import com.github.lyllyannyfranca.consultacidadesapi.countries.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1/paises")
@AllArgsConstructor
public class CountryResource {

    @Autowired
    private final CountryRepository repository;

    @GetMapping
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
       Optional<Country> op = repository.findById(id);

       return op.isPresent() ? ResponseEntity.ok().body(op.get()) : ResponseEntity.notFound().build();
    }

}
