# Usamos una imagen base de Java 17 (cambia la versión si es necesario)
FROM eclipse-temurin:17-jdk

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado al contenedor
COPY target/*.jar app.jar

# Expone el puerto en el que corre la app (cambia si usas otro)
EXPOSE 8080

# Comando para ejecutar la app
CMD ["java", "-jar", "app.jar"]
