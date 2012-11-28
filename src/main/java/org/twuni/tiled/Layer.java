package org.twuni.tiled;

import org.twuni.tiled.support.Point;

public class Layer {

	private String name;
	private final Point size = new Point();
	private int [] data;
	private boolean visible;

	public int [] getData() {
		if( data == null || data.length != size.x * size.y ) {
			data = new int [size.x * size.y];
		}
		return data;
	}

	public String getName() {
		return name;
	}

	public Point getSize() {
		return size;
	}

	public int getTile( int x, int y ) {
		int index = size.x * y + x;
		return 0 <= index && index < getData().length ? getData()[index] : -1;
	}

	public boolean isEmpty() {
		if( data == null ) {
			return true;
		}
		for( int element : data ) {
			if( element != 0 ) {
				return false;
			}
		}
		return true;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public void setVisible( boolean visible ) {
		this.visible = visible;
	}

	@Override
	public String toString() {
		return String.format( "%s(%s)", getClass().getSimpleName(), name );
	}

}
