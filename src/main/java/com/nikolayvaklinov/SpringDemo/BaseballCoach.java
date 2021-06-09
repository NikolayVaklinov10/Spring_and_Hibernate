package com.nikolayvaklinov.SpringDemo;

public class BaseballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Speed 30 minutes on batting practice";
    }
}
