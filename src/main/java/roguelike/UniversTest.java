package roguelike;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UniversTest {
	private Univers univ;
	private GenerUnivers gener;
	private PJ j;
	@Before
	public void setUp() throws Exception {
		gener=new GenerUnivers(50,50);
		univ=gener.generer();
		j= new PJ(1,1);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddPj() {
		assertEquals(univ.addPj().get_PV_actuel(),100);		
	}
	
	@Test
	public void testAddPjParamettre(){
		j.set_PV_actuel(5);
		assertEquals(univ.addPj(j).get_PV_actuel(),5);		

		
	}


}
