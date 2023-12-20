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
![image](https://github.com/alanyur/ProyectoSemestral-P2/assets/60883242/6af45845-34be-439f-b9e0-c9de6ad0cbef)

### Caso de Uso
![Captura de pantalla 2023-12-19 214856](https://github.com/alanyur/ProyectoSemestral-P2/assets/137654122/284a5bee-4d99-41ab-a09b-04aabbc930f3)
##
En el diagrama adjunto se muestra como el usuario tiene multiples casos de usos, siendo el primero (en el código) el de elegir una ruta (origen y destino) lo cual se extendera (al presionar botón siguiente) a otra pestaña que le permitira elegir un bus (con su horario y clase específicos) esto a su vez extendera a otro caso de uso, del cual (de nuevo al presionar botón siguiente) aparecerá una tercera pestaña con una cantidad de asientos definida a partir del bus seleccionado anteriormente, esta misma tendrá implementada un botón que finalizaría la ejecución (o elecciones) del programa.



### Interfaz

![image](https://github.com/alanyur/ProyectoSemestral-P2/assets/60883242/d2ace5f7-5084-4e6e-b225-89a4d1e067b1)
![image](https://github.com/alanyur/ProyectoSemestral-P2/assets/60883242/ca928965-c0a2-4df8-b85d-0045b938c337)
![imagenasientos](https://github.com/alanyur/ProyectoSemestral-P2/assets/137654122/611b354d-2d52-4aa3-bc39-4621b371b7c2)


### Desarrollo del Proyecto  
A lo largo del proyecto, se tomaron tres decisiones fundamentales. En primer lugar, se priorizó la usabilidad diseñando una interfaz intuitiva con tres estados distintos: selección de origen-destino, tipo de bus y asiento. Esto tratando de utilizar o asemejar el patrón de diseño observer el cual nos permitiría en base a una o más instancias de mouselistener avisar a las otras clases (sea bus, asiento, etc.) lo que está sucediendo para dar un parámetro u otro dependiendo de lo que se haya seleccionado.  

En segundo lugar, se definió limitar la entrada de datos a tres parámetros, uno por cada estado, simplificando así el proceso para el usuario. Estas decisiones estratégicas se enfocaron en simplificar la interacción del usuario y garantizar una navegación lógica y fluida a través de las fases de reserva de buses.  

Por ultimo la clase "Ventana" asumió el rol de administrador para gestionar estos estados, facilitando la transición mediante un botón dedicado.  

Se pueden resaltar fallos o carencias que tuvimos al desarrollar el programa, como el intento de utilizar más de un patrón de diseño. Teníamos la idea de integrar un botón "anterior" además del "siguiente", el cual seguiría la lógica del patrón memento. Otro error por nuestra parte fue que al elegir el destino, este se repetía en la siguiente ventana en las rutas de los buses. Por ejemplo, en lugar de ser "Santiago-Concepción", se mostraba como "Santiago-ConcepciónConcepciónConcepción". 

Durante el desarrollo de este proyecto, nos enfrentamos a diversos desafíos como los mencionados anteriormente que merecen autocrítica. Uno de los principales obstáculos fue la dificultad para establecer una comunicación efectiva entre distintas clases, lo que nos impidió visualizar los datos seleccionados en el siguiente estado de manera coherente. Además, nos encontramos con dificultades significativas al intentar implementar la lógica necesaria para identificar cuándo un asiento estaba ocupado, un aspecto que lamentablemente no logramos resolver en esta iteración del programa. Por último, nos resultó arduo mejorar la estética general del sistema, ya que buscábamos que fuera más agradable visualmente, pero nos topamos con limitaciones en este aspecto.

A pesar de los inconvenientes, es importante reflexionar sobre este proceso. Reconocemos que el programa no alcanzó su potencial máximo y asumimos la responsabilidad de estas limitaciones. Esta experiencia nos ha permitido identificar nuestras debilidades y nos motiva a trabajar en mejoras futuras. Valoramos este proyecto como una oportunidad para aprender de nuestros errores y estamos comprometidos a utilizar esta experiencia para crecer y mejorar en futuros proyectos.
