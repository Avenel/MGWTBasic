package de.hska.iwi.mgwt.demo.backend;

import de.hska.iwi.mgwt.demo.backend.connection.DummyIntranetConnection;

public class BackendFactory {

	public static Intranet createIntranetInstance() {
		return new DummyIntranetConnection();
//		Used in live mode.
//		return new IntranetConnection();
		
	}

}
