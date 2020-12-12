package com.company.servletdemo.myservletframework;

public class MyServletContainerDemo {

    //Template method pattern
    public static void main(String[] args) {

        MyRequest request = new MyRequest("get","Hello World");
        MyResponse response = new MyResponse("This is Resposne");
        String str = "MyServletComponent";

        Class c;
        MyServlet servlet = null;
        try {
            c = Class.forName("com.company.servletdemo.myservletframework."+str);
            servlet = (MyServlet) c.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        String out =servlet.service(request,response);

    }
}
