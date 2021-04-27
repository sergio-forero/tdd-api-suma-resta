#language: es
#Autor: Brayan Martinez
@Test
Característica: Suma de la calculadora

  Esquema del escenario: Suma de dos numeros de forma correcta.
    Dado que carlos proporciona dos numeros en la calculadora <a> y <b>
    Cuando solicite el resultado de la suma
    Entonces la calculadora informara el resultado de la suma entre los dos numeros proporcionados
    Ejemplos:
      |a|b|
      |1|1|

  Esquema del escenario: Intento de suma con cantidad de parametros incorrecta
    Dado que carlos proporciona la cantidad de parametros incorrecta a la calculadora <a> y <b>
    Cuando solicite el resultado de la suma o la resta
    Entonces la calculadora informara que la cantidad de numeros proporcionada no es valida
  Ejemplos:
    |a|b|
    |1|"abc"|

  Escenario: Intento de suma con caracteres no validos
    Dado que carlos proporciona en a la calculadora caracteres no validos como simbolos, vacios o texto
    Cuando solicite el resultado de la suma o la resta
    Entonces la calculadora informara que no puede realizar la suma por que debe digitar unicamente numeros
