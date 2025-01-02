# 🚴‍♂️ API REST - Cycling Database

## 🎯 Project Objective

The **API REST - Cycling Database** is a Spring Boot application that manages data related to cyclists, teams, and stages in a cycling competition. It provides a RESTful interface for interacting with the database, allowing operations such as creating, reading, updating, and deleting records. This project is designed to simplify the management of cycling-related data and enable efficient data manipulation.

---

## 🛠️ Technologies Used

- **Backend Framework:** Spring Boot
- **Database:** PostgreSQL (running in a Docker container)  
- **Build Tool:** Maven  
- **Testing Tools:** Postman, REST Client  
- **Development Tools:** IntelliJ IDEA, Eclipse, Visual Studio Code  

---

## 📂 Endpoints

### Cyclists

#### **Get a list of cyclists**
```http
GET http://localhost:8090/api/v1/ciclistas
```
#### **Get cyclists sorted in descending order**
```http
GET http://localhost:8090/api/v1/ciclistas/orden/desc
```
#### **Get cyclist by ID**
```http
GET http://localhost:8090/api/v1/ciclistas/{id}/info
```
#### **Get cyclists by name (descending order)**
```http
GET http://localhost:8090/api/v1/ciclistas/nombre/{nombre}/orden/desc
```
#### **Create a new cyclist**
```http
POST http://localhost:8090/api/v1/ciclistas
Content-Type: application/json

{
  "nombre": "Joan Benavent",
  "nacion": "España",
  "fechaNacimiento": "1995-07-20"
}
```
#### **Update an existing cyclist**
```http
PUT http://localhost:8090/api/v1/ciclistas/{id}
Content-Type: application/json

{
  "nombre": "Alejandro Valverde",
  "nacion": "España",
  "fechaNacimiento": "1980-04-25"
}
```
#### **Get cyclists by name (descending order)**
```http
GET http://localhost:8090/api/v1/ciclistas/nombre/{nombre}/orden/desc
```
#### **Delete a cyclist by ID**
```http
DELETE http://localhost:8090/api/v1/ciclistas/{id}
```
(Replace {id} and {nombre} with the appropriate values.)

## 🚀 How to Run

Follow these steps to clone, set up, and run the project locally:

1. **Clone the repository**  
   ```bash
   git clone https://github.com/bena-sudo/api_rest_bd_ciclismo.git
   cd api_rest_bd_ciclismo
   ```
2. **Run PostgreSQL in a Docker container**
   Ensure Docker is installed and running. Use the following command to start a PostgreSQL container:
   ```bash
   docker run --name postgres-cycling-db -e POSTGRES_USER=ciclismo -e POSTGRES_PASSWORD=ciclismoSimarro -e POSTGRES_DB=ciclismo -p 5433:5432 -d postgres
   ```
3. **Configure the database connection**
   The `application.properties` file is already configured to connect to PostgreSQL. Here are the key settings:
   ```bash
   spring.datasource.url=jdbc:postgresql://localhost:5433/ciclismo
   spring.datasource.username=ciclismo
   spring.datasource.password=ciclismoSimarro
   spring.jpa.hibernate.ddl-auto=update
   ```
4. **Build the project**
   Ensure you have Maven installed, then run:
   ```bash
   mvn clean install
   ```
5. **Run the application**
   Use the following command to start the application:
   ```bash
   mvn spring-boot:run
   ```
   The API will be accessible at:
   ```bash
   http://localhost:8090
   ```
   
