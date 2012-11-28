package org.twuni.tiled.xml.adapter;

import java.io.IOException;

import org.twuni.tiled.Object;
import org.twuni.tiled.xml.support.Attribute;
import org.twuni.tiled.xml.support.Tag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XMLObjectAdapter implements Adapter<XmlPullParser, Object> {

	private static final XMLPropertyAdapter PROPERTY = new XMLPropertyAdapter();

	@Override
	public Object adapt( XmlPullParser xml ) {

		Object object = new Object();

		object.setName( xml.getAttributeValue( null, "name" ) );
		object.setType( xml.getAttributeValue( null, "type" ) );
		object.getBounds().left = Attribute.X.getInt( xml, -1 );
		object.getBounds().top = Attribute.Y.getInt( xml, -1 );
		object.getBounds().bottom = object.getBounds().top + Attribute.HEIGHT.getInt( xml, 0 );
		object.getBounds().right = object.getBounds().left + Attribute.WIDTH.getInt( xml, 0 );

		try {

			for( int eventType = xml.next(); eventType != XmlPullParser.END_DOCUMENT; eventType = xml.next() ) {

				Tag tag = Tag.forName( xml.getName() );

				switch( eventType ) {
					case XmlPullParser.START_TAG:
						switch( tag ) {
							case PROPERTY:
								object.getProperties().add( XMLObjectAdapter.PROPERTY.adapt( xml ) );
								break;
							default:
								break;
						}
						break;
					case XmlPullParser.END_TAG:
						switch( tag ) {
							case OBJECT:
								return object;
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

		return object;

	}

}
