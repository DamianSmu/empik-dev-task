package com.example.gatewayservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Result {
    @Id
    private Integer id_result;
    private int occurrences;

    public Result(Integer id_result) {
        this.id_result = id_result;
        this.occurrences = 0;
    }

    public Result() {
    }

    public Integer getId_result() {
        return id_result;
    }

    public void setId_result(Integer id_result) {
        this.id_result = id_result;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }
}
