package org.twuni.tiled.xml.adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.twuni.tiled.Property;
import org.twuni.tiled.xml.support.Tag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XMLPropertiesAdapter implements Adapter<XmlPullParser, List<Property>> {

	private static final XMLPropertyAdapter PROPERTY = new XMLPropertyAdapter();

	@Override
	public List<Property> adapt( XmlPullParser xml ) {

		List<Property> properties = new ArrayList<Property>();

		try {

			for( int eventType = xml.next(); eventType != XmlPullParser.END_DOCUMENT; eventType = xml.next() ) {

				Tag tag = Tag.forName( xml.getName() );

				switch( eventType ) {
					case XmlPullParser.START_TAG:
						switch( tag ) {
							case PROPERTY:
								properties.add( PROPERTY.adapt( xml ) );
								break;
							default:
								break;
						}
						break;
					case XmlPullParser.END_TAG:
						switch( tag ) {
							case PROPERTIES:
								return properties;
							default:
								break;
						}
				}
			}

		} catch( IOException exception ) {
			// TODO: Abort!
		} catch( XmlPullParserException exception ) {
			// TODO: Abort!
		}

		return properties;

	}

}
