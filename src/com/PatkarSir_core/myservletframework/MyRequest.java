package com.PatkarSir_core.myservletframework;

public class MyRequest {
    String httpVerb;
    String data;

    public MyRequest(String httpVerb, String data) {
        this.httpVerb = httpVerb;
        this.data = data;
    }

    public String getHttpVerb() {
        return httpVerb;
    }

    public void setHttpVerb(String httpVerb) {
        this.httpVerb = httpVerb;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MyRequest{" +
                "httpVerb='" + httpVerb + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
