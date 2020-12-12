package com.concepts.immutable.Explore;

public class MutableStudent {
    private final int id;
    private final String name;
    private final Age age;

    public MutableStudent(int id, String name, Age age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }
}
