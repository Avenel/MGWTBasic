package de.hska.iwi.mgwt.demo.client.storage;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.storage.client.Storage;

import de.hska.iwi.mgwt.demo.client.model.ProcessStep;
import de.hska.iwi.mgwt.demo.client.model.Seminar;

/**
 * LocalStorage provider for seminar-related accesses. 
 * Can store and get Seminars, as well as process steps persistently, using {@link com.google.gwt.storage.client.Storage}.
 * Values are stored as JSON Objects
 * @author Simon
 *
 */
public class SeminarStorage {
	

	/**
	 * Adds a given Seminar to the local storage
	 * @param seminar the Seminar to add
	 */
	public static void addSeminar(Seminar seminar){
		Storage localStorage = Storage.getLocalStorageIfSupported();
		JSONArray currentSeminars= null;
		
		try{
			JSONValue value= JSONParser.parseStrict(localStorage.getItem(StorageKey.ProcessesSeminarsList.toString()));
			currentSeminars= (JSONArray)value;
		}catch (NullPointerException e){
			currentSeminars=new JSONArray();
		}
		
		JSONObject jsonSeminar= new JSONObject();
		jsonSeminar.put(StorageKey.ProcessesSeminarTerm.toString(), new JSONString(seminar.getTerm()));
		jsonSeminar.put(StorageKey.ProcessesSeminarTopic.toString(), new JSONString(seminar.getTopic()));
		jsonSeminar.put(StorageKey.ProcessesSeminarProfessor.toString(), new JSONString(seminar.getProfessor()));
		jsonSeminar.put(StorageKey.ProcessesSeminarStatus.toString(),new JSONString(seminar.getStatus()+""));
		currentSeminars.set(currentSeminars.size(), jsonSeminar);
		localStorage.setItem(StorageKey.ProcessesSeminarsList.toString(), currentSeminars.toString());
		
	}
	
	
	public static void setSeminars(List<Seminar> seminars){
		Storage localStorage=Storage.getLocalStorageIfSupported();
		localStorage.removeItem(StorageKey.ProcessesSeminarsList.toString());
		for(Seminar s: seminars){
			addSeminar(s);
		}
	}
	/**
	 * Gets a List of Seminars, that are currently in the local storage
	 * @return a List of Seminars. Not particularily ordered. Trailing and leading " are cut
	 */
	public static List<Seminar> getSeminars() {
		Storage localStorage = Storage.getLocalStorageIfSupported();
		String item= localStorage.getItem(StorageKey.ProcessesSeminarsList.toString());
		List<Seminar> retVal = new ArrayList<Seminar>();
		try {
			JSONValue value = JSONParser.parseStrict(item);
			JSONArray storageContents = (JSONArray) value;
			for (int i = 0; i < storageContents.size(); i++) {

				JSONObject currentObject = (JSONObject) storageContents.get(i);
				Seminar seminar = new Seminar();
				String professor=currentObject.get(StorageKey.ProcessesSeminarProfessor.toString()).toString();
				professor= professor.replace("\"", "");
				seminar.setProfessor(professor);
				String term= currentObject.get(StorageKey.ProcessesSeminarTerm.toString()).toString();
				term= term.replace("\"", "");
				seminar.setTerm(term);
				String topic= currentObject.get(StorageKey.ProcessesSeminarTopic.toString()).toString();
				topic= topic.replace("\"", "");
				seminar.setTopic(topic);
				String status= currentObject.get(StorageKey.ProcessesSeminarStatus.toString()).toString();
				status= status.replace("\"", "");
				seminar.setStatus(Integer.parseInt(status));
				
				retVal.add(seminar);

			}
		} catch (NullPointerException e) {
			return retVal;
		}

		return retVal;
	}
	/**
	 * Writes the ProcessesSteps of Seminars to the local storage
	 * @param steps the ProcessSteps to save
	 */
	public static void setSeminarSteps(List<ProcessStep> steps){
		JSONObject jSteps= new JSONObject();
		Storage localStorage = Storage.getLocalStorageIfSupported();
		for (ProcessStep s: steps){
			jSteps.put(s.getStepIndex()+"", new JSONString(s.getDisplayText()));
		}
		localStorage.setItem(StorageKey.ProcessesSeminarSteps.toString(), jSteps.toString());
		
		
	}
	/**
	 * Gets a List of Seminarsteps, that are currently in the local storage
	 * @return a List of ProcessSteps for a Seminar. Not particularily ordered. Trailing and leading " are cut
	 */
	public static List<ProcessStep> getSeminarSteps(){
		List<ProcessStep> steps= new ArrayList<ProcessStep>();
		Storage localStorage = Storage.getLocalStorageIfSupported();
		String item= localStorage.getItem(StorageKey.ProcessesSeminarSteps.toString());
		if (item==null){
			return steps;
		}
		JSONValue value = JSONParser.parseStrict(item);
		JSONObject jSteps= (JSONObject)value;
		for(int i=0; i<jSteps.size();i++){
			String displayString=jSteps.get(i+"").toString();
			displayString=displayString.replace("\"", "");
			ProcessStep p= new ProcessStep(displayString,i,"desc");
			steps.add(p);
		}
		return steps;
	}
}
