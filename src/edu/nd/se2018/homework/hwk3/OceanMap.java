package edu.nd.se2018.homework.hwk3;

import java.util.Random;

import javafx.collections.ObservableList;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class OceanMap {
	Random rand = new Random();
	int[][] map; 
	
	public void drawMap(ObservableList<Node> root, int ratio, int boardSize, int numIsland) {
		map = new int[boardSize][boardSize];
		
		for (int x = 0; x < boardSize; x++) {
			for (int y = 0; y < boardSize; y++) {
				Rectangle rect = new Rectangle(ratio*x,ratio*y,ratio,ratio);
				rect.setStroke(Color.BLACK);
				
				rect.setFill(Color.PALETURQUOISE);
				root.add(rect);
				map[x][y] = 0;
				//fill with water
			}
		}
		for (int i = 0; i < numIsland; i++) {
			
			int xCoor = rand.nextInt(boardSize);
			int yCoor = rand.nextInt(boardSize);
			
			while (map[xCoor][yCoor] == 1 || (xCoor == 12 && yCoor == 12)) { //find island that is not already on map
				xCoor = rand.nextInt(boardSize);
				yCoor = rand.nextInt(boardSize);
			}
			
			Rectangle rect = new Rectangle(ratio*xCoor,ratio*yCoor,ratio,ratio);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.FORESTGREEN);
			root.add(rect);
			//1 for island
			map[xCoor][yCoor] = 1;
		}
	}
}