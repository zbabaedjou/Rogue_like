package roguelike;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GenerUniversTest {

	private GenerUnivers gener;
	private GenerUnivers generation;
	private Univers Univ;
	
	
	@Before
	public void setUp() throws Exception {
		
		gener= new GenerUnivers(8,5);
		generation=new GenerUnivers(50,50);
		
		
	}

	@After
	public void tearDown() throws Exception {
	}
	

	@Test(expected= IllegalArgumentException.class)
	public void testrandomNumberInRangeException(){
		gener.getRandomNumberInRange(8,5);
	}
	
	@Test
	public void testrandomNumberInRange(){
		assertNotNull(generation.getRandomNumberInRange(5,50));
		
	}
	
	@Test
	public void testGeneration() {		
		assertNotNull(gener.randomizeElement());
		
	}
	
	@Test
	public void testGetUnivers(){
		Univ=generation.generer();
		assertNotNull(Univ);

	}

	@Test
	public void walling(){
		gener.walling();
		assertEquals(gener.get_elements()[1][1],Objet.MUR);
	}
	
	/*@Test
	public void testAjoutEscalier(){
		int salles[][] =new int[50][50];

		generation.mazing();		
		generation.creerSalles(salles);
		generation.ajout_monstres(salles);
		generation.addEscalier(salles);
	}*/

}
