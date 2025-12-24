package org.example.Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Train {
    private String name;
    private List<TrainCoach> coaches;
    private String trainCCT;
    private int noOfCoaches;
    private int totalSeats;
    private int availableSeats;
    private BlockingDeque<User> RAC;
    private BlockingDeque<User> WL;

    public Train(int noOfCoaches,String name,String trainCCT){
        this.name=name;
        this.noOfCoaches=noOfCoaches;
        coaches=new ArrayList<>(noOfCoaches);
        for (int i = 0; i < noOfCoaches; i++) {
            TrainCoach coach=new TrainCoach("S"+(i+1));
            coaches.add(coach);
        }
        this.trainCCT=trainCCT;
        totalSeats=5*4*noOfCoaches;
        this.availableSeats=totalSeats;
        this.RAC=new LinkedBlockingDeque<>(10);
        this.WL=new LinkedBlockingDeque<>(10);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TrainCoach> getCoaches() {
        return this.coaches;
    }

    public String getTrainCCT() {
        return trainCCT;
    }

    public void setTrainCCT(String trainCCT) {
        this.trainCCT = trainCCT;
    }

    public void setCoaches(List<TrainCoach> coaches) {
        this.coaches = coaches;
    }

    public int getNoOfCoaches() {
        return noOfCoaches;
    }

    public void setNoOfCoaches(int noOfCoaches) {
        this.noOfCoaches = noOfCoaches;
    }

    public int getTotalSeats() {
        return this.totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return this.availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public BlockingDeque<User> getRAC() {
        return RAC;
    }

    public void setRAC(BlockingDeque<User> RAC) {
        this.RAC = RAC;
    }

    public BlockingDeque<User> getWL() {
        return WL;
    }

    public void setWL(BlockingDeque<User> WL) {
        this.WL = WL;
    }
}
