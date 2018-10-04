package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		DateTime cetDateTime = new DateTime(2018, 10, 2, 10, 0);
		DateTime sydneyDateTime = TimeZoneTranslator.shiftTimeZone(cetDateTime, TimeZone.CENTRAL_EUROPEAN_TIME.getOffset(), TimeZone.SYDNEY.getOffset());
		assertEquals("2018-10-02 19:00", sydneyDateTime.toString());
	}

	@Test
	public void testShiftTimeZone2() {
		DateTime swedishTime = new DateTime(2016, 1, 1, 6, 0);
		DateTime usPacificCoastTime = TimeZoneTranslator.shiftTimeZone(swedishTime, TimeZone.CENTRAL_EUROPEAN_TIME.getOffset(), TimeZone.US_PACIFIC.getOffset());
		assertEquals("2015-12-31 21:00", usPacificCoastTime.toString());
	}
	
	@Test
	public void testShiftTimeZone3() {
		DateTime usPacificCoastTime = new DateTime(2015, 12, 31, 21, 0);
		DateTime swedishTime = TimeZoneTranslator.shiftTimeZone(usPacificCoastTime, TimeZone.US_PACIFIC.getOffset(), TimeZone.CENTRAL_EUROPEAN_TIME.getOffset());
		assertEquals("2016-01-01 06:00", swedishTime.toString());
	}
	
	@Test
	public void testShiftEventTimeZone() {
		DateTime LectureStart = new DateTime(2018, 8, 27, 8, 0);
		DateTime LectureEnd = new DateTime(2018, 8, 27, 9, 45);
		Person johannes = new Person("Johannes Schmidt");
		Person ragnar = new Person("Ragnar Nohre");
		Place HC218 = new Place("Hc218",57.7785672,14.1614833,20.0);
		
		Event firstOomLecture = new Event("OOM 2018 Lecture 1",
				LectureStart,
				LectureEnd,
				new HashSet<>(Arrays.asList(johannes, ragnar)),
				HC218);
		
		Event newFirstOomLecture = TimeZoneTranslator.shiftEventTimeZone(firstOomLecture, TimeZone.CENTRAL_EUROPEAN_TIME, TimeZone.SYDNEY);
		assertEquals("2018-08-27 17:00", newFirstOomLecture.getStartDate().toString());
		assertEquals("2018-08-27 18:45", newFirstOomLecture.getEndDate().toString());
	}

}
