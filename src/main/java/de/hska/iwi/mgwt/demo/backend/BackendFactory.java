package de.hska.iwi.mgwt.demo.backend;

import de.hska.iwi.mgwt.demo.backend.connection.GWTIntranetConnection;

public class BackendFactory {

	public static Intranet createIntranetInstance() {
		return new GWTIntranetConnection();		
	}

}
