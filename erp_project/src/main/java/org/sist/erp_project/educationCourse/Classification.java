package org.sist.erp_project.educationCourse;

public enum Classification {
    IN_SERVICE_COURSE(1, "재직자교육"),
    JOB_SEEKER_COURSE(2, "취업자교육");

    private final Integer code;
    private final String name;

    Classification(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static Classification fromCode(Integer code) {
        for (Classification c : values()) {
            if (c.getCode() == code) {
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid classification code: " + code);
    }
}