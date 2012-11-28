package org.twuni.tiled.xml.data;

import java.util.List;

import org.twuni.tiled.xml.adapter.XMLDataAdapter;
import org.xmlpull.v1.XmlPullParser;

public class XMLDataReader implements DataReader {

	private static final XMLDataAdapter ADAPTER = new XMLDataAdapter();

	@Override
	public void read( XmlPullParser xml, int [] out ) {
		List<Integer> data = ADAPTER.adapt( xml );
		for( int i = 0; i < data.size(); i++ ) {
			out[i] = data.get( i ).intValue();
		}
	}

}
