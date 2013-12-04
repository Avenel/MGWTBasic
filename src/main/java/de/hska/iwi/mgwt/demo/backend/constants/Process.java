package de.hska.iwi.mgwt.demo.backend.constants;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Process implements IURLParameterEnum {
	ACADEMIC_WRITING("academic_writing"),
	SEMINAR_BSC("seminar_bachelor"),
	SEMINAR_MSC("seminar_master"),
	THESIS_BSC_PO3("thesis_bachelor_po_3"),
	THESIS_BSC("thesis_bachelor"),
	THESIS_MSC("thesis_master"),
	EXTERNSHIP("externship"),
	TEAM_TEACHING("team_teaching"),
	RESEARCH_PROJECT_BSC("student_research_project"),
	RESEARCH_PROJECT__1_MSC("research_project_1_master"),
	RESEARCH_PROJECT__2_MSC("research_project_2_master");
	
	private final String key;
	
	private Process(String key) {
		this.key = key;
	}
	
	@JsonCreator
	public static Process create(String value) {
		for (Process process : Process.values()) {
			if (process.getKey().equals(value)) {
				return process;
			}
		}
		return ACADEMIC_WRITING;
	}

	@Override
	public String getKey() {
		return this.key;
	}
}
