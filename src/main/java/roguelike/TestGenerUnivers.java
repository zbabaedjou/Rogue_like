//Class essaie
package roguelike;

import static org.junit.Assert.*;

import junit.framework.*;
import org.junit.Test;

public class TestGenerUnivers extends TestCase{
	 GenerUnivers gener;
	@Test
	public void test() 
	{
		
		
		 gener= new GenerUnivers (4,7);
		
	}
	public void testGenerer()
	{
		//Assert.assertNotNull (gener.randomizeElement());
		// c'est ca que tu voulais non ? 
		assertNotNull(gener.randomizeElement());
	}	
}
