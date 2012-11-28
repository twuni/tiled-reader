package org.twuni.tiled.support;

public class Rect {

	public int top;
	public int left;
	public int bottom;
	public int right;

	public Rect() {
	}

	public Rect( int left, int top, int right, int bottom ) {
		set( left, top, right, bottom );
	}

	public int centerX() {
		return left + width() / 2;
	}

	public int centerY() {
		return top + height() / 2;
	}

	public int height() {
		return bottom - top;
	}

	public void intersect( Rect other ) {
		left = Math.max( left, other.left );
		top = Math.max( top, other.top );
		right = Math.min( right, other.right );
		bottom = Math.min( bottom, other.bottom );
		if( right <= left || bottom <= top ) {
			set( 0, 0, 0, 0 );
		}
	}

	public void offset( int dx, int dy ) {
		set( left + dx, top + dy, right + dx, bottom + dy );
	}

	public void set( int left, int top, int right, int bottom ) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}

	public void set( Rect other ) {
		set( other.left, other.top, other.right, other.bottom );
	}

	public int width() {
		return right - left;
	}

}
