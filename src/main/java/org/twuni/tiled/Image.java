package org.twuni.tiled;

public class Image {

	private String source;
	private String name;

	public Image() {
	}

	public Image( String source ) {
		setSource( source );
	}

	public String getName() {
		return name;
	}

	public String getSource() {
		return source;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public void setSource( String source ) {
		this.source = source;
	}

}
