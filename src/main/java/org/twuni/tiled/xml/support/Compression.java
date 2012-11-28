package org.twuni.tiled.xml.support;

public enum Compression {

	NONE( "" ),
	GZIP( "gzip" ),
	ZLIB( "zlib" );

	public static Compression forValue( String value ) {
		for( Compression compression : Compression.values() ) {
			if( compression.value.equals( value ) ) {
				return compression;
			}
		}
		return NONE;
	}

	private final String value;

	private Compression( String value ) {
		this.value = value;
	}

}
