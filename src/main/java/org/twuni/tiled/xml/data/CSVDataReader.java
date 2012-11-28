package org.twuni.tiled.xml.data;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class CSVDataReader implements DataReader {

	@Override
	public void read( XmlPullParser xml, int [] out ) throws XmlPullParserException, IOException {
		xml.next();
		String [] csv = xml.getText().trim().replaceAll( "\n", "" ).split( "," );
		for( int i = 0; i < csv.length; i++ ) {
			out[i] = Integer.parseInt( csv[i] );
		}
	}

}
