# Agente Java

El proyecto consta de:
1. **Mapa**: Matriz bidimensional de 10x10.
2. **Agente**: Un agente que se mueve dentro del mapa.
3. **SubMapa**: Un mapa más pequeño que el agente utiliza para registrar su recorrido.

## Funcionamiento

En el mapa se originan de forma aleatoria recursos y obstáculos. El agente se mueve de forma aleatoria, evitando obstáculos y tratando de encontrar un recurso. Una vez encontrado el recurso, el agente regresa al punto inicial por sí solo.

## Características

- **Programación Orientada a Objetos (POO)**: Uso de clases y objetos para modelar el mapa, el agente y el submapa.
- **Generación Aleatoria**: Recursos y obstáculos se colocan aleatoriamente en el mapa.
- **Algoritmo de Búsqueda**: El agente busca recursos en el mapa evitando obstáculos.
- **Retorno Automático**: El agente tiene la capacidad de volver al punto de inicio después de encontrar un recurso.
- **Gestión de Errores**: Mecanismos para manejar situaciones en las que el agente se queda atrapado.

## Requisitos Previos

- [Java Development Kit (JDK) 8 o superior](https://www.oracle.com/java/technologies/javase-downloads.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) (opcional, pero recomendado)

## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/Josafat-VC/agentes-java.git
    ```
2. Navega al directorio del proyecto:
    ```bash
    cd agentes-java
    ```
3. Abre el proyecto en tu IDE favorito y compílalo.

## Uso

1. Compila y ejecuta el proyecto desde tu IDE.
2. Sigue las instrucciones en la interfaz para iniciar la simulación del agente.
3. Observa cómo el agente se mueve dentro del mapa, evita obstáculos, encuentra recursos y regresa al punto inicial.

## Ejemplo de Código

```java
public class Mapa {
    // Código del Mapa
}

public class Agente {
    // Código del Agente
}

public class SubMapa {
    // Código del SubMapa
}

public class Simulacion {
    public static void main(String[] args) {
        // Código de la Simulación
    }
}
```

## Contribución
1. Haz un fork del repositorio.
2. Crea una nueva rama (git checkout -b feature/nueva-caracteristica).
3. Realiza tus cambios y haz commit (git commit -am 'Añadir nueva característica').
4. Haz push a la rama (git push origin feature/nueva-caracteristica).
5. Abre un Pull Request.

##Licencia
Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

Autor
Josafat-VC - Josafat-VC en GitHub

Este README incluye una descripción detallada, características del proyecto, y las tecnologías y conceptos utilizados. Puedes ajustarlo según tus necesidades.
