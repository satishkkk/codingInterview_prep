package com.PatkarSir_core.myservletframework;

public class MyServletComponent extends MyHTTPServlet{

    public String doget(MyRequest req, MyResponse rsp){
        System.out.println("Inside MyServletComponent doget() & data is :" + req.getData()+" completed ");
        return req.getData()+" completed";
    }
}
