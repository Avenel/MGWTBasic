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
	 * Returns canteen instance by name.
	 * @param name
	 * @return Canteen instance
	 */
	public static Canteen getCanteenByName(String name) {
		// Moltke by default
		Canteen returnValue = Canteen.MOLTKE;
		
		if (Canteen.ADENAUERRING.name.compareTo(name) == 0) return Canteen.ADENAUERRING;
		if (Canteen.ERZBERGSTRAßE.name.compareTo(name) == 0) return Canteen.ERZBERGSTRAßE;
		if (Canteen.HOLZGARTENSTRAßE.name.compareTo(name) == 0) return Canteen.HOLZGARTENSTRAßE;
		if (Canteen.SCHLOSS_GOTTESAUE.name.compareTo(name) == 0) return Canteen.SCHLOSS_GOTTESAUE;
		if (Canteen.TIEFENBRONNERSTRAßE.name.compareTo(name) == 0) return Canteen.TIEFENBRONNERSTRAßE;
		
		return returnValue;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUrlKey() {
		return Integer.toString(this.id);
	}

}
