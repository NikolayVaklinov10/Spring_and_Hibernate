package com.nikolayvaklinov.SpringDemo;

public class BaseballCoach implements Coach {

    // define a private field for the dependency
    private FortuneService fortuneService;

    public BaseballCoach() {
    }

    // define a constructor for dependency injection
    public BaseballCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Speed 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {

        // use my fortuneService to get a fortune

        return fortuneService.getFortune();
    }
}
