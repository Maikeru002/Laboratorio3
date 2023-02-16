Nombres: 
Jaider Arley Gonzalez Arias
Miguel Angel Barrera Diaz

# AeroDescuentos
Se está desarrollando para una aerolínea su módulo de liquidación de tiquetes aéreos. Para el mismo, se tiene una función que aplica descuentos a la tarifa base del vuelo dependiendo del tiempo de antelación de la reserva y la edad del pasajero. Los descuentos SON ACUMULABLES.
    
Normativa 005, sobre los descuentos:

    - 15% de descuento sacando el billete con antelación superior a 20días.
    - 5% a los pasajeroscon edad inferior a 18años y 8% a los pasajeros con edad superior a 65 años.


1. De acuerdo con lo indicado,y teniendo en cuenta que NO hay precondiciones,en qué casos se debería arrojar una excepción de tipo ExcepcionParametrosInvalidos?. Agregue esto a la especificación.

    Los casos que deben lanzar la excepción son:

    1. Valores negativos para diasAntelacion.
    2. Valones negativos para edad.
    3. Valores fuera del rango de edad posible.
    4. Valores de tarifas negativos.
    5. Valores no numeros en cualquiera de las variables.


2. En la siguiente tabla enumere un conjunto de clases de equivalencia que -según usted-creen una buena división del conjunto de datos de entrada de la función anterior:

| Numero | Clase de equivalencia | Resultado |
| ------ | --------------------- | --------- |
| 1 | Datos tipo String | Incorrecto | 
| 2 | Datos numericos negativos | Incorrecto |
| 3 | Datos numéricos y positivos | Correcto |

3. Para cada clase de equivalencia, defina un casode prueba específico, definiendo: parámetros de entrada y resultados esperados.

``` 

calculoTarifa
    @Test
    public void ValorNegativoEdad() throws ExcepcionParametrosInvalidos {
        try {
            calculoTarifa(20000,15,-20);
        }
        catch (exception e){
            Asset.assertEquals(e.getmessage(), ExcepcionParametrosInvalidos.NUMERO_NEGATIVO);
        }
        
    }

    @Test
    public void valorNegativoTarifa() throws ExcepcionParametrosInvalidos {        
        try {
            calculoTarifa(-20000,15,30);
        }
        catch (exception e){
            Asset.assertEquals(e.getmessage(), ExcepcionParametrosInvalidos.NUMERO_NEGATIVO);
        }
    }

    @Test
    public void ValorNegativoDias() throws ExcepcionParametrosInvalidos {
        try {
            calculoTarifa("20000",-15,30);
        }
        catch (exception e){
            Asset.assertEquals(e.getmessage(), ExcepcionParametrosInvalidos.DATO_STRING);
        }
        
    }

``` 

4. A partir de las clases de equivalencia identificadas en el punto 2, identifique las condiciones límite o de frontera de las mismas.

| Numero | Clase de equivalencia | Frontera |
| ------ | --------------------- | --------- |
| 1 | Datos tipo String | n.getClass().getSimpleName() != Integer |
| 2 | Datos numericos negativos | n < 0 |
| 3 | Datos numéricos y positivos | n > 0 |


5. Para cada una de las condiciones de frontera anteriores, defina casos de prueba específicos.
``` 

calculoTarifa

    @Test
    public void ValorNegativoDias() throws ExcepcionParametrosInvalidos {
        try {
            calculoTarifa("20000","-15","30");
        }
        catch (exception e){
            Asset.assertEquals(e.getmessage(), ExcepcionParametrosInvalidos.DATO_STRING);
        }
        
    }

    @Test
    public void ValorNegativoEdad() throws ExcepcionParametrosInvalidos {
        try {
            calculoTarifa(-20000,-15,-20);
        }
        catch (exception e){
            Asset.assertEquals(e.getmessage(), ExcepcionParametrosInvalidos.NUMERO_NEGATIVO);
        }
        
    }

    @Test
    public void valorNegativoTarifa() throws ExcepcionParametrosInvalidos {      
        
        calculoTarifa(20000,15,30);
    }

    

``` 



