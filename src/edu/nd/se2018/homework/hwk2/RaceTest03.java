package edu.nd.se2018.homework.hwk2;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import edu.nd.se2018.homework.hwk2.Car;
import edu.nd.se2018.homework.hwk2.raceStrategies.*;

public class RaceTest03 {
	@Test
	public void test() {
		Race race = new Race();
		List<Car> lineup = new ArrayList<Car>();
		//Same race strategy, different speed
		
		Car car1 = race.addCar("Porche", 20, new EarlySprintStrategy());
		Car car2 = race.addCar("Jaguar", 15, new EarlySprintStrategy());

		lineup.add(car1);
		lineup.add(car2);
		race.startEngine(lineup);
		race.drive(lineup);
		assert(race.getFirstPlace(lineup)=="Porche"); 
		//car1 wins because of the obvious higher speed
		
		
		//SlowStartStrategy
		car1.setRaceStrategy(new SlowStartStrategy());
		car2.setRaceStrategy(new SlowStartStrategy());
		race.startEngine(lineup);
		race.drive(lineup);
		assert(race.getFirstPlace(lineup)=="Porche");
		
		//Both cars don't move
		
		car1.setMaxSpeed(0);
		car2.setMaxSpeed(0);
		race.startEngine(lineup);
		race.drive(lineup);
		assert(race.getFirstPlace(lineup)=="Porche"); 
		//Car0 automatically win first place since it is the first car and no car has moved
	}
}