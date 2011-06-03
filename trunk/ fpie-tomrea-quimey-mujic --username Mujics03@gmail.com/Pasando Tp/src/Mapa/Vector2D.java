package Mapa;

//Codigo sacado de:"http://rememberjava.com/java2html/2002_49/4/Vector.shtml"

import java.awt.geom.Point2D;

/*
 * Representation of a vector in 2D user space
 */
public class Vector2D extends Point2D.Double
{
	private static final long serialVersionUID = 1L;

public Vector2D()
  {
    super();
  }

  public Vector2D( double x, double y )
  {
    super( x, y );
  }

  public Vector2D( Vector2D v )
  {
    this( v.x, v.y );
  }

  public double getLength()
  {
    return Math.sqrt( x*x + y*y );
  }

  /*
   * Returns the normalized vector of this Vector2D
   */
  public Vector2D normalize()
  {
    return new Vector2D( x/getLength(), y/getLength() );
  }

  /*
   * Normalize this Vector2D
   */
  public void normalizeThis()
  {
    Vector2D v = normalize();

    x = v.x;
    y = v.y;
  }

  /*
   * Returns the scaled vector of this Vector2D
   */
  public Vector2D scale( double s )
  {
    return new Vector2D( s*x, s*y );
  }

  /*
   * Scale this Vector2D
   */
  public void scaleThis( double s )
  {
    Vector2D v = scale(s);

    x = v.x;
    x = v.y;
  }
  
  /*
   * Adding other.x and other.y to x and y of this Vector2D
   */
  public void translate( Vector2D other )
  {
    x += other.x;
    y += other.y;
  }

  /*
   * Translates this point, at location (x, y),
   * by dx along the x axis and dy along the y axis
   * so that it now represents the point  (x + dx,  y + dy)
   */
  public void translate( double dx, double dy )
  {
    x += dx;
    y += dy;
  }



}
