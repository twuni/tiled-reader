package org.twuni.tiled.xml.support;

import org.xmlpull.v1.XmlPullParser;

public enum Attribute {

	COMPRESSION( "compression" ),
	ENCODING( "encoding" ),
	FIRST_GID( "firstgid" ),
	GID( "gid" ),
	HEIGHT( "height" ),
	NAME( "name" ),
	ORIENTATION( "orientation" ),
	TILE_HEIGHT( "tileheight" ),
	TILE_WIDTH( "tilewidth" ),
	TYPE( "type" ),
	VISIBLE( "visible" ),
	WIDTH( "width" ),
	X( "x" ),
	Y( "y" );

	private static boolean isEmpty( String value ) {
		return value == null || "".equals( value );
	}

	private final String name;

	private Attribute( String name ) {
		this.name = name;
	}

	public float getFloat( XmlPullParser xml, float defaultValue ) {
		return Float.parseFloat( getString( xml, Float.toString( defaultValue ) ) );
	}

	public int getInt( XmlPullParser xml, int defaultValue ) {
		return Integer.parseInt( getString( xml, Integer.toString( defaultValue ) ) );
	}

	public String getString( XmlPullParser xml ) {
		return getString( xml, null );
	}

	public String getString( XmlPullParser xml, String defaultValue ) {
		String value = xml.getAttributeValue( null, name );
		return isEmpty( value ) ? defaultValue : value;
	}

}
