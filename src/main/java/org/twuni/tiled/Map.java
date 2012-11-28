package org.twuni.tiled;

import java.util.ArrayList;
import java.util.List;

import org.twuni.tiled.support.Point;

public class Map {

	private String orientation;
	private final Point size = new Point();
	private final Point tileSize = new Point();
	private final List<Tileset> tilesets = new ArrayList<Tileset>();
	private final List<Layer> layers = new ArrayList<Layer>();
	private final List<ObjectGroup> objectGroups = new ArrayList<ObjectGroup>();
	private final List<Property> properties = new ArrayList<Property>();

	public Layer getLayer( String layerName ) {
		for( int i = 0; i < layers.size(); i++ ) {
			Layer layer = layers.get( i );
			if( layerName.equals( layer.getName() ) ) {
				return layer;
			}
		}
		return null;
	}

	public List<Layer> getLayers() {
		return layers;
	}

	public List<Layer> getLayersAfter( String layerName ) {
		List<Layer> after = new ArrayList<Layer>();
		boolean found = false;
		for( int i = 0; i < layers.size(); i++ ) {
			if( found ) {
				after.add( layers.get( i ) );
			} else if( layerName.equals( layers.get( i ).getName() ) ) {
				found = true;
			}
		}
		return after;
	}

	public List<Layer> getLayersUntil( String layerName ) {
		List<Layer> until = new ArrayList<Layer>();
		for( int i = 0; i < layers.size(); i++ ) {
			Layer layer = layers.get( i );
			if( layerName.equals( layer.getName() ) ) {
				return until;
			}
			until.add( layer );
		}
		return until;
	}

	public ObjectGroup getObjectGroup( String name ) {
		for( int i = 0; i < objectGroups.size(); i++ ) {
			ObjectGroup group = objectGroups.get( i );
			if( name.equals( group.getName() ) ) {
				return group;
			}
		}
		return null;
	}

	public List<ObjectGroup> getObjectGroups() {
		return objectGroups;
	}

	public String getOrientation() {
		return orientation;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public String getProperty( String key ) {
		return getProperty( key, null );
	}

	public String getProperty( String key, String defaultValue ) {

		for( int i = 0; i < properties.size(); i++ ) {
			Property property = properties.get( i );
			if( key.equals( property.getName() ) ) {
				return property.getValue();
			}
		}
		return defaultValue;
	}

	public Point getSize() {
		return size;
	}

	/**
	 * Computes the position of the tile located at the given coordinates and writes the result to
	 * out.
	 * 
	 * @param out
	 *            The position (in pixels) of the tile at the given coordinates will be written to
	 *            this object.
	 */
	public Point getTilePosition( int x, int y, Point out ) {
		if( isIsometric() ) {
			out.set( tileSize.x / 2 * ( size.x - 1 + x - y ), tileSize.y / 2 * ( y + x - 1 ) );
		} else {
			out.set( x * tileSize.x, y * tileSize.y );
		}
		return out;
	}

	/**
	 * Computes the position of the tile located at the given coordinates and writes the result to
	 * out.
	 * 
	 * @param tileCoordinate
	 *            The (x,y) position of the tile on the map (NOT the pixel coordinates).
	 * @param out
	 *            The position (in pixels) of the tile at the given coordinates will be written to
	 *            this object.
	 */
	public Point getTilePosition( Point tileCoordinate, Point out ) {
		return getTilePosition( tileCoordinate.x, tileCoordinate.y, out );
	}

	public Tileset getTileset( int tileIndex ) {
		Tileset tileset = null;
		for( int i = 0; i < tilesets.size(); i++ ) {
			Tileset candidate = tilesets.get( i );
			if( candidate.getOffset() > tileIndex ) {
				return tileset;
			}
			tileset = candidate;
		}
		return tileset;
	}

	public List<Tileset> getTilesets() {
		return tilesets;
	}

	public Point getTileSize() {
		return tileSize;
	}

	private boolean isIsometric() {
		return "isometric".equals( orientation );
	}

	public void setOrientation( String orientation ) {
		this.orientation = orientation;
	}

}
