package iuh.fit.vomanhhieu_21097401_lab5week.backend.converters;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.enums.SkillType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class SkillTypeConverter implements AttributeConverter<SkillType, Byte> {
    @Override
    public Byte convertToDatabaseColumn(SkillType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }
    @Override
    public SkillType convertToEntityAttribute(Byte dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(SkillType.values())
                .filter(c -> c.getValue() == dbData)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
