package org.twuni.tiled.xml.adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.twuni.tiled.xml.support.Attribute;
import org.twuni.tiled.xml.support.Tag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XMLDataAdapter implements Adapter<XmlPullParser, List<Integer>> {

	private static int next( XmlPullParser xml ) {
		try {
			return xml.next();
		} catch( XmlPullParserException exception ) {
			throw new RuntimeException( exception );
		} catch( IOException exception ) {
			throw new RuntimeException( exception );
		}
	}

	@Override
	public List<Integer> adapt( XmlPullParser xml ) {

		List<Integer> values = new ArrayList<Integer>();

		for( int eventType = next( xml ); eventType != XmlPullParser.END_DOCUMENT; eventType = next( xml ) ) {

			Tag tag = Tag.forName( xml.getName() );

			switch( eventType ) {
				case XmlPullParser.START_TAG:
					switch( tag ) {
						case TILE:
							values.add( Integer.valueOf( Attribute.GID.getInt( xml, 0 ) ) );
							break;
						default:
							break;
					}
					break;
				case XmlPullParser.END_TAG:
					switch( tag ) {
						case DATA:
							return values;
						default:
							break;
					}
			}
		}

		return values;

	}

}
