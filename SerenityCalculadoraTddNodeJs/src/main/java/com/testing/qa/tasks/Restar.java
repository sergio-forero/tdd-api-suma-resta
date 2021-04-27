package com.testing.qa.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Restar implements Task {
    private int a, b;

    public Restar(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public static Restar numeros(int a, int b) {
        return instrumented(Restar.class, a, b);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String url = "subtract?a=" + this.a + "&b=" + this.b;
        actor.attemptsTo(
                Get.resource(url)
        );
    }
}
