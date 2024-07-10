package com.embarkx.ChallengeApp.Repo;

import com.embarkx.ChallengeApp.Entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    Optional<Challenge> findByMonthIgnoreCase(String month);

    Optional<List<Challenge>> findAllByDescription(String month);
}
