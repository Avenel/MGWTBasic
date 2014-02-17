package de.hska.iwi.mgwt.demo.backend.constants;

import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;


public enum WorkflowEvent implements IURLParameterEnum {
	@PropertyName("academic_writing")
	ACADEMIC_WRITING,
	@PropertyName("seminar_bachelor")
	SEMINAR_BACHELOR,
	@PropertyName("seminar_master")
	SEMINAR_MASTER,
	@PropertyName("thesis_bachelor_po_3")
	THESIS_BACHELOR_PO_3,
	@PropertyName("thesis_bachelor")
	THESIS_BACHELOR,
	@PropertyName("student_research_project")
	STUDENT_RESEARCH_PROJECT,
	@PropertyName("team_teaching")
	TEAM_TEACHING,
	@PropertyName("externship")
	EXTERNSHIP,
	@PropertyName("research_project_1_master")
	RESEARCH_PROJECT_1_MASTER,
	@PropertyName("research_proect_2_master")
	RESEARCH_PROJECT_2_MASTER,
	@PropertyName("thesis_master")
	THESIS_MASTER;

	@Override
	public String getUrlKey() {
		return this.toString().toLowerCase();
	}

}
