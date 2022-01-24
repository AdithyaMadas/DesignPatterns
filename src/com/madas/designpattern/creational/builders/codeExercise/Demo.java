package com.madas.designpattern.creational.builders.codeExercise;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
        System.out.println(cb);
    }
}

class CodeBuilder {
    private String className;
    public static final String PUBLIC = "public";
    public String space = "  ";
    private String LINEBREAK = System.lineSeparator();

    private List<Tuple<String, String>> list = new ArrayList<>();

    public CodeBuilder(String className) {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type) {
        list.add(new Tuple<>(name, type));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PUBLIC + " class " + className + LINEBREAK);
        sb.append("{" + LINEBREAK);
        for (Tuple t : list) {
            sb.append(space + PUBLIC + " " + t.y + " " + t.x + ";" + LINEBREAK);
        }
        sb.append("}");
        return sb.toString();
    }
}

class Tuple<X, Y> {
    public final X x;
    public final Y y;
    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
}
