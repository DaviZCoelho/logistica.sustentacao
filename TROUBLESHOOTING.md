# Guia de Troubleshooting - API de Logística

Este documento descreve como identificar e resolver problemas técnicos no projeto.

## 1. Verificação de Status (Health Check)
A API utiliza o Spring Actuator para expor o estado do sistema. 
- **Endpoint:** `http://localhost:8080/actuator/health`
- **O que verificar:** O campo `status` deve ser `UP`. Se o banco de dados H2 falhar, o status mudará para `DOWN`.

## 2. Diagnóstico por Logs
Em caso de erro (como o Status 500), a investigação deve ser feita pelo console/terminal:
- **Simulação de Erro:** Acesse `http://localhost:8080/pedidos/testar-erro`.
- **Análise:** Verifique no terminal a mensagem `ERROR: ALERTA: Tentativa de processamento falhou`. Isso indica que a exceção foi capturada corretamente pelo sistema de logs.

## 3. Problemas Comuns e Soluções
- **Erro de Compilação (Package):** Comum ao renomear pastas. Certifique-se de que a primeira linha de todos os arquivos `.java` seja: `package com.meuprojeto.logistica.sustentacao;`.
- **Porta 8080 em uso:** Se a aplicação não subir, encerre outros processos que utilizem a porta 8080 ou mude a porta em `src/main/resources/application.properties` usando `server.port=8081`.
- **Persistência de Dados:** Como o banco H2 é em memória, os dados são resetados a cada reinicialização da aplicação.
- **Cache de Build:** Se o código não atualizar, execute `./mvnw clean` no terminal.

## 4. Métricas Adicionais
Para monitorar o consumo de memória e performance da JVM:
- `http://localhost:8080/actuator/metrics`