package edu.nd.se2018.homework.hwk3;

import java.awt.Point;

import java.util.Observable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ship extends Observable{
	
	int[][] oceanMap; //keeps track of objects
	Image shipImage;
	ImageView shipImageView;
	
	Point position;
	int boardSize;
	int borderSize;
	int ratio;

	
	public Ship(int d, int size, int[][] map) {
		oceanMap = map;
		boardSize = d;
		borderSize = size;
		ratio = borderSize / boardSize;
		position = new Point(12,12);
		shipImage = new Image("images\\ColumbusShip.png",size,size,true,true);
		shipImageView = new ImageView(shipImage);
	}

	public ImageView getImageView(){
		return shipImageView;
	}
	
	public Point getShipLocation() {
		return position;
	}
	
	public void goEast() {
		if (position.x < boardSize - 1 && oceanMap[position.x + 1][position.y] == 0) { //sees if it goes outof bound and for island
			position.x++;
		}
		setChanged();
	}
	public void goWest() {
		if (position.x > 0 && oceanMap[position.x - 1][position.y] == 0) {
			position.x--;
		}
		setChanged();
	}
	public void goNorth() {
		if (position.y > 0 && oceanMap[position.x][position.y - 1] == 0) {
			position.y--;
		}
		setChanged();
	}
	public void goSouth() {
		if (position.y < boardSize - 1 && oceanMap[position.x][position.y + 1] == 0) {
			position.y++;
		}
		setChanged();
	}
}