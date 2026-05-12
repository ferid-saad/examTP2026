# ExamTP2026 — Projet Microservices Boutique

## Architecture
- **produits-service** (port 8091) — Gestion des produits et catégories
- **avis-service** (port 8092) — Gestion des avis clients
- **eureka-server** (port 8761) — Service Discovery
- **api-gateway** (port 8090) — Point d'entrée unique
- **mobile_app** — Application Flutter

## Prérequis
- Java 21+
- Maven 3.8+
- Docker & Docker Compose
- Flutter 3.xcd

## Lancement avec Docker
```bash
mvn clean package -DskipTests
docker-compose up --build
```

## Lancement sans Docker
1. Démarrer PostgreSQL et Redis
2. Lancer eureka-server
3. Lancer produits-service
4. Lancer avis-service
5. Lancer api-gateway

## URLs
| Service | URL |
|---|---|
| Eureka | http://localhost:8761 |
| Produits Swagger | http://localhost:8091/swagger-ui.html |
| Avis Swagger | http://localhost:8092/swagger-ui.html |
| API Gateway | http://localhost:8090 |