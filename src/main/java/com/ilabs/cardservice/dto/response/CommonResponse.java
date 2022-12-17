package com.ilabs.cardservice.dto.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CommonResponse {
    private Object data;
    private String message;
    private int statusCode;
}
