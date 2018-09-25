package edu.nd.se2018.homework.hwk3;

import java.awt.Point;
import java.lang.Math;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Pirate implements Observer{
	
	
	int boardSize;
	int borderSize;
	int[][] oceanGrid;
	int ratio;
	
	
	Point positionShip;
	Point positionPirate;
	
	Image pirateImage;
	ImageView pirateImageView;
	
	Random rand = new Random();

	public Pirate(int s, int size, int[][] grid) {
		oceanGrid = grid;
		boardSize = s;
		borderSize = size;
		
		ratio = borderSize/boardSize;
		
		int coorX = rand.nextInt(boardSize);
		int coorY = rand.nextInt(boardSize);
		
		while (oceanGrid[coorX][coorY] == 1 || oceanGrid[coorX][coorY] == 2 || (coorX == 12 && coorY == 12)) {
			//search for unoccupied spot
			coorX = rand.nextInt(boardSize);
			coorY = rand.nextInt(boardSize);
		}
		oceanGrid[coorX][coorY] = 2;
		positionPirate = new Point(coorX, coorY);
		pirateImage = new Image("images\\pirateship.gif",ratio,ratio,true,true);	
		pirateImageView = new ImageView(pirateImage);
		
	}
	
	public ImageView getImageView(){
		return pirateImageView;
	}
	public Point getpositionPirate() {
		return positionPirate;
	}
	
	public void movePirate() {
		if (Math.abs(positionPirate.x - positionShip.x) >= Math.abs(positionPirate.y - positionShip.y)) {
			if (positionPirate.x - positionShip.x < 0) {
				if (oceanGrid[positionPirate.x + 1][positionPirate.y] == 0) {
					positionPirate.x++;
				}
			} else {
				if (oceanGrid[positionPirate.x - 1][positionPirate.y] == 0) {
					positionPirate.x--;
				}
			}
		} else {
			if (positionPirate.y - positionShip.y < 0) {
				if (oceanGrid[positionPirate.x][positionPirate.y + 1] == 0) {
					positionPirate.y++;
				}
			}
			else { 
				if (oceanGrid[positionPirate.x][positionPirate.y - 1] == 0) {
					positionPirate.y--;
				}
			}
		}
		pirateImageView.setX(ratio *positionPirate.x);
		
		pirateImageView.setY(ratio*positionPirate.y);	
		
		if (positionPirate.x == positionShip.x && positionPirate.y == positionShip.y) { 
			System.out.println("Ship is captured. Game Over.");
		}
	}
	
	@Override
	public void update(Observable s, Object arg1) {
		if (s instanceof Ship){
			positionShip = ((Ship)s).getShipLocation();
			movePirate();			
		}
	}
}