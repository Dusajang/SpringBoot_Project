package org.sist.erp_project.consultationSchedule;

public enum CenterType {
    GANGNAM("강남교육센터"),
    GANGBUK("강북교육센터");

    private final String description;

    CenterType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}