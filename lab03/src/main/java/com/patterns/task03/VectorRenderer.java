package com.patterns.task03;

public class VectorRenderer implements Renderer {
    @Override public void renderCircle(double r)           { System.out.println("Drawing Circle as vectors (radius=" + r + ")"); }
    @Override public void renderSquare(double s)           { System.out.println("Drawing Square as vectors (side=" + s + ")"); }
    @Override public void renderTriangle(double b, double h){ System.out.println("Drawing Triangle as vectors (base=" + b + " height=" + h + ")"); }
}
