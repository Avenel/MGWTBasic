package de.hska.iwi.mgwt.demo.backend.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpStatus;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestBuilder.Method;
import com.google.gwt.json.client.JSONArray;

import de.hska.iwi.mgwt.demo.backend.Intranet;
import de.hska.iwi.mgwt.demo.backend.constants.Canteen;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.IURLParameterEnum;
import de.hska.iwi.mgwt.demo.backend.model.CompulsoryOptionalSubjects;
import de.hska.iwi.mgwt.demo.backend.model.ConsultationHour;
import de.hska.iwi.mgwt.demo.backend.model.CourseTutorial;
import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;
import de.hska.iwi.mgwt.demo.backend.model.NewsBoard;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class IntranetConnection implements Intranet {
	
	private static final String BASE_URL = "http://www.iwi.hs-karlsruhe.de";
	
	private static final String TUTORIALS_ALL = "/Intranetaccess/REST/tutorials/";
	
	private static final String TUTORIALS = "/Intranetaccess/REST/tutorials/<stg>";
	
	private static final String CUMPOLSORY = "/Intranetaccess/REST/compulsoryoptionalsubjects/<stg>";
	
	private static final String NEWS_BOARD_ALL = "/Intranetaccess/REST/newsbulletinboard/";
	
	private static final String NEWS_BOARD = "/Intranetaccess/REST/newsbulletinboard/<stg>";
	
	private static final String LECTURER_HOURS = "/Intranetaccess/REST/lecturersconsultationhours/";
	
	private static final String BLOCK_COURSES = "/Intranetaccess/REST/blockcourses/<stg>";
	
	private static final String TIMETABLE = "/Intranetaccess/REST/timetable/<stg>/<sem>";
	
	private static final String WORKFLOW = "/Intranetaccess/REST/application/workflow/<veranst>";
	
	private static final String WORKFLOW_PROGRESS = "/Intranetaccess/REST/application/state/<veranst>";
	
	private static final String MENSA_MENU = "/Intranetaccess/REST/canteen/<id>/<date>";
	
	private static final String PARAM_PATTERN = "<.*>";
	
	private ObjectMapper mapper;
	
	private URL url;
		
	private Pattern pattern;

	public IntranetConnection() {
		pattern = Pattern.compile(PARAM_PATTERN);
		mapper = new ObjectMapper();
	}

	@Override
	public List<CourseTutorial> getTutorials(Course course) {
		List<CourseTutorial> tutorial = null;
		
		if (course == Course.ALL) {
			url = buildUrl(TUTORIALS_ALL);
		} else {
			url = buildUrl(TUTORIALS, course);
		}
		
		try {
			tutorial = mapper.readValue(requestJSON(url), new TypeReference<List<CourseTutorial>>(){});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tutorial;
	}

	@Override
	public List<NewsBoard> getNewsBoard(Course course) {
		if (course == null) {
			throw new IllegalArgumentException("The course must not be null!");
		}
		List<NewsBoard> news = null;
		if (course == Course.ALL) {
			url = buildUrl(NEWS_BOARD_ALL);
		} else {
			url = buildUrl(NEWS_BOARD, course);
		}
		
		try {
			news = mapper.readValue(requestJSON(url), new TypeReference<List<NewsBoard>>(){});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news;
	}
	
	@Override
	public List<ConsultationHour> getConsultationHours() {
		List<ConsultationHour> hours = null;
		url = buildUrl(LECTURER_HOURS);
		
		try {
			hours = mapper.readValue(requestJSON(url), new TypeReference<List<ConsultationHour>>(){});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hours;
	}

	@Override
	public List<CompulsoryOptionalSubjects> getCompulsoryOptionalSubjects(Course course) throws IllegalArgumentException {
		if (course == null) {
			throw new IllegalArgumentException("The Course is mandatory for this operation");
		}
		List<CompulsoryOptionalSubjects> subjects = null;
		url = buildUrl(CUMPOLSORY, course);
		
		try {
			subjects = mapper.readValue(requestJSON(url), new TypeReference<List<CompulsoryOptionalSubjects>>(){});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return subjects;
	}
	
	
	private JSONArray requestJSON(String url, Method httpMethod) {		
		JSONArray result = new JSONArray();
		
//		RequestBuilder builder = new RequestBuilder(httpMethod, url);
		
				
		
		
		return result;
	}
	
	@Deprecated
	private String requestJSON(URL url) {
		StringBuilder response = new StringBuilder();
		String responseLine = "";
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			
			int responseCode = connection.getResponseCode();
			
			if (responseCode != HttpStatus.SC_OK) {
				throw new RuntimeException("Failed Request! HTTP error code: " + responseCode);
			}
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((responseLine = reader.readLine()) != null) {
				response.append(responseLine);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response.toString();
	}
	
	private URL buildUrl(String pathOfUrl) {
		URL ret = null;
		try {
			ret = new URL(BASE_URL + pathOfUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	private URL buildUrl(String pathOfUrl, IURLParameterEnum parameters) {
		IURLParameterEnum[] param = {parameters};
		return buildUrl(pathOfUrl, param);
	}
	
	private URL buildUrl(String pathOfUrl, IURLParameterEnum[] parameters) {
		String pathWithParameters = "";
		Matcher matcher = pattern.matcher(pathOfUrl);
		
		for (int i = 0; matcher.find() && i < parameters.length; i++) {
			pathWithParameters = pathOfUrl.replace(matcher.group(), parameters[i].getUrlKey());
		}
		URL ret = null;
		try {
			ret = new URL(BASE_URL + pathWithParameters);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public void getTutorials(ObserverActivity<List<CourseTutorial>> observer,
			Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getNewsBoard(ObserverActivity<List<NewsBoard>> observer,
			Course course) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getConsultationHours(
			ObserverActivity<List<ConsultationHour>> observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCompulsoryOptionalSubjects(
			ObserverActivity<List<CompulsoryOptionalSubjects>> observer,
			Course course) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MensaMenu> getMensaMenu(int id, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getMensaMenu(ObserverActivity<List<MensaMenu>> observer,
			Canteen cateen, Date date) {
		// TODO Auto-generated method stub
		
	}
}
