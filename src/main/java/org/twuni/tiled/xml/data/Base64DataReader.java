package org.twuni.tiled.xml.data;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

import org.twuni.tiled.xml.support.Attribute;
import org.twuni.tiled.xml.support.Base64;
import org.twuni.tiled.xml.support.Compression;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class Base64DataReader implements DataReader {

	private static void read( InputStream in, int [] out ) throws IOException {
		byte [] buffer = new byte [out.length * 4];
		in.read( buffer, 0, buffer.length );
		in.close();
		for( int i = 0; i < out.length; i++ ) {
			out[i] = readIntLittleEndian( buffer, i * 4 );
		}
	}

	private static int readIntLittleEndian( byte [] buffer, int offset ) {
		int a = buffer[offset + 0] << 0 & 0x000000ff;
		int b = buffer[offset + 1] << 8 & 0x0000ff00;
		int c = buffer[offset + 2] << 16 & 0x00ff0000;
		int d = buffer[offset + 3] << 24 & 0xff000000;
		return a | b | c | d;
	}

	@Override
	public void read( XmlPullParser xml, int [] out ) throws IOException, XmlPullParserException {

		Compression compression = Compression.forValue( Attribute.COMPRESSION.getString( xml ) );

		xml.next();
		byte [] data = Base64.decode( xml.getText().trim() );

		switch( compression ) {
			case GZIP:
				read( new GZIPInputStream( new ByteArrayInputStream( data ) ), out );
				break;
			case ZLIB:
				read( new InflaterInputStream( new ByteArrayInputStream( data ) ), out );
				break;
			case NONE:
				read( new ByteArrayInputStream( data ), out );
				break;
		}

	}

}
