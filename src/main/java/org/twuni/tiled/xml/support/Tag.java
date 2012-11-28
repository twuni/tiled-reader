package org.twuni.tiled.xml.support;

public enum Tag {

	DATA( "data" ),
	IMAGE( "image" ),
	LAYER( "layer" ),
	MAP( "map" ),
	OBJECT( "object" ),
	OBJECT_GROUP( "objectgroup" ),
	PROPERTIES( "properties" ),
	PROPERTY( "property" ),
	TILE( "tile" ),
	TILESET( "tileset" );

	public static Tag forName( String name ) {
		for( Tag tag : Tag.values() ) {
			if( tag.getName().equals( name ) ) {
				return tag;
			}
		}
		return null;
	}

	private final String name;

	private Tag( String name ) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
