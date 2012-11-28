package org.twuni.tiled;

import java.util.ArrayList;
import java.util.List;

import org.twuni.tiled.support.Point;

public class ObjectGroup {

	private String name;
	private final Point size = new Point();
	private final List<Object> objects = new ArrayList<Object>();

	public String getName() {
		return name;
	}

	public Object getObject( String objectName ) {
		for( Object object : objects ) {
			if( objectName.equals( object.getName() ) ) {
				return object;
			}
		}
		return null;
	}

	public List<Object> getObjects() {
		return objects;
	}

	public Point getSize() {
		return size;
	}

	public void setName( String name ) {
		this.name = name;
	}

}
