package org.sist.erp_project.consultationSchedule;

public enum EduKind {

	EMPLOYED("재직자 교육과정"),
    JOB_SEEKER("취업 교육과정"),
    OTHER("기타 과정");

    private final String description;

    EduKind(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
