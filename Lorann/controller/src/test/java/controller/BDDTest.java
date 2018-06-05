package controller;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Element;
import model.dao.ElementDAO;

public class BDDTest {
	private Element element;
	private List<Element> elements;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetElementByPos() {
		try
		{
			this.element = ElementDAO.getElementByPos(1, 1, 2);
			assertEquals(this.element.getType(), 'a');
		}
		catch (SQLException e)
		{
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void testGetAllElements() {
		try
		{
			this.elements = ElementDAO.getAllElements(1);
			assertEquals(this.elements.get(0).getType(), 'r');
		}
		catch (SQLException e)
		{
			fail("Not yet implemented");
		}
	}
}
