# Используем официальный образ Java
FROM openjdk:17-jdk-slim

# Создаём рабочую папку внутри контейнера
WORKDIR /app

# Копируем jar-файл (который собирается в target)
COPY target/*.jar app.jar

# Указываем порт приложения
EXPOSE 8080

# Команда запуска
ENTRYPOINT ["java", "-jar", "app.jar"]
