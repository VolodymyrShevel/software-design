package com.patterns;

import com.patterns.task01.creator.*;
import com.patterns.task02.factory.*;
import com.patterns.task03.Authenticator;
import com.patterns.task04.Virus;
import com.patterns.task05.builder.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));

        // ===================== TASK 01: Factory Method =====================
        System.out.println("======================================");
        System.out.println("   TASK 01 - Factory Method");
        System.out.println("======================================");
        new WebSite().printAllSubscriptions();
        new MobileApp().printAllSubscriptions();
        new ManagerCall().printAllSubscriptions();

        // ===================== TASK 02: Abstract Factory ==================
        System.out.println("\n======================================");
        System.out.println("   TASK 02 - Abstract Factory");
        System.out.println("======================================");
        new IProneFactory().printAll();
        new KiaomiFactory().printAll();
        new BalaxyFactory().printAll();

        // ===================== TASK 03: Singleton ========================
        System.out.println("\n======================================");
        System.out.println("   TASK 03 - Singleton");
        System.out.println("======================================");
        Authenticator auth1 = Authenticator.getInstance();
        Authenticator auth2 = Authenticator.getInstance();
        System.out.println("auth1 == auth2: " + (auth1 == auth2));
        auth1.login("admin", "wrong");
        auth1.login("admin", "1234");
        System.out.println("Current user: " + auth2.getCurrentUser());
        auth1.logout();

        // ===================== TASK 04: Prototype ========================
        System.out.println("\n======================================");
        System.out.println("   TASK 04 - Prototype");
        System.out.println("======================================");
        Virus grandParent = new Virus("Alpha", "CoronaX", 0.001, 100);
        Virus parent1 = new Virus("Beta",    "CoronaX", 0.0008, 50);
        Virus parent2 = new Virus("Gamma",   "CoronaX", 0.0009, 60);
        Virus child1  = new Virus("Delta",   "CoronaX", 0.0005, 20);
        Virus child2  = new Virus("Epsilon", "CoronaX", 0.0006, 25);
        Virus child3  = new Virus("Zeta",    "CoronaX", 0.0004, 15);
        parent1.addChild(child1);
        parent1.addChild(child2);
        parent2.addChild(child3);
        grandParent.addChild(parent1);
        grandParent.addChild(parent2);

        System.out.println("--- Original ---");
        grandParent.print("");
        Virus cloned = grandParent.clone();
        cloned.setName("Alpha-CLONE");
        cloned.getChildren().get(0).setName("Beta-CLONE");
        System.out.println("--- Clone (changes do not affect original) ---");
        cloned.print("");
        System.out.println("--- Original after cloning ---");
        grandParent.print("");

        // ===================== TASK 05: Builder ==========================
        System.out.println("\n======================================");
        System.out.println("   TASK 05 - Builder");
        System.out.println("======================================");
        CharacterDirector director = new CharacterDirector();
        System.out.println(director.buildHero(new HeroBuilder()));
        System.out.println(director.buildEnemy(new EnemyBuilder()));
    }
}
