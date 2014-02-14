package de.hska.iwi.mgwt.demo.backend.constants;


public enum FoodAdditive {
	//@PropertyName not possible due to the fact that this Annotation does only support Strings
	FARBSTOFF(1),
	KONSERVIERUNGSSTOFF(2),
	ANTIOXIDATIONSMITTEL(3),
	GESCHMACKSVERSTAERKER(4),
	PHOSPHAT(5),
	OBERFLAECHE_GEWACHST(6),
	GESCHWEFELT(7),
	OLIVEN_GESCHWAERZT(8),
	SUESSUNGSMITTEL(9),
	KANN_ABFUEHREN(10),
	ENTHAELT_PHENYLALANINQUELLE(11),
	KANN_RESTALKOHOL_ENTHALTEN(12),
	SIEHE_TAGESKARTE(14),
	ENTHAELT_RINDFLEISCH(93),
	ENTHAELT_RINDFLEISCH_ARTGERECHT(94),
	ENTHAELT_SCHWEINEFLEISCH(95),
	VEGETARISCHES_GERICHT(96),
	VEGANES_GERICHT(97),
	MSC_ZERTIFIZIERTER_FISCH(98),
	KONTROLLIERTER_BIO_ANBAU(99),
	DEFAULT(-1);
	
	private final int key;
	
	private FoodAdditive(int key) {
		this.key = key;
	}

	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}


	public static FoodAdditive getEnumForKey(int key) {
		for (FoodAdditive food : FoodAdditive.values()) {
			if (food.getKey() == key) {
				return food;
			}
		}
		return FoodAdditive.DEFAULT;
	}
}
