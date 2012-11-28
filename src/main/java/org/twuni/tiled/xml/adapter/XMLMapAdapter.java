package org.twuni.tiled.xml.adapter;

import java.io.IOException;

import org.twuni.tiled.Map;
import org.twuni.tiled.xml.support.Attribute;
import org.twuni.tiled.xml.support.Tag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XMLMapAdapter implements Adapter<XmlPullParser, Map> {

	private static final XMLLayerAdapter LAYER = new XMLLayerAdapter();
	private static final XMLObjectGroupAdapter OBJECT_GROUP = new XMLObjectGroupAdapter();
	private static final XMLPropertiesAdapter PROPERTIES = new XMLPropertiesAdapter();
	private static final XMLTilesetAdapter TILESET = new XMLTilesetAdapter();

	@Override
	public Map adapt( XmlPullParser xml ) {

		Map map = new Map();

		map.setOrientation( Attribute.ORIENTATION.getString( xml ) );
		map.getSize().y = Attribute.HEIGHT.getInt( xml, 0 );
		map.getSize().x = Attribute.WIDTH.getInt( xml, 0 );
		map.getTileSize().y = Attribute.TILE_HEIGHT.getInt( xml, 0 );
		map.getTileSize().x = Attribute.TILE_WIDTH.getInt( xml, 0 );

		try {

			for( int eventType = xml.next(); eventType != XmlPullParser.END_DOCUMENT; eventType = xml.next() ) {

				Tag tag = Tag.forName( xml.getName() );

				switch( eventType ) {
					case XmlPullParser.START_TAG:
						switch( tag ) {
							case TILESET:
								map.getTilesets().add( TILESET.adapt( xml ) );
								break;
							case LAYER:
								map.getLayers().add( LAYER.adapt( xml ) );
								break;
							case PROPERTIES:
								map.getProperties().addAll( PROPERTIES.adapt( xml ) );
								break;
							case OBJECT_GROUP:
								map.getObjectGroups().add( OBJECT_GROUP.adapt( xml ) );
								break;
							default:
								break;
						}
						break;
					case XmlPullParser.END_TAG:
						switch( tag ) {
							case MAP:
								return map;
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

		return map;

	}

}
