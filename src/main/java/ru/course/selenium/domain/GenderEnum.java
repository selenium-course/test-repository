package ru.course.selenium.domain;

/**
 * Created by Aleksei.Klimenko on 06.12.2016.
 */
public enum GenderEnum {
    FEMALE(0),
    MALE(1),
    UNISEX(2);

    private final Integer code;

    GenderEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static GenderEnum getByCode(Integer code) {
        for (GenderEnum gender : values()) {
            if (gender.getCode().equals(code)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Incorrect gender code set to find GenderEnum");
    }
}
