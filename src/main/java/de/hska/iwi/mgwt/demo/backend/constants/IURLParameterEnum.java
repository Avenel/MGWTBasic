package de.hska.iwi.mgwt.demo.backend.constants;

/**
 * All enums which are also references in the url path, should implement this Interface.
 * It ensures that one single method can be used for determining the correct value in the path.
 * 
 * @author Nico
 */
public interface IURLParameterEnum {
	
	/**
	 * @return the String which is used in the url of a request
	 */
	public String getUrlKey();

}
