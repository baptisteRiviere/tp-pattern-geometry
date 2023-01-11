package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){
		Coordinate c = new Coordinate();
		Assert.assertEquals( Double.NaN, c.getX(), EPSILON);
		Assert.assertEquals( Double.NaN, c.getY(), EPSILON);
	}

	@Test
	public void testConstructor(){
		double coordX = 1.0;
		double coordY = 2.0;
		Coordinate c = new Coordinate(coordX,coordY);
		Assert.assertEquals( coordX, c.getX(), EPSILON);
		Assert.assertEquals( coordY, c.getY(), EPSILON);
	}

	@Test
	public void testIsEmpty(){
		Coordinate c = new Coordinate();
		Assert.assertTrue(c.isEmpty());
	}

}
