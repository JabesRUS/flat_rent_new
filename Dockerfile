# Используем Java 17
FROM eclipse-temurin:17-jdk-alpine

# Папка внутри контейнера
WORKDIR /app

# Копируем собранный jar-файл внутрь контейнера
COPY build/libs/flat_rent_new-*.jar app.jar

# Порт, на котором работает Spring Boot
EXPOSE 8080

# Команда запуска
ENTRYPOINT ["java", "-jar", "app.jar"]
