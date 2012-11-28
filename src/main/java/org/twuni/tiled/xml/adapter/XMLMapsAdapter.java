package org.twuni.tiled.xml.adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.twuni.tiled.Map;
import org.twuni.tiled.xml.support.Tag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XMLMapsAdapter implements Adapter<XmlPullParser, List<Map>> {

	private static final XMLMapAdapter MAP = new XMLMapAdapter();

	@Override
	public List<Map> adapt( XmlPullParser xml ) {

		List<Map> maps = new ArrayList<Map>();

		try {
			for( int eventType = xml.next(); eventType != XmlPullParser.END_DOCUMENT; eventType = xml.next() ) {
				switch( eventType ) {
					case XmlPullParser.START_TAG:
						switch( Tag.forName( xml.getName() ) ) {
							case MAP:
								maps.add( MAP.adapt( xml ) );
								break;
							default:
								break;
						}
						break;
					default:
						break;
				}
			}
		} catch( IOException exception ) {
			// Abort!
		} catch( XmlPullParserException exception ) {
			// Abort!
		}

		return maps;

	}

}
