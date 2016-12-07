package ru.course.selenium.domain;

/**
 * Created by Aleksei.Klimenko on 07.12.2016.
 */
public enum CurrencyEnum {
    USD(0),
    EUR(1);

    private final Integer code;

    CurrencyEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static CurrencyEnum getByCode(Integer code) {
        for (CurrencyEnum gender : values()) {
            if (gender.getCode().equals(code)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Incorrect currency code set to find CurrencyEnum");
    }
}
