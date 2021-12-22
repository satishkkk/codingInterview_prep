package com.interviewBitScaler.Graph.Template;


import java.util.Objects;

public class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return getX() == pair.getX() && getY() == pair.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}