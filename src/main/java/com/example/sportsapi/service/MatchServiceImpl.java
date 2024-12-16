package com.example.sportsapi.service;

import com.example.sportsapi.entity.Match;
import com.example.sportsapi.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public Match getMatchById(String id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Match not found with id " + id));
    }

    @Override
    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public Match updateMatch(String id, Match match) {
        Match existingMatch = matchRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Match not found with id " + id));

        existingMatch.setDescription(match.getDescription());
        existingMatch.setMatchDate(match.getMatchDate());
        existingMatch.setMatchTime(match.getMatchTime());
        existingMatch.setTeamA(match.getTeamA());
        existingMatch.setTeamB(match.getTeamB());
        existingMatch.setSport(match.getSport());

        return matchRepository.save(existingMatch);
    }

    @Override
    public void deleteMatch(String id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Match not found with id " + id));
        matchRepository.delete(match);
    }
}
