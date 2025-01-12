package org.sist.erp_project.consultationSchedule;

public enum ReservationStatus {
    CONFIRMED("확인"),
    PENDING("대기"),
    CANCELED("취소");

    private final String description;

    ReservationStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
