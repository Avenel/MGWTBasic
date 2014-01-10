package de.hska.iwi.mgwt.demo.backend;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.model.NewsBoard;

public class IntranetConnectionTest {
	
	private static final String TUTORIALS = "/Intranetaccess/REST/tutorials/<stg>";
	
	private Intranet intra;

	@Before
	public void init() {
		intra = (Intranet) BackendFactory.createIntranetInstance();
	}
	
//	Verification if buildUrl works as expected
//	@Test
//	public void buildUrlSingleParam() {
//		String url = intra.buildUrl(TUTORIALS, Course.INFORMATIK_MASTER);
//		assertEquals("http://www.iwi.hs-karlsruhe.de/Intranetaccess/REST/tutorials/INFM", url);
//	}
	
	@Test
	public void testNews() {
		System.out.println("Moep");
		intra = (Intranet) BackendFactory.createIntranetInstance();
		List<NewsBoard> board = intra.getNewsBoard(Course.INFORMATIK_BACHELOR);
		
		assertEquals("", board.get(0).toString());
		System.out.println("Ready");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void newsException() {
		assertEquals("", intra.getNewsBoard(null).get(0).toString());
	}
	
	@Test
	public void tutorials() {
		assertEquals("", intra.getTutorials(Course.ALL).get(0).toString());
		
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
