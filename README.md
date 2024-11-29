# Backend Template Generator

Questo progetto fornisce un template backend configurabile, costruito con **Spring Boot** e generato dinamicamente utilizzando **Nunjucks**. È progettato per essere integrato con **Backstage**, consentendo agli utenti di creare backend personalizzati in base alle loro esigenze.

## Caratteristiche principali

- Supporto per **MongoDB**, **PostgreSQL**, e **Lombok** configurabile tramite flag.
- Generazione automatica di classi modello, file di configurazione e dipendenze basate sulle selezioni dell'utente.
- Supporto per **Keycloak** per l'autenticazione OAuth2.
- Integrazione con **Swagger** per la documentazione API.
- Compatibilità con Java 17 e Spring Boot 3.3.4.

## Configurazione iniziale

### Prerequisiti

- **Java 17**
- **Maven 3.8+**
- Backstage installato e configurato.

### Generazione del backend

1. Assicurati che il tuo sistema supporti Backstage e che il plugin Nunjucks sia configurato correttamente.
2. Configura i flag desiderati nel file `.nunjucks` per personalizzare il tuo backend:
   - `mongodb`: Abilita il supporto per MongoDB.
   - `postgresql`: Abilita il supporto per PostgreSQL.
   - `lombok`: Abilita il supporto per Lombok.
   - `keycloak`: Aggiungi il supporto per Keycloak.

### Esempio di configurazione

Per un backend con supporto MongoDB e Lombok, utilizza il seguente JSON di configurazione:

```json
{
  "mongodb": true,
  "postgresql": false,
  "lombok": true,
  "keycloak": false
}
```

### Configurazione `application.yaml`

Il file `application.yaml` viene generato dinamicamente in base ai flag configurati. Di seguito sono riportati alcuni esempi di configurazione:

#### Configurazione MongoDB

```yaml
spring:
  data:
    mongodb:
      authentication-database: admin
      username: rootuser
      password: rootpass
      database: my_database
      port: 27017
      host: localhost
```

#### Configurazione PostgreSQL

```yaml
spring:
  datasource:
    properties:
      username: rootuser
      password: rootpass
      database: my_database
      port: 5432
      host: localhost
    driver-class-name: org.postgresql.Driver
  jpa:
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: update
    show-sql: true
    generate-ddl: true
    database-platform: org.hibernate.dialect.PostgreSQLDialect
  profiles:
    active: dev
```

#### Configurazione Keycloak

```yaml
keycloak:
  realm: your-realm-name
  resource: spring-boot
  auth-server-url: http://localhost:8080/realms/backend
  ssl-required: external
  credentials:
    secret: your-client-secret
  bearer-only: true
  security-constraints:
    - security-collections:
        - patterns:
            - /admin/*
          methods: GET
          auth-roles: admin
```

### Avvio del progetto

1. Genera il backend personalizzato.
2. Spostati nella directory del progetto.
3. Compila e avvia l'applicazione:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### Verifica dell'API

Dopo l'avvio, puoi accedere alla documentazione dell'API tramite Swagger:

- [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Struttura del progetto

- **`/src/main/java`**: Contiene il codice sorgente del backend.
- **`pom.xml`**: Configurazione di Maven con dipendenze opzionali basate sulla configurazione selezionata.

## Dipendenze opzionali

- **MongoDB**: Aggiunge il supporto per `spring-boot-starter-data-mongodb`.
- **PostgreSQL**: Aggiunge il supporto per `spring-boot-starter-data-jpa` e il driver PostgreSQL.
- **Lombok**: Abilita annotazioni come `@Data`, `@NoArgsConstructor`, e `@AllArgsConstructor` per generare automaticamente getter/setter.
- **Keycloak**: Aggiunge le dipendenze e configurazioni necessarie per l'integrazione OAuth2.

## Licenza

Questo progetto è rilasciato sotto la licenza MIT.
