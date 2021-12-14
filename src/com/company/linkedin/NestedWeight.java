//package com.company.linkedin;
//
//public class NestedWeight {
//
//    public int depthSum(List<NestedInteger> nestedList) {
//        return depthSum(nestedList,1);
//    }
//
//    public int depthSum(List<NestedInteger> nestedList , int depth){
//        int total =0;
//        for(NestedInteger nested : nestedList){
//            if(nested.isInteger()){
//                total += nested.getInteger()*depth;
//            }else{
//                total+= depthSum(nested.getList(),depth+1);
//            }
//        }
//        return total;
//    }
//
//
//}
