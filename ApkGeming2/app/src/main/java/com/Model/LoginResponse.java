package com.Model;

public class LoginResponse {
    private String message;
    private int id;
    private String email;
    private String name;
    private String token;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() { return email;}

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



}
