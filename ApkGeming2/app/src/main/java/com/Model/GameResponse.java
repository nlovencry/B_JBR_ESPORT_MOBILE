package com.Model;

import java.util.List;

public class GameResponse {

    private String pesan;
    private List<GameModel> data;

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<GameModel> getData() {
        return data;
    }

    public void setData(List<GameModel> data) {
        this.data = data;
    }
}
