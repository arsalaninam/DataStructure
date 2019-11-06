package com.abc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {

    private String duration;
    private String success;
    private String error_message;
    private String status_code;
    private Payload payload;

    @Override
    public String toString() {
        return "ClassPojo [duration = " + duration + ", success = " + success + ", error_message = " + error_message + ", status_code = " + status_code + ", payload = " + payload + "]";
    }
}
