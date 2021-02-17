package com.henucg.vo;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/17 11:47
 */
public class Payment {

    private Long id;
    private String serial;

    public Payment(Long id, String serial) {
        this.id = id;
        this.serial = serial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
