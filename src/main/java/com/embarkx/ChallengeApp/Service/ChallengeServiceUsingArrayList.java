package com.embarkx.ChallengeApp.Service;

import com.embarkx.ChallengeApp.Entity.Challenge;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeServiceUsingArrayList {

    private final List<Challenge> challengeList = new ArrayList<>();

    private Long nextId = 1L;

    public ChallengeServiceUsingArrayList(){
        Challenge challenge1 = new Challenge(1L, "April", "Learn New TechStack");
        challengeList.add(challenge1);

    }
    public boolean addChallenges(@RequestBody Challenge challenge){
        if(challenge!= null){
            challenge.setId(++nextId);
            challengeList.add(challenge);
//            return "Challenge added successfully";
//             return challenge;
            return true;
        }
        return false;
    }
    public List<Challenge> getChallengeList() {
        return challengeList;
    }

    public Challenge getChallenge(long id){
        for(Challenge challenge: challengeList){
            if((challenge.getId()).equals(id)){
                return challenge;
            }
        }
        return null;
    }
    public Challenge getChallengeByMonth(String month){
        for(Challenge challenge: challengeList){
            if((challenge.getMonth()).equalsIgnoreCase(month)){
                return challenge;
            }

        }

        return null;
    }

    public boolean updateChallenge(Long id, Challenge updateChallenge){
        for(Challenge challenge: challengeList){
            if(challenge.getId().equals(id)){
                challenge.setMonth(updateChallenge.getMonth());
                challenge.setDescription(updateChallenge.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenge(Long id){
      /*  for(Challenge challenge: challengeList){
            if (challenge.getId().equals(id)){
                challengeList.remove(challenge);
                return true;
            }
        }
        return false;  */

       return challengeList.removeIf(challenge -> challenge.getId().equals(id));
    }

}
