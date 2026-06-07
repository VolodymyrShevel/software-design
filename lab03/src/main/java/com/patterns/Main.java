package com.patterns;

import com.patterns.task01.*;
import com.patterns.task02.*;
import com.patterns.task03.*;
import com.patterns.task04.*;
import com.patterns.task05.*;
import com.patterns.task06.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ===================== TASK 01: Adapter ========================
        System.out.println("======================================");
        System.out.println("   TASK 01 - Adapter");
        System.out.println("======================================");

        Logger consoleLogger = new Logger();
        consoleLogger.log("Console logger works fine");
        consoleLogger.warn("This is a warning");
        consoleLogger.error("This is an error");

        FileWriter fw = new FileWriter("app.log");
        FileLoggerAdapter fileLogger = new FileLoggerAdapter(fw);
        fileLogger.log("Application started");
        fileLogger.warn("Low memory");
        fileLogger.error("Connection failed");

        System.out.println("\n-- File content written via adapter --");
        System.out.println(fileLogger.getFileContent());

        // ===================== TASK 02: Decorator ======================
        System.out.println("======================================");
        System.out.println("   TASK 02 - Decorator");
        System.out.println("======================================");

        Hero warrior = new Warrior("Thor");
        System.out.println("Base: " + warrior.getDescription());

        Hero withSword  = new SwordDecorator(warrior);
        System.out.println("+ Sword: " + withSword.getDescription());

        Hero withArmor  = new ArmorDecorator(withSword);
        System.out.println("+ Armor: " + withArmor.getDescription());

        Hero withRing   = new RingOfPowerDecorator(withArmor);
        System.out.println("+ Ring:  " + withRing.getDescription());

        Hero mage = new RingOfPowerDecorator(new SwordDecorator(new Mage("Gandalf")));
        System.out.println("Mage:    " + mage.getDescription());

        Hero palladin = new ArmorDecorator(new ArmorDecorator(new Palladin("Arthur")));
        System.out.println("Palladin (2x Armor): " + palladin.getDescription());

        // ===================== TASK 03: Bridge ========================
        System.out.println("\n======================================");
        System.out.println("   TASK 03 - Bridge");
        System.out.println("======================================");

        Renderer vector = new VectorRenderer();
        Renderer raster = new RasterRenderer();

        new Circle(vector, 5).draw();
        new Circle(raster, 5).draw();
        new Square(vector, 4).draw();
        new Square(raster, 4).draw();
        new Triangle(vector, 3, 6).draw();
        new Triangle(raster, 3, 6).draw();

        // ===================== TASK 04: Proxy =========================
        System.out.println("\n======================================");
        System.out.println("   TASK 04 - Proxy");
        System.out.println("======================================");

        // Create a test file
        java.io.File testFile = new java.io.File("test.txt");
        try (java.io.PrintWriter pw = new java.io.PrintWriter(testFile)) {
            pw.println("Hello World");
            pw.println("This is a test file");
            pw.println("Third line here");
        } catch (Exception e) { e.printStackTrace(); }

        System.out.println("-- Logging Proxy --");
        SmartTextReader base    = new SmartTextReader();
        SmartTextChecker checker = new SmartTextChecker(base);
        char[][] result = checker.read("test.txt");
        System.out.println("First line: " + new String(result[0]));

        System.out.println("\n-- Access Control Proxy --");
        SmartTextReaderLocker locker = new SmartTextReaderLocker(base, "secret|private|locked");
        locker.read("test.txt");
        locker.read("secret_data.txt");
        locker.read("private_config.txt");

        testFile.delete();

        // ===================== TASK 05: Composite =====================
        System.out.println("\n======================================");
        System.out.println("   TASK 05 - Composite (LightHTML)");
        System.out.println("======================================");

        LightElementNode table = new LightElementNode("table",
                LightElementNode.DisplayType.BLOCK,
                LightElementNode.ClosingType.WITH_CLOSING_TAG,
                List.of("data-table"));

        LightElementNode tr1 = new LightElementNode("tr",
                LightElementNode.DisplayType.BLOCK,
                LightElementNode.ClosingType.WITH_CLOSING_TAG, List.of());
        tr1.addChild(makeCell("th", "Name"))
           .addChild(makeCell("th", "Age"))
           .addChild(makeCell("th", "City"));

        LightElementNode tr2 = new LightElementNode("tr",
                LightElementNode.DisplayType.BLOCK,
                LightElementNode.ClosingType.WITH_CLOSING_TAG, List.of());
        tr2.addChild(makeCell("td", "Alice"))
           .addChild(makeCell("td", "25"))
           .addChild(makeCell("td", "Kyiv"));

        table.addChild(tr1).addChild(tr2);

        System.out.println("innerHTML:\n" + table.innerHTML());
        System.out.println("outerHTML:\n" + table.outerHTML());

        // ===================== TASK 06: Flyweight =====================
        System.out.println("\n======================================");
        System.out.println("   TASK 06 - Flyweight");
        System.out.println("======================================");

        String bookText = """
                Romeo and Juliet
                ACT I
                Scene I. Verona. A public place.
                  Two households, both alike in dignity,
                In fair Verona, where we lay our scene,
                From ancient grudge break to new mutiny,
                ACT II
                Scene I. A lane by the wall of Capulet orchard.
                  He jests at scars that never felt a wound.
                In fair Verona, where we lay our scene again,
                """;

        System.out.println("-- Without Flyweight --");
        long beforeFlyweight = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        LightElementNode doc = BookParser.parse(bookText);
        long afterFlyweight = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory used (approx): " + (afterFlyweight - beforeFlyweight) / 1024 + " KB");
        System.out.println("Flyweight cache size (unique element types): " + LightElementFactory.getCacheSize());
        System.out.println("Total lines parsed: " + doc.getChildCount());
        System.out.println("\nFirst 300 chars of output:\n" + doc.outerHTML().substring(0, Math.min(300, doc.outerHTML().length())));
    }

    private static LightElementNode makeCell(String tag, String text) {
        return new LightElementNode(tag,
                LightElementNode.DisplayType.INLINE,
                LightElementNode.ClosingType.WITH_CLOSING_TAG,
                List.of()).addChild(new LightTextNode(text));
    }
}
