package org.twuni.tiled.xml.data;

import java.io.IOException;

import org.twuni.tiled.xml.support.Attribute;
import org.twuni.tiled.xml.support.Encoding;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class EncodedDataReader implements DataReader {

	private static final Base64DataReader BASE64 = new Base64DataReader();
	private static final CSVDataReader CSV = new CSVDataReader();
	private static final XMLDataReader XML = new XMLDataReader();

	@Override
	public void read( XmlPullParser xml, int [] out ) throws IOException, XmlPullParserException {

		Encoding encoding = Encoding.forValue( Attribute.ENCODING.getString( xml ) );

		switch( encoding ) {
			case BASE64:
				BASE64.read( xml, out );
				break;
			case CSV:
				CSV.read( xml, out );
				break;
			case NONE:
				XML.read( xml, out );
				break;
		}

	}

}
