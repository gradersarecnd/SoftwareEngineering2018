package edu.nd.se2018.homework.hwk2;
import java.util.List;
import java.util.ArrayList;
import edu.nd.se2018.homework.hwk2.Car;
import edu.nd.se2018.homework.hwk2.raceStrategies.*;

public class Race {
	public Race() {}
	
	public void runTest() {
		Race race = new Race();
		
		List<Car> lineup = new ArrayList<Car>();
		//create test sample cars
		Car car0 = race.addCar("Lambo", 16, new EarlySprintStrategy());
		Car car1 = race.addCar("Rarri", 15, new SlowStartStrategy());
		Car car2 = race.addCar("Benz", 16, new SteadyRunStrategy());
		Car car3 = race.addCar("Gatti", 14, new SlowStartStrategy());
		Car car4 = race.addCar("Yota", 15, new EarlySprintStrategy());
		//add them to lineup
		lineup.add(car0);
		lineup.add(car1);
		lineup.add(car2);
		lineup.add(car3);
		lineup.add(car4);
		//race!
		race.startEngine(lineup);
		race.drive(lineup);
		System.out.println("Winner of the race: " + race.getFirstPlace(lineup) + "\n");	
	}
	
	public Car addCar(String name, float maxSpeed, RaceStrategy strategy) {
		Car car = new Car(name);
		car.setMaxSpeed(maxSpeed);
		
		car.setRaceStrategy(strategy);
		
		return car;
	}
	
	public void startEngine(List<Car> lineup) {
		System.out.println("Cars have begun racing!");
		System.out.println("---------------");
		for (Car car : lineup) {
			car.drive();
		}
	}
	
	public void drive(List<Car> lineup) {
		for (float i = 1; i <= 10; i++) {
			for (Car car: lineup) {
				car.displayStatus(i);
			}
			System.out.println("---------------");
		}
	}
	
	public String getFirstPlace(List<Car> cars) {
		float maxDist = -1;
		//sets back to 1
		String first = "";
		for (Car car : cars) { 
			
			if (car.getDist() > maxDist) {
				maxDist = car.getDist();
				first = car.getName();
			}
		}
		return first;
	}
	
}