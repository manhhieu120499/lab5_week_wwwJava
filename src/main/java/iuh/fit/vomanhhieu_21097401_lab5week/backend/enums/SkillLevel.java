package iuh.fit.vomanhhieu_21097401_lab5week.backend.enums;

public enum SkillLevel {
    MASTER(Byte.parseByte("1")), BEGINNER(Byte.parseByte("2")), ADVANCED(Byte.parseByte("3")), PROFESSIONAL(Byte.parseByte("4")), IMTERMEDIATE(Byte.parseByte("5"));
    private byte value;

    private SkillLevel(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }
}
