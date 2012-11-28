package org.twuni.tiled.xml.data;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public interface DataReader {

	public void read( XmlPullParser xml, int [] out ) throws IOException, XmlPullParserException;

}
