package com.vc.medium;

import java.util.*;

class TopVotedCandidate {

    TreeMap<Integer, Integer> timeToWinner = new TreeMap<Integer, Integer>();
    HashMap<Integer, Integer> leadToVotes = new HashMap<Integer, Integer>();
    int lead = -1;
    public TopVotedCandidate(int[] persons, int[] times) {
        for(int i = 0; i < persons.length; i++) {
            int person = persons[i];
            int time = times[i];
            leadToVotes.put(person, leadToVotes.getOrDefault(person, 0) + 1);

            //update the lead
            if(leadToVotes.get(person) >= leadToVotes.getOrDefault(lead, 0)) lead = person;

            //declare the winner for time t
            timeToWinner.put(times[i], lead);
        }
    }

    public int q(int t) {
        return timeToWinner.floorEntry(t).getValue();
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
