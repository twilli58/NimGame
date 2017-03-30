package edu.westga.cs6910.nim.tests.strategies;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.westga.nim.model.strategies.ExpertStrategy;
/**
 * test class for the expert Strategy
 * @author Tamiko Williams
 * @version 07/10/2014
 *
 */
public class WhenExpertStrategyDeterminesHowManySticks {
    private ExpertStrategy expert;
	/**
	 * before method
	 */
	@Before
	public void setUp() {
		this.expert = new ExpertStrategy();
	}

	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn1IfPileSizeIs2() {
		int results = this.expert.howManySticks(2);
		assertEquals(1, results);
	}
	/**
		 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
		 */
	@Test
	public void testShouldReturn2IfPileSizeIs3() {
		int results = this.expert.howManySticks(3);
		assertEquals(2, results);
	}
	
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn3IfPileSizeIs4() {
		int results = this.expert.howManySticks(4);
		assertEquals(3, results);
	}
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn1IfPileSizeIs5() {
		int results = this.expert.howManySticks(5);
		assertEquals(1, results);
	}
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn1IfPileSizeIs6() {
		int results = this.expert.howManySticks(6);
		assertEquals(1, results);
    }

	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn2IfPileSizeIs7() {
		int results = this.expert.howManySticks(7);
		assertEquals(2, results);
    }
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn3IfPileSizeIs8() {
		int results = this.expert.howManySticks(8);
		assertEquals(3, results);
    }
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn1IfPileSizeIs9() {
		int results = this.expert.howManySticks(9);
		assertEquals(1, results);
	}
	
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn1IfPileSizeIs10() {
		int results = this.expert.howManySticks(10);
		assertEquals(1, results);
	}
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn2IfPileSizeIs11() {
		int results = this.expert.howManySticks(11);
		assertEquals(2, results);
	}
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn2IfPileSizeIs12() {
		int results = this.expert.howManySticks(12);
		assertEquals(3, results);
	}
	
	
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn1IfPileSizeIs13() {
		int results = this.expert.howManySticks(13);
		assertEquals(1, results);
	}
	
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn1IfPileSizeIs14() {
		int results = this.expert.howManySticks(14);
		assertEquals(1, results);
	}
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn2IfPileSizeIs15() {
		int results = this.expert.howManySticks(15);
		assertEquals(2, results);
	}
	
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn3IfPileSizeIs16() {
		int results = this.expert.howManySticks(16);
		assertEquals(3, results);
	}
	
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn1IfPileSizeIs17() {
		int results = this.expert.howManySticks(17);
		assertEquals(1, results);
	}
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn1IfPileSizeIs18() {
		int results = this.expert.howManySticks(18);
		assertEquals(1, results);
	}
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn2IfPileSizeIs19() {
		int results = this.expert.howManySticks(19);
		assertEquals(2, results);
	}
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn3IfPileSizeIs20() {
		int results = this.expert.howManySticks(20);
		assertEquals(3, results);
	}
	
	/**
	 * Test method for {@link edu.westga.nim.model.strategies.ExpertStrategy#howManySticks(int)}.
	 */
	@Test
	public void testShouldReturn1IfPileSizeIs21() {
		int results = this.expert.howManySticks(21);
		assertEquals(1, results);
	}
	
	
}
