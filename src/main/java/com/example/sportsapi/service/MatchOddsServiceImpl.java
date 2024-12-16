package com.example.sportsapi.service;

import com.example.sportsapi.dto.MatchDto;
import com.example.sportsapi.dto.MatchOddsDto;
import com.example.sportsapi.entity.Match;
import com.example.sportsapi.entity.MatchOdds;
import com.example.sportsapi.repository.MatchOddsRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MatchOddsServiceImpl implements MatchOddsService {

    private final MatchOddsRepository matchOddsRepository;
    private final ConversionService conversionService;

    public MatchOddsServiceImpl(MatchOddsRepository matchOddsRepository, ConversionService conversionService) {
        this.matchOddsRepository = matchOddsRepository;
        this.conversionService = conversionService;
    }

    @Override
    public List<MatchOddsDto> getAllMatchOdds() {

        return matchOddsRepository.findAll()
                .stream()
                .map(match -> conversionService.convert(match, MatchOddsDto.class))
                .toList();
    }

    @Override
    public void createMatchOdds(MatchOdds matchOdds) {
        matchOddsRepository.save(matchOdds);
    }


    @Override
    public MatchOddsDto getMatchOddsById(String id) {
        MatchOdds matchOdds=  matchOddsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Match Odd not found with id " + id));
    return conversionService.convert(matchOdds, MatchOddsDto.class);
    }

    @Override
    public MatchOddsDto updateMatchOdds(String id, MatchOdds matchOdds) {
        MatchOdds existingMatchOdds = matchOddsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Match not found with id " + id));
        existingMatchOdds.setId(matchOdds.getId());
        existingMatchOdds.setMatchId(matchOdds.getMatchId());
        existingMatchOdds.setOdd(matchOdds.getOdd());
        existingMatchOdds.setSpecifier(matchOdds.getSpecifier());
        return conversionService.convert(existingMatchOdds, MatchOddsDto.class); }

    @Override
    public void deleteMatchOdds(String id) {
        MatchOdds matchOdds = matchOddsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Match Odd not found with id " + id));
        matchOddsRepository.delete(matchOdds);
    }

}
