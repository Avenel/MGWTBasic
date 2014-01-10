package de.hska.iwi.mgwt.demo.backend.constants;

public enum Canteen implements IURLParameterEnum{
	ADENAUERRING(1, "Mensa Am Adenauerring"),
	MOLTKE(2, "Mensa Moltkestraße"),
	ERZBERGSTRAßE(3, "Mensa Erzbergerstraße"),
	SCHLOSS_GOTTESAUE(4, "Mensa Schloss Gottesaue"),
	TIEFENBRONNERSTRAßE(5, "Tiefenbronner Straße"),
	HOLZGARTENSTRAßE(6, "Holzgartenstraße");
	
	private final int id;
	
	private final String name;
	
	private Canteen(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String getUrlKey() {
		return Integer.toString(this.id);
	}

}
