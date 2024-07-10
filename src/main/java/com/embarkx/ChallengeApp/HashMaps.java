package com.embarkx.ChallengeApp;

import java.util.HashMap;

public class HashMaps {

    public static void main(String[] args) {
        HashMap<String, Integer> kalyan = new HashMap<>();

        kalyan.put("India",150);
        kalyan.put("china",144);
        kalyan.put("singpore", 12);
        kalyan.put("singpore", 13);

        System.out.println(kalyan.values());
        System.out.println(kalyan.keySet());
        System.out.println(kalyan);

        kalyan.remove("china");
        System.out.println(kalyan.keySet());
       System.out.println(kalyan.get("India"));

       // System.out.println(hashM.get("India"));
    }


}
