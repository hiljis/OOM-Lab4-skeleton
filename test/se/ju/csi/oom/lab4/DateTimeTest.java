package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		DateTime test = new DateTime(1988, 9, 28, 12, 5);
		DateTime test2 = new DateTime(test.toString());
		assertEquals(test.toString(), test2.toString());
	}

}
