package com.testing.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Sumar implements Task {

    private int a,b;

    public Sumar(int a, int b){
        this.a = a;
        this.b =b;
    }

    public static Sumar numeros(int a, int b){
        return instrumented(Sumar.class,a,b);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String url;
        if(b!=0){
             url = "add?a="+this.a+"&b="+this.b;
        }else{
             url = "add?a="+this.a+"&b=";
        }

        actor.attemptsTo(
                Get.resource(url)
        );
    }
}
