package com.gmail.yuriikrat.domain;

/**
 * POJO class which represents parsing result object
 *
 * @author Yurii Krat
 * @version 1.0
 * @since 26.06.17.
 */
public class ParsingResult {

    private String value;

    private Integer count;

    public ParsingResult() {

    }

    public ParsingResult(String value, Integer count) {
        this.value = value;
        this.count = count;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ParsingResult{" +
                "value='" + value + '\'' +
                ", count=" + count +
                '}';
    }
}
