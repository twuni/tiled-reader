package org.twuni.tiled.xml.adapter;

import java.io.IOException;

import org.twuni.tiled.Layer;
import org.twuni.tiled.xml.data.EncodedDataReader;
import org.twuni.tiled.xml.support.Attribute;
import org.twuni.tiled.xml.support.Tag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XMLLayerAdapter implements Adapter<XmlPullParser, Layer> {

	private static final EncodedDataReader DATA = new EncodedDataReader();

	@Override
	public Layer adapt( XmlPullParser xml ) {

		Layer layer = new Layer();

		layer.setName( Attribute.NAME.getString( xml ) );
		layer.getSize().x = Attribute.WIDTH.getInt( xml, 0 );
		layer.getSize().y = Attribute.HEIGHT.getInt( xml, 0 );
		layer.setVisible( Attribute.VISIBLE.getInt( xml, 1 ) != 0 );

		try {

			for( int eventType = xml.next(); eventType != XmlPullParser.END_DOCUMENT; eventType = xml.next() ) {

				Tag tag = Tag.forName( xml.getName() );

				switch( eventType ) {
					case XmlPullParser.START_TAG:
						switch( tag ) {
							case DATA:
								DATA.read( xml, layer.getData() );
								break;
							default:
								break;
						}
						break;
					case XmlPullParser.END_TAG:
						switch( tag ) {
							case LAYER:
								return layer;
							default:
								break;
						}
				}
			}

		} catch( IOException exception ) {
			System.err.println( String.format( "[%s] %s", exception.getClass().getSimpleName(), exception.getMessage() ) );
			// TODO: Abort!
		} catch( XmlPullParserException exception ) {
			System.err.println( String.format( "[%s] %s", exception.getClass().getSimpleName(), exception.getMessage() ) );
			// TODO: Abort!
		}

		return layer;

	}

}
