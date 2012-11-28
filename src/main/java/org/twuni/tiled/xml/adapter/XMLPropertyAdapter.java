package org.twuni.tiled.xml.adapter;

import org.twuni.tiled.Property;
import org.xmlpull.v1.XmlPullParser;

public class XMLPropertyAdapter implements Adapter<XmlPullParser, Property> {

	@Override
	public Property adapt( XmlPullParser xml ) {

		Property property = new Property();

		property.setName( xml.getAttributeValue( null, "name" ) );
		property.setValue( xml.getAttributeValue( null, "value" ) );

		return property;

	}

}
