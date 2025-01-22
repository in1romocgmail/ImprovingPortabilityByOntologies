# ImprovingPortabilityByOntologies

Código fuente utilizado en el artículo: López-Zambrano, J., Lara, J.A. & Romero, C. Improving the portability of predicting students’ performance models by using ontologies. J Comput High Educ 34, 1–19 (2022). https://doi.org/10.1007/s12528-021-09273-3

Este código permite el preprocesamiento de conjuntos de datos de Moodle y la realización de pruebas de portabilidad utilizando la libreria Weka.

## Estructura

 README.md                  # Descripción e instrucciones de uso  
 requirements.txt           # Requisitos  
 src/                       # Código fuente  
 ├── Preprocess.java        # Clase para preprocesar datos  
 ├── PortabilityTests.java  # Clase para ejecutar las pruebas de portabilidad  
 ├── sd_dfptree.py          # Script SD-DFPTRee Spark descubrir reglas  
 lib/
 ├── weka.jar               # Libreria weka  
 

## Requisitos Previos

1. Java Development Kit (JDK) 8 o superior.
2. Librería Weka: Coloca el archivo `weka.jar` en el directorio `lib/`.

## Instalación

Clona el repositorio 
```
git clone https://github.com/in1romocgmail/ImprovingPortabilityByOntologies.git
```

## Uso

### Preprocesamiento

Ejecuta la clase `Preprocess` para preprocesar conjuntos de datos. Sigue los pasos a continuación:

1. Compila el archivo `Preprocess.java`:
javac -cp lib/weka.jar src/Preprocess.java

2. Ejecuta la clase compilada:
java -cp lib/weka.jar:src Preprocess

### Pruebas de Portabilidad

Ejecuta la clase `PortabilityTests` para realizar pruebas de portabilidad. Sigue los pasos a continuación:

1. Compila el archivo `PortabilityTests.java`:
```
javac -cp lib/weka.jar src/PortabilityTests.java
```

2. Ejecuta la clase compilada:
```
java -cp lib/weka.jar:src PortabilityTests
```

## Notas

- Asegúrate de que el archivo `weka.jar` esté disponible en el directorio `lib/`.
- Actualiza las rutas de los archivos en `Preprocess.java` y `PortabilityTests.java` para que coincidan con la ubicación de tus conjuntos de datos.
