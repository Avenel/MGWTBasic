package de.hska.iwi.mgwt.demo.backend.connection;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.hska.iwi.mgwt.demo.backend.Intranet;
import de.hska.iwi.mgwt.demo.backend.constants.Course;

public class IntranetConnectionTest {
	
	private static final String TUTORIALS = "/Intranetaccess/REST/tutorials/<stg>";
	
	private Intranet intra;

	@Before
	public void init() {
		intra = new IntranetConnection();
	}
	
//	Verification if buildUrl works as expected
//	@Test
//	public void buildUrlSingleParam() {
//		String url = intra.buildUrl(TUTORIALS, Course.INFORMATIK_MASTER);
//		assertEquals("http://www.iwi.hs-karlsruhe.de/Intranetaccess/REST/tutorials/INFM", url);
//	}
	
	@Test
	public void news() {
		assertEquals("", intra.getNewsBoard(Course.INFORMATIK_BACHELOR).get(0).toString());
		System.out.println("Ready");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void newsException() {
		assertEquals("", intra.getNewsBoard(null).get(0).toString());
	}
	
	@Test
	public void tutorials() {
		assertEquals("", intra.getTutorials(Course.INFORMATIK_BACHELOR).get(0).toString());
		
		System.out.println("Ready");
	}
	
	@Test
	public void compulsory() {
		assertEquals("", intra.getCompulsoryOptionalSubjects(Course.INFORMATIK_BACHELOR).get(0).toString());
		System.out.println("Ready");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void compulsoryException() {
		assertEquals("", intra.getCompulsoryOptionalSubjects(null).get(0).toString());
		System.out.println("Ready");
	}
	
	@Test
	public void consultation() {
		assertEquals("", intra.getConsultationHours().get(0).toString());
		System.out.println("Ready");
	}

}
