
# ⚡ Redis RnD App

This is a simple Spring Boot project to **learn how to use Redis for caching and fast data access**. It uses **Spring Data Redis** to interact with a local Redis server. The project supports saving, retrieving, and deleting book and country information.

---

## 🧠 What is Redis?

**Redis** is an open-source, in-memory NoSQL data store used as a **database**, **cache**, and **message broker**. It’s extremely fast and supports data structures like strings, hashes, lists, and sets.

In this app, Redis is used to:

* Store book and country data
* Enable quick reads/writes
* Apply TTL (time-to-live) for expirable data

---

## ✅ What This Project Does

This app provides REST APIs to:

| Endpoint          | Method | Description                    |
| ----------------- | ------ | ------------------------------ |
| `/save/book`      | POST   | Save book info to Redis        |
| `/get/book`       | GET    | Get book info from Redis       |
| `/delete/book`    | DELETE | Delete book info from Redis    |
| `/save/country`   | POST   | Save country info to Redis     |
| `/get/country`    | GET    | Get country info from Redis    |
| `/delete/country` | DELETE | Delete country info from Redis |

---

## ⚙️ How to Run

### 1. Clone the project

```bash
git clone https://github.com/your-username/redis-rnd-app.git
cd redis-rnd
```

### 2. Start Redis + Redis Commander using Docker

Use this `docker-compose.yml`:

```yaml
version: '3.8'

services:
  redis:
    image: redis:latest
    container_name: redis
    ports:
      - "6379:6379"
    volumes:
      - redis-data:/data
    networks:
      - backend

  redis-commander:
    image: rediscommander/redis-commander:latest
    container_name: redis-commander
    depends_on:
      - redis
    environment:
      - REDIS_HOSTS=local:redis:6379
    ports:
      - "8030:8081"
    networks:
      - backend

volumes:
  redis-data:

networks:
  backend:
```

Then run:

```bash
docker-compose up -d
```

### 3. Configure your `application.yml`

```yaml
spring:
  redis:
    host: localhost
    port: 6379
```

### 4. Start Spring Boot App

```bash
./gradlew bootRun
```

---

## 🛠 Example cURL Commands

### Save a Country:

```bash
curl --location 'http://localhost:8099/save/country' \
--header 'Content-Type: application/json' \
--data '{
 "hashKey": "country",
 "dataKey":"Germany",
 "ttlSeconds": 4000,
  "countryInfo": {
    "capital": "berlin",
    "currency": "euro"
  }
}'
```

### Get a Country:

```bash
curl --location --request GET 'http://localhost:8099/get/country' \
--header 'Content-Type: application/json' \
--data '{
    "hashKey" : "country",
    "dataKey": "Germany"

}'
```

### Delete a Country:

```bash
curl --location --request DELETE 'http://localhost:8099/delete/country' \
--header 'Content-Type: application/json' \
--data '{
    "hashKey" : "country",
    "dataKey": "Germany"
}'
```

### Save a Book:

```bash
curl --location 'http://localhost:8099/save/book' \
--header 'Content-Type: application/json' \
--data '{
 "hashKey": "library",
 "dataKey":"biology",
 "ttlSeconds": 4000,
  "bookInfo": {
    "type": "botany",
    "level": "university",
    "rating": 4
  }
}'
```

### Get a Book:

```bash
curl --location --request GET 'http://localhost:8099/get/book' \
--header 'Content-Type: application/json' \
--data '{
    "hashKey" : "library",
    "dataKey": "math"

}'
```

### Delete a Book:

```bash
curl --location --request DELETE 'http://localhost:8099/delete/book' \
--header 'Content-Type: application/json' \
--data '{
    "hashKey" : "library",
    "dataKey": "geography"
}'
```
---

## 📝 Notes

* Redis stores data in **key-value pairs**, with `hashKey` acting as the Redis key and `dataKey` as the field within a Redis hash.
* TTL (time-to-live) is supported for setting expiration times.
* Redis Commander is available at [http://localhost:8030](http://localhost:8030) for easy browsing.
* This project uses `Spring Boot`, `Spring Data Redis`, and `Lombok`.
