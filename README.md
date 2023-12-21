# Proyecto de Reserva de Buses

## Grupo y Participantes
  Grupo: 23  
    Participantes:  
        -Alan Yuren Ibacache Gonelli  
        -Juan Agustin Umaña Silva

## Enunciado

  El sistema de reserva de asientos de autobús permite al personal de una empresa de autobús elegir y reservar asientos de forma conveniente por su cliente. Los usuarios pueden  visualizar una representación gráfica de los asientos disponibles en el  autobús y seleccionar los que deseen ocupar. El sistema muestra información detallada sobre cada asiento, como su ubicación, número y  categoría (por ejemplo, semi cama, Salón Cama).
    Una vez que los usuarios seleccionan los asientos deseados, el sistema verifica la disponibilidad y permite confirmar la reserva mostrando el precio a pagar. En caso de que algún asiento ya esté reservado por otro pasajero, se informa al usuario para que pueda elegir otro asiento disponible. El personal confirma el pago (no gestionado por el sistema) lo que reserva los asientos.
    El sistema debe gestionar varios tipos de autobuses (por ejemplo, con diferente número de plazas, o de 1 o 2 pisos...).
    El sistema debe mostrar un menú que permita seleccionar el autobús en función de su horario y recorrido (se supone que estos datos están disponibles con los autobuses vacíos cuando se lanza el software)

