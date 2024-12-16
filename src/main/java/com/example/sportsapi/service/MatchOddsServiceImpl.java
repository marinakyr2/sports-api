package com.example.sportsapi.service;

import com.example.sportsapi.entity.MatchOdds;
import com.example.sportsapi.repository.MatchOddsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MatchOddsServiceImpl implements MatchOddsService {

    private final MatchOddsRepository matchOddsRepository;

    public MatchOddsServiceImpl(MatchOddsRepository matchOddsRepository) {
        this.matchOddsRepository = matchOddsRepository;
    }

    @Override
    public List<MatchOdds> getAllMatchOdds() {
        return matchOddsRepository.findAll();
    }

    @Override
    public MatchOdds createMatchOdds(@RequestBody MatchOdds matchOdds) {
        return matchOddsRepository.save(matchOdds);
    }


    @Override
    public MatchOdds getMatchOddsById(String id) {
        return matchOddsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Match Odd not found with id " + id));
    }

    @Override
    public MatchOdds updateMatchOdds(String id, MatchOdds matchOdds) {
        return matchOddsRepository.findById(id)
                .map(existingMatchOdds -> {
                    existingMatchOdds.setSpecifier(matchOdds.getSpecifier());
                    existingMatchOdds.setOdd(matchOdds.getOdd());
                    return matchOddsRepository.save(existingMatchOdds);
                })
                .orElseThrow(() -> new NoSuchElementException("Match Odd not found with id " + id));
    }

    @Override
    public void deleteMatchOdds(String id) {
        MatchOdds matchOdds = matchOddsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Match Odd not found with id " + id));
        matchOddsRepository.delete(matchOdds);
    }

}
