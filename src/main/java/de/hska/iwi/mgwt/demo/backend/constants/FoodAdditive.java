package de.hska.iwi.mgwt.demo.backend.constants;

import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;

public enum FoodAdditive {

	@PropertyName("1")
	FARBSTOFF(1),
	@PropertyName("2")
	KONSERVIERUNGSSTOFF(2),
	@PropertyName("3")
	ANTIOXIDATIONSMITTEL(3),
	@PropertyName("4")
	GESCHMACKSVERSTAERKER(4),
	@PropertyName("5")
	PHOSPHAT(5),
	@PropertyName("6")
	OBERFLAECHE_GEWACHST(6),
	@PropertyName("7")
	GESCHWEFELT(7),
	@PropertyName("8")
	OLIVEN_GESCHWAERZT(8),
	@PropertyName("9")
	SUESSUNGSMITTEL(9),
	@PropertyName("10")
	KANN_ABFUEHREN(10),
	@PropertyName("11")
	ENTHAELT_PHENYLALANINQUELLE(11),
	@PropertyName("12")
	KANN_RESTALKOHOL_ENTHALTEN(12),
	@PropertyName("14")
	SIEHE_TAGESKARTE(14),
	@PropertyName("93")
	ENTHAELT_RINDFLEISCH(93),
	@PropertyName("94")
	ENTHAELT_RINDFLEISCH_ARTGERECHT(94),
	@PropertyName("95")
	ENTHAELT_SCHWEINEFLEISCH(95),
	@PropertyName("96")
	VEGETARISCHES_GERICHT(96),
	@PropertyName("97")
	VEGANES_GERICHT(97),
	@PropertyName("98")
	MSC_ZERTIFIZIERTER_FISCH(98),
	@PropertyName("99")
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
