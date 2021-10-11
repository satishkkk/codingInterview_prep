package com.PatkarSir_core.myservletframework;

//public class MyHTTPServlet implements MyServlet  {
public class MyHTTPServlet extends MyGenericServlet  {
    @Override
    public String service(MyRequest req, MyResponse rsp) {
//        super.service(null,null);
        System.out.println("INSIDE MyHTTPServlet.service");

        String httpVerb = req.getHttpVerb();
        switch(httpVerb){
            case "get":
                System.out.println("calling MyHTTPServlet doget()");
                this.doget(req,rsp);
                break;
            case "post":
                System.out.println("calling MyHTTPServlet doget()");
                break;
            default:
                System.out.println("calling MyHTTPServlet default");
                break;
        }
        return "MyHTTPServlet";
    }

    public String doget(MyRequest req, MyResponse rsp){
        System.out.println("Inside MyHTTPServlet doget() & data is :" + req.data);
        return req.getData();
    }
}