### Diagrama de Clases UML 
![Captura de pantalla 2023-12-20 211146](https://github.com/alanyur/ProyectoSemestral-P2/assets/137654122/042020b2-8f95-4040-9298-207b3599af3b)
![Captura de pantalla 2023-12-20 211246](https://github.com/alanyur/ProyectoSemestral-P2/assets/137654122/b10f0760-1a22-4e58-9039-e5fd10c05a18)
![Captura de pantalla 2023-12-20 211313](https://github.com/alanyur/ProyectoSemestral-P2/assets/137654122/4e16f2a7-54f4-4e89-b307-141ec5fc763a)


### Caso de Uso
![Captura de pantalla 2023-12-19 214856](https://github.com/alanyur/ProyectoSemestral-P2/assets/137654122/284a5bee-4d99-41ab-a09b-04aabbc930f3)
##
En el diagrama adjunto se muestra como el usuario tiene multiples casos de usos, siendo el primero (en el código) el de elegir una ruta (origen y destino) lo cual se extendera (al presionar botón siguiente) a otra pestaña que le permitira elegir un bus (con su horario y clase específicos) esto a su vez extendera a otro caso de uso, del cual (de nuevo al presionar botón siguiente) aparecerá una tercera pestaña con una cantidad de asientos definida a partir del bus seleccionado anteriormente, esta misma tendrá implementada un botón que finalizaría la ejecución (o elecciones) del programa.



### Interfaz
![Captura de pantalla 2023-12-20 192858](https://github.com/alanyur/ProyectoSemestral-P2/assets/137654122/40b238af-90d1-49e8-8f18-1debdd4979bb)
![Captura de pantalla 2023-12-20 192913](https://github.com/alanyur/ProyectoSemestral-P2/assets/137654122/4b29ffa9-dfcf-4c38-a199-32f0d39d9205)
![Captura de pantalla 2023-12-20 192954](https://github.com/alanyur/ProyectoSemestral-P2/assets/137654122/5d404dfc-41e0-4edf-bbfe-8a3c4504e49c)
![Captura de pantalla 2023-12-20 193024](https://github.com/alanyur/ProyectoSemestral-P2/assets/137654122/d48bfc3e-5ea9-4e67-8f7a-7aa60d359a6e)




### Desarrollo del Proyecto  
A lo largo del proyecto, se tomaron tres decisiones fundamentales. En primer lugar, se priorizó la usabilidad diseñando una interfaz intuitiva con tres estados distintos: selección de origen-destino, tipo de bus y asiento. Esto tratando de utilizar o asemejar el patrón de diseño observer el cual nos permitiría en base a una o más instancias de mouselistener avisar a las otras clases (sea bus, asiento, etc.) lo que está sucediendo para dar un parámetro u otro dependiendo de lo que se haya seleccionado.  

En segundo lugar, se definió limitar la entrada de datos a tres parámetros, uno por cada estado, simplificando así el proceso para el usuario. Estas decisiones estratégicas se enfocaron en simplificar la interacción del usuario y garantizar una navegación lógica y fluida a través de las fases de reserva de buses.  

Por ultimo la clase "Ventana" asumió el rol de administrador para gestionar estos estados, facilitando la transición mediante un botón dedicado.  

Se pueden resaltar fallos o carencias que tuvimos al desarrollar el programa, como el intento de utilizar más de un patrón de diseño. Teníamos la idea de integrar un botón "anterior" además del "siguiente", el cual seguiría la lógica del patrón memento. Otro error por nuestra parte fue que al elegir el destino, este se repetía en la siguiente ventana en las rutas de los buses. Por ejemplo, en lugar de ser "Santiago-Concepción", se mostraba como "Santiago-ConcepciónConcepciónConcepción". 

Durante el desarrollo de este proyecto, nos enfrentamos a diversos desafíos como los mencionados anteriormente que merecen autocrítica. Uno de los principales obstáculos fue la dificultad para establecer una comunicación efectiva entre distintas clases, lo que nos impidió visualizar los datos seleccionados en el siguiente estado de manera coherente. Además, nos encontramos con dificultades significativas al intentar implementar la lógica necesaria para identificar cuándo un asiento estaba ocupado, un aspecto que lamentablemente no logramos resolver en esta iteración del programa. Por último, nos resultó arduo mejorar la estética general del sistema, ya que buscábamos que fuera más agradable visualmente, pero nos topamos con limitaciones en este aspecto.

A pesar de los inconvenientes, es importante reflexionar sobre este proceso. Reconocemos que el programa no alcanzó su potencial máximo y asumimos la responsabilidad de estas limitaciones. Esta experiencia nos ha permitido identificar nuestras debilidades y nos motiva a trabajar en mejoras futuras. Valoramos este proyecto como una oportunidad para aprender de nuestros errores y estamos comprometidos a utilizar esta experiencia para crecer y mejorar en futuros proyectos.



### Cambios con respecto a la última actualización evaludada
A partir de la última vez que nuestro proyecto fue evaluado hemos logrado mejorar y/o cambiar grandes partes del código. Con respecto a cuando se inicia el código, la instancia de OrigenDestino ahora consta con botones más atractivos, los cuales desaparecen una vez que son usados (esto para evitar errores como multiples origenes o destinos por ejemplo) que sirven para elegir la ruta que tomará el bus por seleccionar (hablaremos más de estos en otro apartado). Para movilizarse entre las instancias de OrigenDestino, VentanaBuses y VentanaAsientos se modificó el código para que utilizara el patrón de diseño Memento, ahora con un botón "anterior" que hace uso del ya mencionado. Para la pestaña que deja elegir el Bus, ahora en vez de simples Jlabels seleccionables como era antes, ahora son más esteticos asemejandose a un Jboton siendo así más intuitivos para usar y cómodos para el usuario. La última instancia y pestaña que se genera es VentanaAsientos la cual ahora sí puede representar graficamente que hay asientos ocupados, junto a esta pestaña hay un botón que permitirá finalizar el proceso de elección de buses y asientos y cerrará el Jframe principal.
Con respecto a la parte logica del proyecto se decidio utilizar como patron de diseño a Iterator, ya que, este nos permite trabajar con la matriz que representa a los asientos del bus, sin tener que exponer su funcionamiento interno, para ello se implemento una clase'MatrixIterator', la cual permite manipular las estructuras de datos usando metodos como,next(),hasNext(),setElement(), entre otros.
En cuanto al código, lo limpiamos de muchas clases, instancias, variables y funciones que no eran de utilidad como la interface BusSelecListener o la clase Botones, que en realidad no hacian nada y estaban ahí por ser ideas sin completar, y agregamos Tests unitarios. También cambiamos los diagramas UML y de uso para ser más precisos y entendibles respectivamente.


### Errores, conflictos y demas
Uno de los principales conflictos que no logramos solucionar es el hecho de que se pueda volver a elegir la ruta, pues intentamos diversas maneras para lograr esto (con funciones, Memento, variables contadoras, dentro del mismo MouseListener, etc.) y no pudimos hacer que se "reiniciara", para "solucionar" esto añadimos un Jlabel en la clase ventana con la indicación "Si quiere otra ruta, actualice la página" que se mostrará si se vuelve a esa pestaña a traves del botón Anterior. Además de eso no pudimos lograr que se mantuviera una pestaña si se quería avanzar sin cumplir los requerimientos de la anterior, con esto nos referimos a que no pudimos hacer que si se quería avanzar a la pestaña de buses sin presionar origen (por ejemplo) saliera una pestaña de error y que después de cerrar dicha pestaña el código siguiera normalmente, para arreglar esto utilizamos exception en las clases VentanaBuses y VentanaAsientos para los casos nulos, excepción que nos arrojará una pestaña con un mensaje diciendo que presionemos los botones de forma lógica y que nos cerrará la ventana.
