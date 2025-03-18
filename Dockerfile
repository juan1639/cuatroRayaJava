# Imagen base de Maven para compilar
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar archivos del proyecto y compilar
COPY . .
RUN mvn clean package -DskipTests

# Imagen final con Java
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copiar el JAR generado desde la imagen anterior
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
