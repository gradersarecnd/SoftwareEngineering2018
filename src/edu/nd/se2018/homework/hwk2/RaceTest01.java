package edu.nd.se2018.homework.hwk2;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import edu.nd.se2018.homework.hwk2.Car;
import edu.nd.se2018.homework.hwk2.raceStrategies.*;

public class RaceTest01 {
	@Test
	public void test() {
		//Test different categories, different speed
		
		Race race = new Race();
		List<Car> lineup = new ArrayList<Car>();

		Car car1 = race.addCar("Audi", 11, new EarlySprintStrategy());
		Car car2 = race.addCar("Chev", 11, new SlowStartStrategy());
		Car car3 = race.addCar("Musta", 11, new SteadyRunStrategy());
		lineup.add(car1);
		lineup.add(car2);
		lineup.add(car3);
		
		race.startEngine(lineup);
		race.drive(lineup);
		
		assert(race.getFirstPlace(lineup)=="Chev");
		//SlowStartStrategy wins
		
		
		//diff categories
		car1.setRaceStrategy(new SteadyRunStrategy());
		car2.setRaceStrategy(new EarlySprintStrategy());
		car3.setRaceStrategy(new SlowStartStrategy());
		
		race.startEngine(lineup);
		race.drive(lineup);
		
		assert(race.getFirstPlace(lineup)=="Musta");
		//SlowStartStrategy wins
	}
}