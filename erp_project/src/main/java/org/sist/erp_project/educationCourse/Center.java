package org.sist.erp_project.educationCourse;

public enum Center {
    GANGNAM(1, "강남점"),
    GANGBUK(2, "강북점");

    private final Integer code;
    private final String name;

    Center(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static Center fromCode(Integer code) {
        for (Center c : values()) {
            if (c.getCode() == code) {
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid center code: " + code);
    }
}