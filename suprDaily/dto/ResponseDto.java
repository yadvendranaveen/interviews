package com.dm.mesh.jiraplugin.suprDaily.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yadvendranaveen
 * Date: 2021-01-22
 */

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<T extends Object> {

    @JsonProperty("status")
    private Boolean status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private T data;

//TODO: add errors here

    // Constructors
    public ResponseDto(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public ResponseDto(String message) {
        this.message = message;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
