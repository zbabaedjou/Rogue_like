package roguelike;
//Classe Test/*

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;


//Teste qui verifie si  une des cases du tableau est null 
 
public class TestGenerUnivers {
private GenerUnivers gener;

	@Before
	public void setUp() throws Exception
	{
		gener=new GenerUnivers (5,9);
	}

	@Test
	public void test() 
	{
		Assert.assertNotNull (gener.randomizeElement()[1][2]);
	}
	
	/*@Test
	public void testajout_monstres() 
	{
		int[][] tab_salle=new int [1][3];
		int width;
		for (int x = 0; x < width; x++) 
		{
			int height;
			for (int y = 0; y < height; y++) 
			{
				gener.get_elements[x][y]=
			}
		}
		
		Assert.assertNotNull	gener.ajout_monstres(tab_salle);

			
	}
	
	*/
}
