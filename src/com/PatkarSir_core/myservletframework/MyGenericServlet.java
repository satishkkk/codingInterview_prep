package com.PatkarSir_core.myservletframework;

public class MyGenericServlet implements MyServlet {

    @Override
    public String service(MyRequest req, MyResponse res) {
        System.out.println("INSIDE MyGenericServlet.service");
        return "MyGenericServlet";
    }
}
