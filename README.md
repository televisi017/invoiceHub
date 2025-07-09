# InvoiceHub

**InvoiceHub** is a scalable, production-grade microservices-based backend system designed for managing user and invoice data, complete with distributed tracing, observability, event-driven communication, and fault tolerance.

## ✨ Tech Stack

- **Java 17**, **Spring Boot 3.x**
- **Spring Cloud Gateway**, **OpenFeign**, **Spring Security (Keycloak OAuth2)**
- **Kafka** (multi-broker setup)
- **Elasticsearch**, **Logstash**, **Kibana** (ELK stack)
- **Prometheus**, **Grafana**, **Micrometer**
- **MySQL 8**, **JPA**, **Flyway**
- **Docker**, **Docker Compose**
- **Elastic APM (Fleet Mode)**

---

## 🧩 Architecture Overview

- API Gateway (Reactive)
- User Service
- Invoice Service
- Product Service (Kafka-integrated)
- Centralized Logging via Logstash
- Distributed Tracing with APM and Trace IDs
- Metrics with Prometheus + Grafana

![image](https://github.com/user-attachments/assets/2618210f-aefc-4f48-9c8d-6c0b58209529)


---

## 🛠 Key Features

- ✅ OAuth2 Authentication & Authorization with Keycloak
- ✅ Reactive API Gateway with Spring Cloud Gateway
- ✅ OpenFeign Client with Retry + Timeout
- ✅ Kafka-based Event Communication (Gateway → Product Service)
- ✅ Circuit Breaker & Retry using Resilience4j
- ✅ Distributed Tracing using Micrometer + Trace IDs in logs
- ✅ Monitoring Dashboards (Grafana + Prometheus)
- ✅ Centralized JSON Logging via Logstash
- ✅ Flyway DB Migrations
- ✅ Dockerized Microservices with `docker-compose`
- ✅ Hardened Exception Handling
