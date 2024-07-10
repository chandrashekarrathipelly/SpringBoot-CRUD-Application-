package com.embarkx.ChallengeApp.Service;

import com.embarkx.ChallengeApp.Repo.ChallengeRepository;
import com.embarkx.ChallengeApp.Entity.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeServiceUsingJDBC {

    @Autowired
    private ChallengeRepository challengeRepository;

    public boolean saveChallenge(Challenge challenge){
        if(challenge!=null){

            challengeRepository.save(challenge);
            return true;
        }
        return false;
    }

    public Challenge getChallenge(String month){
        return challengeRepository.findByMonthIgnoreCase(month).orElseThrow();
    }

    public Challenge getChallengeUsingMonth(String month){
        Optional<Challenge> challenge  = challengeRepository.findByMonthIgnoreCase(month);
        return challenge.orElse(null);
    }
    public List<Challenge> getChallengeUsingJDBC(String desc){
        return challengeRepository.findAllByDescription(desc).orElseThrow();
    }

    public boolean updateChallenge(Long id, Challenge updateChallenge){
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if(challenge.isPresent()){
            Challenge challengeToUpdate = challenge.get();
            challengeToUpdate.setDescription(updateChallenge.getDescription());
            challengeToUpdate.setMonth(updateChallenge.getMonth());
            challengeRepository.save(challengeToUpdate);
            return true;
        }
        return false;
    }

    public boolean deleteChallenge(Long id){
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if(challenge.isPresent()){
            challengeRepository.deleteById(id);
            return true;
        }
            return false;
    }
}
