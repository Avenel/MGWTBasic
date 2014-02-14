package de.hska.iwi.mgwt.demo.backend.constants;


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

	@Override
	public String getUrlKey() {
		return this.key;
	}
}
