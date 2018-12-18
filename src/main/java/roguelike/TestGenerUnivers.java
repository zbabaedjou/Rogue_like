//Classe Test
package roguelike;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

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

}
