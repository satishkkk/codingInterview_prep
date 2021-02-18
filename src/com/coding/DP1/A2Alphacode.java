package com.coding.DP1;

public class A2Alphacode {

    //out[i] -> willl reprsets what are the number of possible code if you consider first 'i' characters
    public static int num_code_iterative(int[] arr, int size,int[] out){
        out[0]=1; // if length is 0 then you can return "" which is empty string hence 1 possible case
        out[1]=1; //  if length is 1 then you can return single character hence output will be 1

        for(int i =2;i<=size;i++){
            out[i]=out[i-1];

            if(arr[i-2]*10 + arr[i-1] <=26){
                out[i]=out[i]+out[i-2];
            }
        }

        return out[size];
    }


    public static int num_codes(int[] arr, int size) {
        //base cases
        if (size == 1) {
            return 1;
        }
        if (size == 0) {
            return 1; //if size is 0 return "";
        }

        int output = num_codes(arr,size-1);

        if(arr[size-2]*10+arr[size-1] <=26){
            output += num_codes(arr,size-2); //if last 2 digits are valid numbers . . .
        }

        return output;
    }

    //moving out array from end to start and filling from start to end, . .. and moving back again
    public static int num_codes2(int[] arr, int size,int[] out) {
        //base cases
        if (size == 1) {
            return 1;
        }

        if (size == 0) {
            return 1; //if size is 0 return "";
        }

        if(out[size]>0){
            return arr[size];
        }

        int output = num_codes(arr,size-1);

        if(arr[size-2]*10+arr[size-1] <=26){
            output += num_codes(arr,size-2); //if last 2 digits are valid numbers . . .
        }

        out[size]=output;

        return output;
    }



    public static void main(String[] args) {

        int[] arr = new int[]{2,5,1,1,4};
        System.out.println(num_codes(arr,arr.length));

        int[] out = new int[arr.length+1];
        System.out.println(num_codes2(arr,arr.length,out));
        System.out.println(num_code_iterative(arr,arr.length,out));

    }


}

/*
* Alice and Bob need to send secret messages to each other and are discussing ways to encode their messages:
Alice: “Let’s just use a very simple code: We’ll assign ‘A’ the code word 1, ‘B’ will be 2, and so on down to ‘Z’ being assigned 26.”

Bob: “That’s a stupid code, Alice. Suppose I send you the word ‘BEAN’ encoded as 25114. You could decode that in many different ways!”

Alice: “Sure you could, but what words would you get? Other than ‘BEAN’, you’d get ‘BEAAD’, ‘YAAD’, ‘YAN’, ‘YKD’ and ‘BEKD’. I think you would be able to figure out the correct decoding. And why would you send me the word ‘BEAN’ anyway?”

Bob: “OK, maybe that’s a bad example, but I bet you that if you got a string of length 5000 there would be tons of different decodings and with that many you would find at least two different ones that would make sense.”

Alice: “How many different decodings?”

Bob: “Jillions!”
For some reason, Alice is still unconvinced by Bob’s argument, so she requires a program that will determine how many decodings there can be for a given string using her code.
Input
Input will consist of multiple input sets. Each set will consist of a single line of at most 5000 digits representing a valid encryption (for example, no line will begin with a 0). There will be no spaces between the digits. An input line of ‘0’ will terminate the input and should not be processed.
Output
For each input set, output the number of possible decodings for the input string. Print your answer taking modulo "10^9+7"
Sample Input:
25114
1111111111
3333333333
0
Sample Output:
6
89
1*/