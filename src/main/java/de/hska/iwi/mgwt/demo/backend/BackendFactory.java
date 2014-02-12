package de.hska.iwi.mgwt.demo.backend;

import de.hska.iwi.mgwt.demo.backend.connection.IntranetConnection;

public class BackendFactory {

	public static Intranet createIntranetInstance() {
		return new IntranetConnection();		
	}

}
