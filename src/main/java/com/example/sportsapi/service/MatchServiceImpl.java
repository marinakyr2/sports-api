package com.example.sportsapi.service;

import com.example.sportsapi.dto.MatchDto;
import com.example.sportsapi.entity.Match;
import com.example.sportsapi.repository.MatchRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;
    private final ConversionService conversionService;

    public MatchServiceImpl(MatchRepository matchRepository, ConversionService conversionService) {
        this.matchRepository = matchRepository;
        this.conversionService = conversionService;
    }

    @Override
    public List<MatchDto> getAllMatches() {
        return matchRepository.findAll()
                .stream()
                .map(match -> conversionService.convert(match, MatchDto.class))
                .toList();
    }

    @Override
    public MatchDto getMatchById(String id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Match not found with id " + id));
        return conversionService.convert(match, MatchDto.class);
    }

    @Override
    public void createMatch(Match match) {
        matchRepository.save(match);
    }

    @Override
    public MatchDto updateMatch(String id, Match match) {
        Match existingMatch = matchRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Match not found with id " + id));
        existingMatch.setDescription(match.getDescription());
        existingMatch.setMatchDate(match.getMatchDate());
        existingMatch.setMatchTime(match.getMatchTime());
        existingMatch.setTeamA(match.getTeamA());
        existingMatch.setTeamB(match.getTeamB());
        existingMatch.setSport(match.getSport());
        return conversionService.convert(existingMatch, MatchDto.class);
    }

    @Override
    public void deleteMatch(String id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Match not found with id " + id));
        matchRepository.delete(match);
    }

}
