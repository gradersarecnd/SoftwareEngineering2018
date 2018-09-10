package edu.nd.se2018.homework.hwk2.raceStrategies;

public class SteadyRunStrategy implements RaceStrategy{

	@Override
	public float runRace(float dist, float speed) {
		
		return (float) (0.8 *speed);
	}

}