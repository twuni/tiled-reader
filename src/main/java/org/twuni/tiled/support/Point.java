package org.twuni.tiled.support;

public class Point {

	public static double length( int x, int y ) {
		return Math.sqrt( Math.pow( x, 2 ) + Math.pow( y, 2 ) );
	}

	public int x;
	public int y;

	public Point() {
	}

	public Point( int x, int y ) {
		this.x = x;
		this.y = y;
	}

	public boolean equals( int testX, int testY ) {
		return x == testX && y == testY;
	}

	public double length() {
		return length( x, y );
	}

	public void offset( int dx, int dy ) {
		x += dx;
		y += dy;
	}

	public void set( int x, int y ) {
		this.x = x;
		this.y = y;
	}

}
