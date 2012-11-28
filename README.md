Tiled Map Reader
================

This project serves as an Android-compatible adaptation layer for the TMX file format, used by the map editor, [Tiled][1].

 [1]: http://mapeditor.org/

Usage
-----

On Android, just drop the map into your application's `res/xml` directory and add the following method to your activity:

    public static Map loadMap( Context context, int xmlResourceId ) {
      XMLMapsAdapter adapter = new XMLMapsAdapter();
      XmlPullParser xml = context.getResources().getXml( xmlResourceId );
      List<Map> maps = adapter.adapt( xml );
      return maps.isEmpty() ? null : maps.get( 0 );
    }

Now, for example, you can load `wilderness.tmx` like this:

    Map wilderness = loadMap( this, R.xml.wilderness );

Design
------

This library follows the Adapter pattern, converting from one type to another. In this case, we are converting `XmlPullParser` input
into a Tiled `Map` object.
