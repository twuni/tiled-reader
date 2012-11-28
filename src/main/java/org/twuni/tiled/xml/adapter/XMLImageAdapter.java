package org.twuni.tiled.xml.adapter;

import org.twuni.tiled.Image;
import org.xmlpull.v1.XmlPullParser;

public class XMLImageAdapter implements Adapter<XmlPullParser, Image> {

	@Override
	public Image adapt( XmlPullParser xml ) {

		Image image = new Image();

		image.setSource( xml.getAttributeValue( null, "source" ).replaceAll( "^(../)*(assets/)?", "" ) );
		image.setName( image.getSource().replaceAll( "(.+)(/[^/]*)?$", "$1" ) );

		return image;

	}

}
