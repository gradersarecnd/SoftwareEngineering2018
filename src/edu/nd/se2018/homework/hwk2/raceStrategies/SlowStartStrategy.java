package edu.nd.se2018.homework.hwk2.raceStrategies;

public class SlowStartStrategy implements RaceStrategy{
	
	@Override
	public float runRace(float dist, float speed) {
		if (dist < 6)
			return (float) (speed * 0.75);
		else if (dist >= 6 && dist < 9)
			return (float) (0.9*speed);
		else
			return speed;
	}
	
}