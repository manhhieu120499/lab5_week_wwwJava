package iuh.fit.vomanhhieu_21097401_lab5week.backend.converters;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.enums.SkillLevel;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class SkillLevelConverter implements AttributeConverter<SkillLevel, Byte> {
    @Override
    public Byte convertToDatabaseColumn(SkillLevel attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }
    @Override
    public SkillLevel convertToEntityAttribute(Byte dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(SkillLevel.values())
                .filter(c -> c.getValue() == dbData)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
