package org.twuni.tiled.xml.adapter;

public interface Adapter<From, To> {

	public To adapt( From from );

}
