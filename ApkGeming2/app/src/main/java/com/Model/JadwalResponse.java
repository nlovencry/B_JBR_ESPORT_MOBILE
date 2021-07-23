package com.Model;

import java.util.List;

public class JadwalResponse {
    private String message;
    private List<ModelJadwal> data;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ModelJadwal> getData() { return data; }

    public void setData(List<ModelJadwal> data) {
        this.data = data;
    }
}
