package com.example.sportsapi.converters;

import com.example.sportsapi.dto.MatchDto;
import com.example.sportsapi.entity.Match;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MatchToDto implements Converter<Match, MatchDto> {

    @Override
    public MatchDto convert(Match match) {
        return new MatchDto(
                match.getId(),
                match.getDescription(),
                match.getMatchDate(),
                match.getMatchTime(),
                match.getTeamA(),
                match.getTeamB(),
                match.getSport());
    }

}
