
---

# 🏫 School Management System  
## 🚀 SMS Frontend – Docker Deployment Guide

---

## 🐳 Prerequisites

Make sure you have the following installed before running the app:

- [Docker Desktop](https://www.docker.com/get-started)
- [Apache Maven](https://maven.apache.org/download.cgi)
- (Optional) [Docker Compose](https://docs.docker.com/compose/)
- Internet connection to pull images

---

## 📦 How to Run the Application

Open the **parent directory** of this project in **CMD** or your preferred **terminal**.

---

## 🧰 Install Docker and Login

```bash
docker login
````

---

## 🧩 Option I: Run Manually

1. **Create a Fresh JAR File**
    
   ```bash
   mvn clean install
   ```

2. **Run using Docker Compose**
    #### create and run container
   ```bash
   docker-compose up
   ```

---

## ⚡ Option II: Run Using `run.bat`

Simply execute the provided **`run.bat`** file:

```bash
run.bat
```

This script will:

* Build a new **Maven project (JAR)**
* Deploy it inside a **Docker container**
* Launch **SQL Server** and **phpMyAdmin** containers for database visualization

---

## 🌐 Access the Application

Once the containers are running, open your browser and navigate to:

1. **👉 SMS Backend =>** [localhost:8081](http://localhost:8081)
2. **👉 Swagger =>** [swagger-ui](http://localhost:8081/swagger-ui/index.html)
3. **👉 SQL Server =>** [localhost:3306](http://localhost:3306)
4. **👉 phpmyadmin =>** [localhost:8082](http://localhost:8082)

---

## 🧹 Stop the Containers

To stop and remove all running containers:

```bash
docker-compose down
```

Or, if not using Docker Compose:

```bash
docker ps
docker stop <container_id>
```

---



CampusController
this is source of truth for you.
StandardController you need to update this base on the same pattren of logging/ error implementation/ coding style/ existance check/ jpql queries/ 