package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	@Test
	public void testDefaultConstructor(){
		Coordinate c = new Coordinate();
		Assert.assertEquals( Double.NaN, c.getX(), GeometryFactory.EPSILON);
		Assert.assertEquals( Double.NaN, c.getY(), GeometryFactory.EPSILON);
	}

	@Test
	public void testConstructor(){
		double coordX = 1.0;
		double coordY = 2.0;
		Coordinate c = new Coordinate(coordX,coordY);
		Assert.assertEquals( coordX, c.getX(), GeometryFactory.EPSILON);
		Assert.assertEquals( coordY, c.getY(), GeometryFactory.EPSILON);
	}

	@Test
	public void testIsEmpty(){
		Coordinate c = new Coordinate();
		Assert.assertTrue(c.isEmpty());
	}

}
