package edu.nd.se2018.homework.hwk2;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import edu.nd.se2018.homework.hwk2.Car;
import edu.nd.se2018.homework.hwk2.raceStrategies.*;

public class RaceTest02 {
	@Test
	public void test() {
		
		//Multiple cars with various maximum speed and strategies
		Race race = new Race();
		List<Car> lineup = new ArrayList<Car>();
				
		Car car1 = race.addCar("Benz", 120, new EarlySprintStrategy());
		Car car2 = race.addCar("Camaro", 126, new SteadyRunStrategy());
		Car car3 = race.addCar("Lambo", 107, new EarlySprintStrategy());
		Car car4 = race.addCar("Model3", 114, new SlowStartStrategy());
		Car car5 = race.addCar("Prius", 138, new SteadyRunStrategy());
		Car car6 = race.addCar("Genesis", 113, new EarlySprintStrategy());

		lineup.add(car1);
		lineup.add(car2);
		lineup.add(car3);
		lineup.add(car4);
		lineup.add(car5);
		lineup.add(car6);
		
		
		race.startEngine(lineup);
		race.drive(lineup);
		assert(race.getFirstPlace(lineup)=="Prius"); 
		//Winner has lower speed and slower start
		
		car5.setMaxSpeed(119);
		race.startEngine(lineup);
		race.drive(lineup);
		assert(race.getFirstPlace(lineup)=="Camaro"); 
		//Winner has highest speed with EarlySprintStrategy
		
	}
}