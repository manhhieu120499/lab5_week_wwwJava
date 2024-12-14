package iuh.fit.vomanhhieu_21097401_lab5week.backend.enums;

public enum Role {
    COMPANY("company"), CANDIDATE("candidate");
    private String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
