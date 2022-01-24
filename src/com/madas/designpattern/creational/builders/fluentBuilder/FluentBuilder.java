package com.madas.designpattern.creational.builders.fluentBuilder;


import java.util.ArrayList;
import java.util.Collections;

//https://tcsglobal.udemy.com/course/design-patterns-java/learn/lecture/8118402#overview
public class FluentBuilder {
    public static void main(String[] args) {
        FluentHtmlBuilder builder = new FluentHtmlBuilder("ul");
        builder.addChild("li", "Hello")
                .addChild("li", "Adithya")
                .addChild("li", "Madas");
        System.out.println(builder);
    }
}

class FluentHtmlBuilder {
    private String rootName;
    private HtmlElement root=new HtmlElement();
    public FluentHtmlBuilder() {
    }

    public FluentHtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.name = rootName;
    }

    //fluent builders returns this object, so that we can write long lines and keep calling addChild, instead of everytime calling builder.addChild()
    public FluentHtmlBuilder addChild(String childName, String childText) {
        HtmlElement element = new HtmlElement(childName, childText);
        root.elements.add(element);
        return this;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}


class HtmlElement {
    public String name, text;
    public ArrayList<HtmlElement> elements = new ArrayList<>();
    private final int indentSize = 4;
    private final String newLine = System.lineSeparator();

    public HtmlElement() {}
    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return toStringImpl(0);
    }

    private String toStringImpl(int indent) {
        StringBuilder sb = new StringBuilder();
        String i = String.join("", Collections.nCopies(indent * indentSize, " "));
        sb.append(String.format("%s<%s>%s", i, name, newLine));
        if (text != null && !text.isEmpty()) {
            sb.append(String.join("", Collections.nCopies((indent + 1) * indentSize, " ")))
                    .append(text)
                    .append(newLine);
        }
        for (HtmlElement element : elements) {
            sb.append(element.toStringImpl(indent + 1));
        }

        sb.append(String.format("%s</%s>%s", i, name, newLine));
        return sb.toString();
    }
}
