package com.example.sportsapi.repository;

import com.example.sportsapi.entity.Match;
import com.example.sportsapi.entity.enums.Sport;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public class PopulateTables implements CommandLineRunner {

    private final MatchRepository matchRepository;
    private final MatchOddsRepository matchOddsRepository;

    public PopulateTables(MatchRepository matchRepository, MatchOddsRepository matchOddsRepository) {
        this.matchRepository = matchRepository;
        this.matchOddsRepository = matchOddsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        matchRepository.deleteAll();
        matchOddsRepository.deleteAll();

        Match match1 = new Match(
                "gwgew",
                LocalDate.now(),
                LocalTime.now(),
                "AA",
                "BB",
                Sport.BASKETBALL
        );
        Match match2 = new Match(
                "gwgew",
                LocalDate.now(),
                LocalTime.now(),
                "AA",
                "BB",
                Sport.FOOTBALL
        );
        matchRepository.saveAll(List.of(match1, match2));
    }

}
