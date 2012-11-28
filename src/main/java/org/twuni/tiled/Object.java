package org.twuni.tiled;

import java.util.ArrayList;
import java.util.List;

import org.twuni.tiled.support.Rect;

public class Object {

	private String name;
	private String type;
	private final Rect bounds = new Rect();
	private final List<Property> properties = new ArrayList<Property>();

	public Rect getBounds() {
		return bounds;
	}

	public String getName() {
		return name;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public String getProperty( String propertyName ) {
		return getProperty( propertyName, null );
	}

	public String getProperty( String propertyName, String defaultValue ) {
		for( Property property : properties ) {
			if( propertyName.equals( property.getName() ) ) {
				return property.getValue();
			}
		}
		return defaultValue;
	}

	public String getType() {
		return type;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public void setType( String type ) {
		this.type = type;
	}

}
