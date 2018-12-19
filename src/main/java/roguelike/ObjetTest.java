package roguelike;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ObjetTest {
	
	Univers univer;
	GenerUnivers gener;
	
	@Before
	public void setUp() throws Exception {
		gener = new GenerUnivers(50,50);
		gener.mazing();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testgetRandomElement() {
		assertNotNull(Objet.getRandomElement());
	}

	@Test
	public void testEstRemplacable(){
	
		assertFalse(((Objet)gener.get_elements()[1][2]).estRemplacable());
		assertTrue(!((Objet)gener.get_elements()[1][2]).estRemplacable());
	}
}
