package org.twuni.tiled;

import java.util.ArrayList;
import java.util.List;

import org.twuni.tiled.support.Point;
import org.twuni.tiled.support.Rect;

public class Tileset {

	private int offset;
	private String name;
	private final Point tileSize = new Point();
	private final List<Image> images = new ArrayList<Image>();

	public Tileset() {
	}

	public Tileset( String source, int tileWidth, int tileHeight ) {
		images.add( new Image( source ) );
		tileSize.set( tileWidth, tileHeight );
	}

	public Tileset( String source, Point tileSize ) {
		this( source, tileSize.x, tileSize.y );
	}

	/**
	 * Retrieves the bounds for the given position in this tileset.
	 *
	 * @param out
	 *            The bounds will be written to this object.
	 */
	public void getBounds( int x, int y, Rect out ) {
		out.set( x, y - tileSize.y, x + tileSize.x, y );
	}

	public List<Image> getImages() {
		return images;
	}

	public String getName() {
		return name;
	}

	public int getOffset() {
		return offset;
	}

	public String getSource() {
		return images.isEmpty() ? null : images.get( 0 ).getSource();
	}

	public Point getTileSize() {
		return tileSize;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public void setOffset( int offset ) {
		this.offset = offset;
	}

}
