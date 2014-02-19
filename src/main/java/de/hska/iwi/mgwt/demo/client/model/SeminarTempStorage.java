package de.hska.iwi.mgwt.demo.client.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Non-persistent storage for faster access. This is used after the local
 * storage was read the first time.
 * 
 * @author Simon
 * 
 */
public class SeminarTempStorage {
	private static List<Seminar> seminarList = new ArrayList<Seminar>();

	/**
	 * Corresponding to the method of SeminarStorage
	 * {@link SeminarStorage#addSeminar} Adds a Seminar to the non-persistent
	 * storage
	 * 
	 * @param seminar
	 *            the Seminar to add
	 */
	public static void addSeminar(Seminar seminar) {
		boolean contains = false;
		for (Seminar s : seminarList) {
			if (s.getTopic().equals(seminar.getTopic())) {
				contains = true;
			}
		}
		if (contains == false) {
			seminarList.add(seminar);
		}

	}

	/**
	 * Sets a list of seminars as the current list. Overwrites the old one.
	 * 
	 * @param seminars
	 *            The list to overwrite the old one with
	 */
	public static void setSeminars(List<Seminar> seminars) {
		seminarList = seminars;
	}

	/**
	 * Gets all Seminars currently in the non-persistent storage as a list
	 * 
	 * @return the Seminars as a List
	 */
	public static List<Seminar> getSeminarList() {

		return seminarList;
	}

	public static String[] getLecturers() {
		return new String[] { "Bröckl, Ulrich Prof. Dr. rer. nat.",
				"Ditzinger, Albrecht Prof. Dr.", "Dübon, Karl Prof. Dr.",
				"Fuchß, Thomas Prof. Dr. rer. nat.",
				"Gmeiner, Lothar Prof. Dr. rer. nat.",
				"Gremminger, Klaus Prof. Dipl.-Inform.",
				"Haneke, Uwe Prof. Dr. rer. pol.",
				"Heberle, Andreas Prof. Dr.",
				"Henning, Peter A. Prof. Dr. rer. nat.",
				"Hinz, Thomas Prof. Dipl. Des.",
				"Hoffmann, Dirk Prof. Dr. rer. nat.",
				"Hofmann, Reimar Prof. Dr.", "Kinkel, Steffen Prof. Dr.",
				"Körner, Heiko Prof. Dr.",
				"Laubenheimer, Astrid Prof. Dr.-Ing.",
				"Link, Norbert Prof. Dr.", "Martin, Sven Prof. Dr.",
				"Meisel, Karl-Heinz Prof. Dr. rer. nat.",
				"Morgenstern, Thomas Prof. Dr. rer. nat",
				"Müller, Udo Prof. Dr. rer. nat.",
				"Nees, Franz Prof. Dipl.-Volksw.",
				"Nestler, Britta Prof. Dr. rer. nat.",
				"Neumann, Rainer Prof. Dr.-Ing.",
				"Pape, Christian Prof. Dr. rer. nat.",
				"Philipp, Mathias Prof. Dr. rer. pol.",
				"Regier, Stefanie Prof. Dr. rer. pol.",
				"Reichhardt, Michael Prof. Dr. rer. pol.",
				"Schaefer, Frank Prof. Dr. rer. nat.",
				"Schmauch, Cosima Prof. Dr. rer. nat.",
				"Schmidt, Andreas Prof. Dr.-Ing.",
				"Schmidt, Andreas Peter Prof. Dr.-Ing.",
				"Seifert, Manfred Prof. Dr. rer. nat.",
				"Senger, Robert Prof. Dipl.-Inform.",
				"Sulzmann, Martin Prof. Dr.",
				"Vogelsang, Holger Prof. Dr.-Ing.",
				"Wirth, Andrea Prof. Dr. rer. pol.",
				"Zimmermann, Jürgen Prof. Dr." };

	}

}
