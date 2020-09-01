package com.company;

import java.util.Arrays;

public class divideby3 {

    public static void main(String[] args) {

        int num =100;
        int division = 3;

        int chunkSize= num/division;

        Chunk[] arrayChunk = new Chunk[chunkSize];

        Chunk c1 =new Chunk();
        c1.setStart(0);
        c1.setEnd(chunkSize);
        arrayChunk[0]=c1;
        for(int i=1;i<division;i++){
            Chunk c =new Chunk();
            int start = arrayChunk[i-1].getEnd()+1;
            c.setStart(start);
            c.setEnd(start+chunkSize);
            arrayChunk[i]=c;
        }

        Arrays.stream(arrayChunk).forEach(chunk -> System.out.println("Start :"+chunk.getStart()+"END : "+chunk.getEnd()));
    }
}


class Chunk{
    int start;
    int end;
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
