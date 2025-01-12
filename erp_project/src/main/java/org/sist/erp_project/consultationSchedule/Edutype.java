package org.sist.erp_project.consultationSchedule;

public enum Edutype {
	
	MAJOR("전공자"),
	NON_MAJOR("비전공자");

    private final String description;

    Edutype(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
}
