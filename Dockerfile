# Etapa 1: Construir o aplicativo
FROM openjdk:21-slim as build

RUN apt-get update && apt-get install -y maven
# Definir o diretório de trabalho
WORKDIR /app

# Copiar o código fonte para dentro do contêiner
COPY . /app

# Baixar as dependências e compilar o projeto
RUN mvn clean package -DskipTests

# Etapa 2: Executar o aplicativo
FROM openjdk:21-jdk-slim

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo JAR gerado pela etapa de build
COPY --from=build /app/target/*.jar /app/app.jar

# Expor a porta do aplicativo
EXPOSE 8080

# Comando para rodar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
