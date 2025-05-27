# 🔧 Этап 1: Сборка проекта
FROM gradle:8.5-jdk17 AS builder
WORKDIR /app
COPY . .
RUN ./gradlew clean bootJar

# 🚀 Этап 2: Финальный образ
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Копируем готовый jar из первого этапа
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
