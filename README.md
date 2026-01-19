# API de Logística - Foco em Sustentação

Projeto desenvolvido para simular o ecossistema de um marketplace, focando nos requisitos: monitoramento e investigação de defeitos.

## Tecnologias
- Java 25 / Spring Boot 3.5.9
- Spring Data JPA / H2 Database
- Spring Actuator (Observabilidade)

## Diferenciais Aplicados
- **Observabilidade:** Endpoints de saúde e métricas configurados.
- **Rastreabilidade:** Logs estruturados para facilitar o suporte e identificação de bugs.
- **Documentação de Suporte:** Arquivo `TROUBLESHOOTING.md` incluso para guiar a resolução de incidentes.

## Como rodar
1. `./mvnw clean install`
2. `./mvnw spring-boot:run`
3. Teste a saúde em: `http://localhost:8080/actuator/health`
