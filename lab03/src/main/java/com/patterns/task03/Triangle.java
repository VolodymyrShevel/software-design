package com.patterns.task03;
public class Triangle extends Shape {
    private final double base, height;
    public Triangle(Renderer renderer, double base, double height) { super(renderer); this.base = base; this.height = height; }
    @Override public void draw() { renderer.renderTriangle(base, height); }
}
