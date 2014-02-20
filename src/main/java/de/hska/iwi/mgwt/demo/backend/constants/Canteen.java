package de.hska.iwi.mgwt.demo.backend.constants;
/**
 * Enum values for all the available Canteens.
 * @author Nico
 *
 */
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUrlKey() {
		return Integer.toString(this.id);
	}

}
