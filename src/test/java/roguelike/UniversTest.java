package roguelike;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UniversTest {
	private int width;
	private int height;
	private Univers univers;
	public ElementUnivers[][] elements;
	@Before
	public void setUp() throws Exception {
		width=1;
		height=1;
		univers=new GenerUnivers(width, height)
			.generer();
		//univers=new Univers(width,height);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddMonstre() {
		
		univers.addMonstre();
		
	}

}
