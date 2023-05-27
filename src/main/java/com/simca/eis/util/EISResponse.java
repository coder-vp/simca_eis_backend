package com.simca.eis.util;

import lombok.Data;

@Data
public class EISResponse<T> {
    private int statusCode;
    private String statusMessage;
    private T response;
}
