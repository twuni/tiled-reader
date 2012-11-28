package org.twuni.tiled.xml.support;

public enum Encoding {

	NONE( "" ),
	BASE64( "base64" ),
	CSV( "csv" );

	public static Encoding forValue( String value ) {
		for( Encoding encoding : Encoding.values() ) {
			if( encoding.value.equals( value ) ) {
				return encoding;
			}
		}
		return NONE;
	}

	private final String value;

	private Encoding( String value ) {
		this.value = value;
	}

}
