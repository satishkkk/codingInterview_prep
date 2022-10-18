package com.company.FullTime.May30;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Exclusive {

    /* input  : List<String> logs
    * abc:start:100
    * def:start:200
    * ijk:start:300
    * ijk:end:400
    * def:end:500
    * abc:end:600
    *
    * */
    public static void main(String[] args) {
        List<String> logs = new ArrayList<String>();
        logs.add("abc:start:100");
        logs.add("def:start:200");
        logs.add("ijk:start:300");
        logs.add("ijk:end:400");
        logs.add("def:end:500");
        logs.add("abc:end:600");

        System.out.println(exclusiveTime(logs,"abc"));
        System.out.println(inclusiveTime(logs,"abc"));
    }

    public static int exclusiveTime(List<String> logs,String functionName){
        int startTime = 0;
        int endTime = 0;
        for(String log : logs){
            String[] logArray = log.split(":");
            String name = logArray[0];
            boolean isStart = logArray[1].equals("start");
            int time = Integer.parseInt(logArray[2]);

            if(name.equals(functionName) && isStart) {
                startTime = time;
            }else if(name.equals(functionName)&& !isStart){
                endTime = time;
                return time-startTime;
            }
        }
        return endTime - startTime;
    }

    public static int inclusiveTime(List<String> logs,String functionName){
        int anotherFunctiontime =0 ;
        int startTime = 0;
        int endTime = 0;
        boolean found =false;
        int interStart =0;
        String interFunName = "";

        Stack<Log> stack = new Stack<>();
        for(String s : logs){
            boolean isFound = false;
            Log log = new Log();
            String[] logArray = s.split(":");
            log.setFunctioName(logArray[0]);
            log.setStart(logArray[1].equals("start"));
            log.setTime(Integer.parseInt(logArray[2]));

            if(log.getFunctioName().equals(functionName)  && log.isStart && !isFound){
                stack.push(log);
                startTime = log.getTime();
                isFound = true;
            }else if( stack.peek().getFunctioName().equals(functionName) && !log.getStart() && isFound){
                return log.getTime()-startTime-anotherFunctiontime;
            }else if( stack.peek().getFunctioName().equals(log.getFunctioName()) && !log.getStart() && isFound){
                anotherFunctiontime += log.getTime() - stack.peek().getTime();
                stack.pop();
            }else if(log.getStart() && isFound ){
                stack.push(log);
            }
        }
    return 0;
    }

}

class Log{
    String functioName;
    Boolean isStart;
    int time;

    public String getFunctioName() {
        return functioName;
    }

    public void setFunctioName(String functioName) {
        this.functioName = functioName;
    }

    public Boolean getStart() {
        return isStart;
    }

    public void setStart(Boolean start) {
        isStart = start;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
