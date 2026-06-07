package com.patterns.task03;

public class RasterRenderer implements Renderer {
    @Override public void renderCircle(double r)           { System.out.println("Drawing Circle as pixels (radius=" + r + ")"); }
    @Override public void renderSquare(double s)           { System.out.println("Drawing Square as pixels (side=" + s + ")"); }
    @Override public void renderTriangle(double b, double h){ System.out.println("Drawing Triangle as pixels (base=" + b + " height=" + h + ")"); }
}
