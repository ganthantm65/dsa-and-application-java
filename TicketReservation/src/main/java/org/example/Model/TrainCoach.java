package org.example.Model;

import java.util.Arrays;

public class TrainCoach {
    private boolean[][] seatAllocations=new boolean[1][5];

    private String coachName;

    public TrainCoach(String coachName){
        this.coachName=coachName;
    }

    public String displaySeats(){
        String coach="";
        for (int k = 0; k < 1; k++) {
            for (int l = 0; l < 5; l++) {
                coach+=seatAllocations[k][l]+"\t";
            }
            coach += "\n";
        }
        return coach;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public boolean[][] getSeatAllocations() {
        return seatAllocations;
    }

    public void setSeatAllocations(boolean[][] seatAllocations) {
        this.seatAllocations = seatAllocations;
    }
}