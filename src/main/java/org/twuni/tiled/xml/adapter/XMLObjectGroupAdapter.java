package org.twuni.tiled.xml.adapter;

import java.io.IOException;

import org.twuni.tiled.ObjectGroup;
import org.twuni.tiled.xml.support.Attribute;
import org.twuni.tiled.xml.support.Tag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XMLObjectGroupAdapter implements Adapter<XmlPullParser, ObjectGroup> {

	private static final XMLObjectAdapter OBJECT = new XMLObjectAdapter();

	@Override
	public ObjectGroup adapt( XmlPullParser xml ) {

		ObjectGroup group = new ObjectGroup();

		group.setName( Attribute.NAME.getString( xml ) );
		group.getSize().x = Attribute.WIDTH.getInt( xml, 1 );
		group.getSize().y = Attribute.HEIGHT.getInt( xml, 1 );

		try {

			for( int eventType = xml.next(); eventType != XmlPullParser.END_DOCUMENT; eventType = xml.next() ) {

				Tag tag = Tag.forName( xml.getName() );

				switch( eventType ) {
					case XmlPullParser.START_TAG:
						switch( tag ) {
							case OBJECT:
								group.getObjects().add( OBJECT.adapt( xml ) );
								break;
							default:
								break;
						}
						break;
					case XmlPullParser.END_TAG:
						switch( tag ) {
							case OBJECT_GROUP:
								return group;
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

		return group;

	}

}
