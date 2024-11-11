# Gestión Gym Valencia

**Gestión Gym Valencia** es un sistema de gestión para gimnasios que permite registrar la asistencia de los miembros, gestionar membresías, administrar el inventario de equipos y llevar un control del personal. Este proyecto está desarrollado en Java 17 utilizando Apache NetBeans y Maven.

## Requisitos

Antes de empezar, asegúrate de tener instalado lo siguiente:

- **Java 17**: El proyecto utiliza Java 17. Puedes descargarlo desde [aquí](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
- **Maven**: Es necesario para gestionar las dependencias del proyecto y la configuración de compilación. Puedes descargar Maven desde [aquí](https://maven.apache.org/download.cgi).

## Instrucciones de Instalación en Windows

1. Clona el repositorio en tu máquina local. Abre una terminal y ejecuta el siguiente comando:

   ```bash
   git clone https://github.com/JimSegovia/GestorGymValencia.git
   ```

2. Accede al directorio del proyecto:

  ```bash
   cd GestorGymValencia
   ```

2. Compila el proyecto usando Maven para descargar las dependencias necesarias y construir el proyecto:

  ```bash
   mvn clean install
   ```

4. Ejecución del proyecto:

  ```bash
   mvn exec:java -Dexec.mainClass="tempRunner.App"
   ```
## Ejecución en Apache NetBeans

1. Abre Apache NetBeans.
2. Selecciona **File > Open Project** y navega hasta la carpeta donde clonaste **GestorGymValencia**.
3. Haz clic en **Open Project**.
4. Una vez abierto el proyecto en NetBeans, haz clic derecho en el archivo `App.java` dentro del paquete `tempRunner` y selecciona **Run File** para iniciar el programa.

## Integrantes:

1. Jim Jordan Bryan Segovia Valencia
2. Sebastian Joaquin Chicata Serrato
3. Garcia Ávalos Nicolás
4. Cansaya Cutipa Frank Emanuel
