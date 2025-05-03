# Bienvenidos, devs backend!

# 🧠 Ejercicio Teórico - Programación Orientada a Objetos en Java

Este desafío complementa el trabajo práctico que desarrollaron anteriormente.

El objetivo es que puedas **reflexionar sobre los conceptos clave de Java y la POO**, y detectar si estás comprendiendo la forma en que se estructura un programa en este lenguaje.

A continuación, respondé estas preguntas directamente por escrito, debajo de cada punto.

---

## 🔹 Preguntas sobre Java

1. ¿Cuál es la diferencia entre una clase y un objeto en Java?
Una clase es como una plantilla que contiene los atributos y comportamientos, 
mientras que un objeto es una instancia de la clase, que lo que hace es heredar estas propiedades
y comportamientos.

2. ¿Por qué en Java todo debe estar dentro de una clase?
Porque java es un lenguaje diseñado para ser de POO 

3. ¿Qué significa que Java sea un lenguaje *fuertemente tipado*?
Significa que hay que definir explicitamente de que tipo es una variable, 
o que tipo retorna una funcion, esto hace que en tiempo de compilacion se verifiquen errores de tipos.

4. ¿Qué función cumple el método `main()` en una aplicación Java?
Es el metodo que la JVM busca para iniciar la ejecucion de una aplicacion.

5. ¿Qué diferencias notás entre Java y otros lenguajes que hayas usado anteriormente? (por ejemplo Python, JavaScript, etc.)
La principal diferencia que noto respecto a Javascript, que es el que mas use, es justamente la necesidad de indicar los tipos.
En Java es necesario compilar el programa que se ejecuta, mientras que en JS se puede ejecutar directamente sin compilar.


---

## 🔹 Preguntas sobre Programación Orientada a Objetos (POO)

6. ¿Qué es la **encapsulación** y por qué es importante?
La encapsulacion es cuando se ocultan ciertos datos de una clase y solo se expone lo necesario al exterior, por ejemplo utilizando metodos publicos.
Por ejemplo, usando atributos private pero luego accediendo a este dato a traves de getters y setters.

7. ¿Qué ventajas tiene crear métodos *getter* y *setter* en lugar de acceder directamente a los atributos?
Una de las ventajas es poder definir como modificar o leer un atributo.
Por ejemplo, si tengo que settear una edad, dentro del metodo podria verificar que la edad sea un numero mayor a 0, sino seria incorrecto.

8. ¿Qué es un **constructor** y para qué se usa?
Un constructor sirve para instanciar un objeto, una clase puede tener multiples constructores.
En cada constructor se pueden definir ciertos parametros que son necesarios para construir un objeto.


9. ¿Podés explicar con tus palabras qué es un **método** y cómo se relaciona con los objetos?
Un metodo es una accion que los objetos pueden realizar. Por ejemplo en una Clase Auto,
Podemos tener el metodo acelerar(), entonces todos los objetos que instanciemos de la clase Auto
Pueden utilizar este metodo.

10. ¿Cuál es el beneficio de tener más de una clase en un programa?
El tener multiples clases nos brinda modularidad, nos permite reutilizar codigo y tambien nos ayuda con el mantenimiento.
Por ejemplo, podemos tener un sistema de una facultad, donde una Clase Persona
tenga multiples atributos y los distintos tipos de Personas que hay en una facultad se instancien desde
esa misma clase (Empleado Administrativo, Profesor, Alumno, etc)
O podemos tener distintas Clases, Persona, Profesor, Alumno, EmpleadoAdministrativo, 
Donde podemos hacer uso de los distintos mecanismos de la POO, como la herencia, 
que nos permite tener un codigo mucho mas legible, facil de mantener y escalable.

---

## 🔹 Ejercicio reflexivo

11. Imaginá que estás programando un videojuego. ¿Qué clases podrías crear para representar los elementos del juego?  
    ¿Qué atributos y métodos tendrían esas clases?
Personaje -> Energia, Nivel, Vida
Enemigo -> Energia, Vida, Nombre 
Tablero -> Nombre, enemigos, items
Item -> Nombre, Tipo, Valor 

---

### ✅ Objetivo de estas preguntas

Estas preguntas no tienen una única respuesta correcta. Lo importante es que puedas expresarte con tus palabras, detectar lo que ya sabés y lo que no te queda claro.  
¡Si algo no lo entendés, preguntá! Así todos seguimos aprendiendo juntos 😊

--- 

## 📂 Estructura de paquetes y clases

Las clases de un proyecto pueden ser estructuradas de diferentes maneras dependiendo de varios factores, como la complejidad, 
el tipo de proyecto, la arquitectura, entre otras cosas. Los paquetes son los que nos permiten organizar las clases, agrupando aquellas 
que tengan algún vínculo entre sí. 

En este repositorio, se plantea la siguiente estructura de paquetes: `src/main/[nombre-ejercicio]`
Dentro de cada carpeta de ejercicio van a encontrar los siguientes paquetes base: 
- `model` **(lo tienen que crear ustedes)**: en este paquete se almacenan todas las clases de entidad que van a conformar el desarrollo del ejercicio.
- `service`: acá se va a encontrar la clase con el método main (punto de ejecución).
- `util` **(lo tienen que crear ustedes)**: acá pueden almacenar clases que contengan funcionalidades extra a las que ya poseen las clases de entidad.

Esta estructura de paquetes es una propuesta. En caso de no utilizar alguno de los paquetes sugeridos, pueden borrarlo (el util, por ejemplo), 
como así también pueden agregar algún otro paquete que consideren necesario, siempre y cuando sea coherente (es decir, que aporte a la organización 
y entendimiento). 
