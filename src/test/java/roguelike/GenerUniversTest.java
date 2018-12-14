package roguelike;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GenerUniversTest {
	private GenerUnivers gener;
	private Univers Univ;
	@Before
	public void setUp() throws Exception {
		gener= new GenerUnivers(5,8);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGeneration() {		
		Assert.assertNotNull(gener.randomizeElement());
		
	}
	
	@Test
	public void testGetUnivers(){
		Univ=gener.generer();
		Assert.assertNotNull(Univ.elements);
		for(int i=0;i<2;i++)
			for(int j=0;j<2;j++)
				System.out.println(Univ.elements[i][j].symbole());
	}

}
