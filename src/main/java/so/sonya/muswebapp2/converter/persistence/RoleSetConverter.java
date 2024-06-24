package so.sonya.muswebapp2.converter.persistence;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import so.sonya.muswebapp2.model.user.Role;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Converter(autoApply = true)
public final class RoleSetConverter implements AttributeConverter<Set<Role>, String> {
    private static final String SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(Set<Role> attribute) {
        if (attribute == null) {
            return "";
        }

        return attribute.stream()
                        .map(Role::toString)
                        .collect(Collectors.joining(SEPARATOR));
    }

    @Override
    public Set<Role> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return Collections.emptySet();
        }

        return Arrays.stream(dbData.split(SEPARATOR))
                     .map(Role::valueOf)
                     .collect(Collectors.toSet());
    }
}
