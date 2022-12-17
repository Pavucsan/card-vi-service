package com.ilabs.cardservice.enumaration;


public enum StatusCode {

    SUCCESS(1000, "SUCCESS"),
    FAILED(1001, "FAILED"),
    ERROR(1002, "ERROR");

    private int code;
    private String value;

    StatusCode(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

}
