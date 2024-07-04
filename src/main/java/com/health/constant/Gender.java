package com.health.constant;

public enum Gender {
    MAN("남"),WOMAN("여");

    private final String description; //문자열 변수를 지정

    Gender(String description) { //
        this.description = description;
    }
}
