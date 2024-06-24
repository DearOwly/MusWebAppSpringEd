package so.sonya.muswebapp2.propertyeditors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UUIDEditor extends PropertyEditorSupport {
    private static final Integer LENGTH = 36;
    private static final Integer[] GROUP_LENGTHS = {8, 4, 4, 4, 12};

    @Builder.Default
    private boolean allowEmpty = false;

    @Builder.Default
    private boolean allowNil = true;

    @Builder.Default
    private int[] version = {1, 2, 3, 4, 5};

    @Builder.Default
    private int[] variant = {0, 1, 2};

    @Builder.Default
    @NonNull
    private LetterCase letterCase = LetterCase.LOWER_CASE;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (isValidUUID(text)) {
            setValue(UUID.fromString(text));
        } else {
            throw new IllegalArgumentException("Invalid UUID string: " + text);
        }
    }

    @Override
    public String getAsText() {
        UUID value = (UUID) getValue();
        return (value != null ? value.toString() : "");
    }

    private boolean isValidUUID(String text) {
        if (text == null) {
            return true;
        }

        int length = text.length();

        if (length == 0) {
            return allowEmpty;
        } else if (length != LENGTH) {
            return false;
        }

        int groupIndex = 0;
        int groupLength = 0;
        int checksum = 0;
        int version = -1;
        int variant = -1;

        for (int charIndex = 0; charIndex < length; charIndex++) {
            char ch = text.charAt(charIndex);

            if (ch == '-') {
                groupIndex++;
                groupLength = 0;
            } else {
                groupLength++;

                if (groupLength > GROUP_LENGTHS[groupIndex]) {
                    return false;
                }

                int numericValue = Character.digit(ch, 16);

                if (numericValue == -1) {
                    return false;
                }

                if (numericValue > 9 && !hasCorrectLetterCase(ch)) {
                    return false;
                }

                checksum += numericValue;

                version = extractVersion(version, charIndex, numericValue);
                variant = extractVariant(variant, charIndex, numericValue);
            }
        }

        if (checksum == 0) {
            return allowNil;
        } else {
            if (Arrays.binarySearch(this.version, version) == -1) {
                return false;
            }

            return Arrays.binarySearch(this.variant, variant) != -1;
        }
    }

    private boolean hasCorrectLetterCase(char ch) {
        return switch (letterCase) {
            case LOWER_CASE -> Character.isLowerCase(ch);
            case UPPER_CASE -> Character.isUpperCase(ch);
            case INSENSITIVE -> true;
        };
    }

    private int extractVersion(int version, int index, int value) {
        if (index == 14) {
            return value;
        }

        return version;
    }

    private static int extractVariant(int variant, int index, int value) {
        if (index == 19) {
            if (value >> 3 == 0) {
                return 0;
            }

            if (value >> 2 == 2) {
                return 1;
            }

            if (value >> 1 == 6) {
                return 2;
            }
        }

        return variant;
    }

    public enum LetterCase {
        LOWER_CASE,
        UPPER_CASE,
        INSENSITIVE
    }
}
