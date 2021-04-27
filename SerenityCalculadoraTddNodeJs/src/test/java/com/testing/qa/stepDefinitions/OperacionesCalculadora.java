package com.testing.qa.stepDefinitions;

import com.testing.qa.tasks.Restar;
import com.testing.qa.tasks.Sumar;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class OperacionesCalculadora {
    private final static String URL = "http://localhost:1234/";

    @Dado("que Carlos proporciona dos numeros en la calculadora {int} y {int}")
    public void que_carlos_proporciona_dos_numeros_en_la_calculadora(int a, int b) {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActor("Carlos").whoCan(CallAnApi.at(URL));
        OnStage.theActorInTheSpotlight().remember("a", a);
        OnStage.theActorInTheSpotlight().remember("b", b);
    }

    @Cuando("solicite el resultado de la suma")
    public void solicite_el_resultado_de_la_suma() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Sumar.numeros(OnStage.theActorInTheSpotlight().recall("a"), OnStage.theActorInTheSpotlight().recall("b"))
        );
    }

    @Cuando("solicite el resultado de la resta")
    public void solicite_el_resultado_de_la_resta() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Restar.numeros(OnStage.theActorInTheSpotlight().recall("a"), OnStage.theActorInTheSpotlight().recall("b"))
        );
    }

    @Entonces("la calculadora informara el resultado de la suma entre los dos numeros proporcionados")
    public void la_calculadora_informara_el_resultado_de_la_suma_entre_los_dos_numeros_proporcionados() {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThatResponse("La respuesta debe ser 200", response -> response.statusCode(200)));
    }

    @Entonces("la calculadora informara el resultado de la resta entre los dos numeros proporcionados")
    public void la_calculadora_informara_el_resultado_de_la_resta_entre_los_dos_numeros_proporcionados() {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThatResponse("La respuesta debe ser 200", response -> response.statusCode(200)));
    }

    @Dado("que Carlos proporciona la cantidad de parametros incorrecta a la calculadora {int} y {word}")
    public void que_carlos_proporciona_la_cantidad_de_parametros_incorrecta_a_la_calculadora(int a, String b) {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActor("Carlos").whoCan(CallAnApi.at(URL));
        OnStage.theActorInTheSpotlight().remember("a", a);
        OnStage.theActorInTheSpotlight().remember("b", b);
    }

    @Cuando("solicite el resultado de la suma o la resta")
    public void solicite_el_resultado_de_la_suma_o_la_resta() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Sumar.numeros(OnStage.theActorInTheSpotlight().recall("a"), 0)
        );
    }

    @Entonces("la calculadora informara que la cantidad de numeros proporcionada no es valida")
    public void la_calculadora_informara_que_la_cantidad_de_numeros_proporcionada_no_es_valida() {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThatResponse("La respuesta debe ser 422", response -> response.statusCode(422)));
    }

    @Dado("que Carlos proporciona en a la calculadora caracteres no validos como simbolos, vacios o texto")
    public void que_carlos_proporciona_en_a_la_calculadora_caracteres_no_validos_como_simbolos_vacios_o_texto() {
        OnStage.theActorInTheSpotlight().remember("a", 1);
        OnStage.theActorInTheSpotlight().remember("b", 0);
    }

    @Entonces("la calculadora informara que no puede realizar la suma por que debe digitar unicamente numeros")
    public void la_calculadora_informara_que_no_puede_realizar_la_suma_por_que_debe_digitar_unicamente_numeros() {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThatResponse("La respuesta debe ser 422", response -> response.statusCode(422)));
    }
}
