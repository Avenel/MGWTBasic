package de.hska.iwi.mgwt.demo.backend.constants;


public enum WorkflowEvent implements IURLParameterEnum {
	ACADEMIC_WRITING,
	SEMINAR_BACHELOR,
	SEMINAR_MASTER,
	THESIS_BACHELOR_PO_3,
	THESIS_BACHELOR,
	STUDENT_RESEARCH_PROJECT,
	TEAM_TEACHING,
	EXTERNSHIP,
	RESEARCH_PROJECT_1_MASTER,
	RESEARCH_PROJECT_2_MASTER,
	THESIS_MASTER;

	@Override
	public String getUrlKey() {
		return this.toString().toLowerCase();
	}

}
