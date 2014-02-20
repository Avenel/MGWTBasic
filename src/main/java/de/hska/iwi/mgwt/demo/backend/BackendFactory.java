package de.hska.iwi.mgwt.demo.backend;

import de.hska.iwi.mgwt.demo.backend.connection.IntranetConnection;

/**
 * Factory for the IntranetConnection (REST-API)
 * 
 * @author Nico
 *
 */
public class BackendFactory {

	/**
	 * factorymethod for an Intranet-Instance.
	 * @return an object which is used for the connection to the REST-API
	 */
	public static Intranet createIntranetInstance() {
		return new IntranetConnection();		
	}

}
