package com.embarkx.ChallengeApp.Controller;

import com.embarkx.ChallengeApp.Service.ChallengeServiceUsingArrayList;
import com.embarkx.ChallengeApp.Service.ChallengeServiceUsingJDBC;
import com.embarkx.ChallengeApp.Entity.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    @Autowired
    private ChallengeServiceUsingJDBC challengeServiceUsingJDBC;

    private ChallengeServiceUsingArrayList challengeService;


    public ChallengeController(ChallengeServiceUsingArrayList challengeService){
        this.challengeService = challengeService;
        }

        @PostMapping("/save")
        public String saveChallenge(@RequestBody Challenge challenge){
        boolean isChallengeSaved = challengeServiceUsingJDBC.saveChallenge(challenge);
            if(isChallengeSaved){
                return "Challenge saved successfully";
            }
            return "challenge not saved ";
        }

    @PostMapping("/add")
    public String/*Challenge*/ addChallenges(@RequestBody Challenge challenge){
//        challengeList.add(challenge);
        boolean isChallengeAdded = challengeService.addChallenges(challenge);
        if(isChallengeAdded){
            return "Challenge added successfully";
        } else{
            return "challenge not added";
        }
        // challenge not added;

       // return challenge;
    }


    @GetMapping("/")
    public List<Challenge> getChallenges() {
        return challengeService.getChallengeList();
    }

    @GetMapping("/ById/{month}")
    public Challenge getChallenge(@PathVariable String month){
        return challengeServiceUsingJDBC.getChallenge(month);
    }

    @GetMapping("/ByDesc/{desc}")
    public List<Challenge> getChallenge2(@PathVariable String desc){
        return challengeServiceUsingJDBC.getChallengeUsingJDBC(desc);
    }

    @GetMapping("/ByMonth/{month}")
    public ResponseEntity<Challenge> getMonthlyChallenge(@PathVariable String month){
        Challenge challenge = challengeService.getChallengeByMonth(month);
        if(challenge!= null){
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updateChallenge){
        boolean isChallengeUpdated = challengeService.updateChallenge(id, updateChallenge);
        if(isChallengeUpdated){
            return new ResponseEntity<>("Challenge Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Challenge Not Updated",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable long id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if(isChallengeDeleted){
            return new ResponseEntity<>("Challenge Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Challenge Not Deleted",HttpStatus.NOT_FOUND);

    }

}
