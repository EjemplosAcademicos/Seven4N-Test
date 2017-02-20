# Prueba técnica S4N - Etapa II

 
```
Sebatian Monsalve Solis
sebas.monsalve@gmail.com
+57 300 441 8576
```

```
La aplicación capaz de operar (20) drones para que haga entrega simultaneas de almuerzos a diferentes direcciones en la ciudad de Bogotá.
Un ejemplo del archivo de texto que ingresaría al sistema para las entregas de un día sería:

AAAAIAAD
DDAIAD
AAIADAD

Donde:
 - La letra A corresponde a un movimiento hacia adelante.
 - La letra I corresponde a un giro de 90 grados del dron a la izquierda.
 - La letra D corresponde a un giro de 90 grados del dron a la derecha.
 
Aclaraciones:
 - Cada línea del archivo de texto corresponde a una entrega de un almuerzo.
 - El dron siempre inicia en la posición (0, 0) orientación Norte
```

## Prerequisitos
```
java version "1.8"

Asegurate que tu variable de entorno JAVA_HOME apunto a el directorio jdk1.8.0 donde fue extraido el JDK

```
## Instalación
```
java -jar CorrientazoDomicilio_2.0.0.jar
```
## Estructura de la aplicación

```
|-- src
|   |-- main/java/com/s4n/
|   |   |-- corrientazao
|   |   	|-- App.java                   # main 
|   |   	|-- CorrientazoDomicilio.java 
|   |   |-- delivery        			       
|   |       |-- Dron
|   |       |-- Entrega 
|   |       ...
|   |   |-- exception
|   |       |-- DeliveryException          # manejo de las excepciones del program       
|   |       ... 
|   |   |-- ruta
|   |       ... 
|   |   |-- util                           # utilidades comunes del program
|   |   ...    
|   | 	...
|	|-- test/java/com/s4n/delivery     	   # Modulo de test Junit  
|	|-- test/java/resouces/test_files      # Archivos de prueba
...
|-- pom.xml                                # maven configuration dependencies
|-- release     	
|   |--CorrientazoDominicilio_2.0.0.jar    # Jar ejecutable del programa              
|-- doc     							   # Java Doc	
|   |--index.html		                   	      
...
	
```

## Información útil 	

```
 - La aplicación es capaz de operar un (20) dron
 - Sólo entregará domicilios a 10 cuadras a la redonda de su barrio
 - El dron es sólo capaz de cargar hasta 10 almuerzos por vez
 - El dron siempre inicia en la posición (0, 0) orientación Norte, pero continua el resto de sus entragas partiendo desde la última entrega realizada
 
```