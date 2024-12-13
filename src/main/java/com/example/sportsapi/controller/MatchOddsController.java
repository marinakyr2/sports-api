package com.example.sportsapi.controller;

import com.example.sportsapi.entity.MatchOdds;
import com.example.sportsapi.repository.MatchOddsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match-odds")
public class MatchOddsController {

    private final MatchOddsRepository matchOddsRepository;

    public MatchOddsController(MatchOddsRepository matchOddsRepository) {
        this.matchOddsRepository = matchOddsRepository;
    }

    @GetMapping
    public List<MatchOdds> getAllMatchOdds() {
        return matchOddsRepository.findAll();
    }

    @PostMapping
    public MatchOdds createMatchOdds(@RequestBody MatchOdds matchOdds) {
        return matchOddsRepository.save(matchOdds);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchOdds> getMatchOddsById(@PathVariable Long id) {
        return matchOddsRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchOdds> updateMatchOdds(@PathVariable Long id, @RequestBody MatchOdds matchOdds) {
        return matchOddsRepository.findById(id)
                .map(existingMatchOdds -> {
                    existingMatchOdds.setSpecifier(matchOdds.getSpecifier());
                    existingMatchOdds.setOdd(matchOdds.getOdd());
                    return ResponseEntity.ok(matchOddsRepository.save(existingMatchOdds));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMatchOdds(@PathVariable Long id) {
        return matchOddsRepository.findById(id)
                .map(matchOdds -> {
                    matchOddsRepository.delete(matchOdds);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}