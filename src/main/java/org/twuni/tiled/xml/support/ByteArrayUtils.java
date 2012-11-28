package org.twuni.tiled.xml.support;

public class ByteArrayUtils {

	public static byte [] padLeft( byte [] array, int length ) {

		if( array.length >= length ) {
			return array;
		}

		byte [] buffer = new byte [length];
		System.arraycopy( array, 0, buffer, buffer.length - array.length, array.length );
		return buffer;

	}

	public static byte [] padRight( byte [] array, int length ) {

		if( array.length >= length ) {
			return array;
		}

		byte [] buffer = new byte [length];
		System.arraycopy( array, 0, buffer, 0, array.length );
		return buffer;

	}

	public static byte [] trim( byte [] array ) {
		int index = 0;
		for( int i = 0; i < array.length && array[i] == 0; i++ ) {
			index++;
		}
		if( index > 0 ) {
			return trim( array, array.length - index );
		}
		return array;
	}

	public static byte [] trim( byte [] array, int length ) {
		byte [] buffer = new byte [length];
		System.arraycopy( array, array.length - length, buffer, 0, length );
		return buffer;
	}

}
