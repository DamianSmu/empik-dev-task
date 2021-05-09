package com.example.gatewayservice;

public class ResultDto {

    private int sum;
    private int occurrences;

    public ResultDto(int sum, int occurrences) {
        this.sum = sum;
        this.occurrences = occurrences;
    }

    public ResultDto() {
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }
}
