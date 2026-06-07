package com.patterns.task03;
public class Circle extends Shape {
    private final double radius;
    public Circle(Renderer renderer, double radius) { super(renderer); this.radius = radius; }
    @Override public void draw() { renderer.renderCircle(radius); }
}
