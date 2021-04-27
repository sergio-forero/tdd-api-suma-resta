#language: es
#Autor: Brayan Martinez
@Test
Característica: Resta de la calculadora

  Esquema del escenario: Resta de dos numeros de forma correcta.
    Dado que carlos proporciona dos numeros en la calculadora <a> y <b>
    Cuando solicite el resultado de la resta
    Entonces la calculadora informara el resultado de la resta entre los dos numeros proporcionados
    Ejemplos:
      |a|b|
      |4|2|
