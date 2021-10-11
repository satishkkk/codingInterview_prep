package com.PatkarSir_core.myservletframework;

public class MyResponse {
    String response;

    public MyResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "MyResponse{" +
                "response='" + response + '\'' +
                '}';
    }
}
