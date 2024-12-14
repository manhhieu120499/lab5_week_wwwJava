package iuh.fit.vomanhhieu_21097401_lab5week.backend.enums;

public enum SkillType {
    SOFT_SKILL(Byte.parseByte("1")), UNSPECIFIC(Byte.parseByte("2")), TECHNICAL_SKILL(Byte.parseByte("3"));
    private byte value;
    private SkillType(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }
}
