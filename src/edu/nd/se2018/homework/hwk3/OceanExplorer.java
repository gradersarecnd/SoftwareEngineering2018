package edu.nd.se2018.homework.hwk3;

import edu.nd.se2018.homework.hwk3.OceanMap;

import javafx.application.Application;
import javafx.event.EventHandler;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class OceanExplorer extends Application {
	
	BorderPane root;
	
	int numIsland = 10; //default 10
	int numPirate = 2;  //default 2
	int boardSize = 25;  //default 25
	int borderSize = 600; //default 600
	int ratio = borderSize/boardSize; //for scaling sizes
	
	OceanMap oceanMap;
	Scene scene;
	Ship ship;
	Pirate pirate;
	
	public void start(Stage primaryStage) {
		//check to see if everything can fit
		if (numIsland > boardSize*boardSize - (numPirate+1)) {
			
			System.out.println("Islands over limit");
			return;
		} else if (numPirate > boardSize * boardSize -(numIsland+1)) {
			System.out.println("Pirates over limit");
			return;
		}
		
		//Create map and ship
		root = new BorderPane();
		oceanMap = new OceanMap();
		oceanMap.drawMap(root.getChildren(), ratio, boardSize, numIsland);
		scene = new Scene(root,borderSize,borderSize);
		ship = new Ship(boardSize, borderSize, oceanMap.oceanGrid);
		ship.getImageView().setX(ship.getShipLocation().x * ratio);
		
		ship.getImageView().setY(ship.getShipLocation().y * ratio);
		root.getChildren().add(ship.shipImageView);
		
		// Pirates
		for(int j = 0; j < numPirate; j++) {
			pirate = new Pirate(boardSize, borderSize, oceanMap.oceanGrid);
			pirate.getImageView().setX(pirate.getPirateLocation().x * ratio);
			
			pirate.getImageView().setY(pirate.getPirateLocation().y * ratio);
			root.getChildren().add(pirate.pirateImageView);
			ship.addObserver(pirate);
		}
		
		primaryStage.setTitle("Island");
		primaryStage.setScene(scene);
		primaryStage.show();
		startSailing();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void startSailing(){
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()){
					case RIGHT:
						ship.goEast();
						break;
					case LEFT:
						ship.goWest();
						break;
					case UP:
						ship.goNorth();
						break;
					case DOWN:
						ship.goSouth();
						break;
					default:
						break;
				}
				ship.getImageView().setX(ship.getShipLocation().x * ratio);
				ship.getImageView().setY(ship.getShipLocation().y * ratio);
				
				ship.notifyObservers();
			}
		});
	}
}