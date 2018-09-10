package edu.nd.se2018.homework.hwk2.raceStrategies;

public class EarlySprintStrategy implements RaceStrategy{
	
	@Override
	public float runRace(float dist, float speed) {
		if (dist < 2)
			return speed;
		else
			return (float) (0.75*speed);
	}
	
}