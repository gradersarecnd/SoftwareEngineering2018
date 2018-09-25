package edu.nd.se2018.homework.hwk2;

import edu.nd.se2018.homework.hwk2.raceStrategies.RaceStrategy;

public class Car {
	RaceStrategy raceStrategy;
	float maxSpeed;
	float distRun;
	String name;
	
	public Car(String name){
		this.name = name;
	}
	
	
	public float getDist() {
		return distRun;
	}
	
	public String getName() {
		
		return name;
	}
	
	
	public RaceStrategy getStrategy() {
		return raceStrategy;
	}
	
	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public void drive() {
		this.distRun = 0;
	}
		
	public void setRaceStrategy(RaceStrategy raceStrategy){
		
		this.raceStrategy = raceStrategy;
		
	}
		
	public void displayStatus(float currentDist) {
		float updatedist = raceStrategy.runRace(currentDist, maxSpeed);
		
		System.out.println("Location of "+this.name + ":\t" + this.distRun);
		
		this.distRun = this.distRun + updatedist;
	}
}
