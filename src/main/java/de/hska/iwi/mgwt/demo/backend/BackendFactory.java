package de.hska.iwi.mgwt.demo.backend;

import de.hska.iwi.mgwt.demo.backend.connection.DummyIntranteConnection;

public class BackendFactory {

	public static Intranet createIntranetInstance() {
		return new DummyIntranteConnection();
//		Used in live mode.
//		return new IntranetConnection();
		
	}

}
