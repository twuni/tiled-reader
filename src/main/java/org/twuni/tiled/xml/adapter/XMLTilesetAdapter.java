package org.twuni.tiled.xml.adapter;

import java.io.IOException;

import org.twuni.tiled.Tileset;
import org.twuni.tiled.xml.support.Attribute;
import org.twuni.tiled.xml.support.Tag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XMLTilesetAdapter implements Adapter<XmlPullParser, Tileset> {

	private final XMLImageAdapter image = new XMLImageAdapter();

	@Override
	public Tileset adapt( XmlPullParser xml ) {

		Tileset tileset = new Tileset();

		tileset.setOffset( Attribute.FIRST_GID.getInt( xml, 1 ) );
		tileset.setName( Attribute.NAME.getString( xml ) );
		tileset.getTileSize().x = Attribute.TILE_WIDTH.getInt( xml, -1 );
		tileset.getTileSize().y = Attribute.TILE_HEIGHT.getInt( xml, -1 );

		try {

			for( int eventType = xml.next(); eventType != XmlPullParser.END_DOCUMENT; eventType = xml.next() ) {

				Tag tag = Tag.forName( xml.getName() );

				switch( eventType ) {
					case XmlPullParser.START_TAG:
						switch( tag ) {
							case IMAGE:
								tileset.getImages().add( image.adapt( xml ) );
								break;
							default:
								break;
						}
						break;
					case XmlPullParser.END_TAG:
						switch( tag ) {
							case TILESET:
								return tileset;
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

		return tileset;

	}

}
