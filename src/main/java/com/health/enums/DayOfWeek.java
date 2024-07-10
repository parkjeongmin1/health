package com.health.enums;

public enum DayOfWeek {
     MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금");

    private final String description; //문자열 변수를 지정

    DayOfWeek(String description) { //
        this.description = description;
    }
}
