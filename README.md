# ROLE WITH PERMISSION THROUGH SPRING SECURITY IN SPRING BOOT

### 📖 Information

<ul style="list-style-type:disc">
  <li><b>This</b> is a Spring Boot example covering important and useful features.</li>
  <li>Here is an explanation of the example:</li>
       <ul>
         <li><b>Admin</b> and <b>User</b> implement their own <b>authentication</b> and <b>authorization</b> through their defined <b>role</b> names.</li>
         <li>The <b>Admin</b> handles with the following process shown above:
            <ul>
              <li><b>Admin</b> with <b>Role</b> containing <b>create</b> permission only handles with creating product</li>
              <li><b>Admin</b> with <b>Role</b> containing <b>get</b> permission only handles with getting product by id</li>
              <li><b>Admin</b> with <b>Role</b> containing <b>update</b> permission only handles with updating product by id</li>
              <li><b>Admin</b> with <b>Role</b> containing <b>delete</b> permission only handles with deleting product by id</li>
            </ul>
         </li>
         <li>The <b>User</b> handles with the following process shown above:
            <ul>
              <li><b>User</b> with <b>Role</b> containing <b>get</b> permission only handles with getting product by id</li>
            </ul>
         </li>
  </ul>
</ul>

### Database

[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-336791?logo=postgresql&logoColor=white&style=for-the-badge)](https://www.postgresql.org/download/)

<details>
  <summary>Show SQL Script</summary>

```sql
-- Insert roles
INSERT INTO ROLES (ID, NAME, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY)
VALUES (gen_random_uuid(), 'ADMIN', NOW(), 'system', NOW(), 'system');

INSERT INTO ROLES (ID, NAME, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY)
VALUES (gen_random_uuid(), 'USER', NOW(), 'system', NOW(), 'system');

-- Insert permissions
INSERT INTO PERMISSIONS (ID, NAME, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY)
VALUES (gen_random_uuid(), 'admin:create', NOW(), 'system', NOW(), 'system');

INSERT INTO PERMISSIONS (ID, NAME, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY)
VALUES (gen_random_uuid(), 'admin:get', NOW(), 'system', NOW(), 'system');

INSERT INTO PERMISSIONS (ID, NAME, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY)
VALUES (gen_random_uuid(), 'admin:update', NOW(), 'system', NOW(), 'system');

INSERT INTO PERMISSIONS (ID, NAME, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY)
VALUES (gen_random_uuid(), 'admin:delete', NOW(), 'system', NOW(), 'system');

INSERT INTO PERMISSIONS (ID, NAME, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY)
VALUES (gen_random_uuid(), 'user:get', NOW(), 'system', NOW(), 'system');

-- Insert role-permission relations
INSERT INTO ROLE_PERMISSION_RELATION_TABLE (ROLE_ID, PERMISSION_ID)
SELECT r.ID, p.ID FROM ROLES r, PERMISSIONS p
WHERE r.NAME = 'ADMIN' AND p.NAME = 'admin:create';

INSERT INTO ROLE_PERMISSION_RELATION_TABLE (ROLE_ID, PERMISSION_ID)
SELECT r.ID, p.ID FROM ROLES r, PERMISSIONS p
WHERE r.NAME = 'ADMIN' AND p.NAME = 'admin:get';

INSERT INTO ROLE_PERMISSION_RELATION_TABLE (ROLE_ID, PERMISSION_ID)
SELECT r.ID, p.ID FROM ROLES r, PERMISSIONS p
WHERE r.NAME = 'ADMIN' AND p.NAME = 'admin:update';

INSERT INTO ROLE_PERMISSION_RELATION_TABLE (ROLE_ID, PERMISSION_ID)
SELECT r.ID, p.ID FROM ROLES r, PERMISSIONS p
WHERE r.NAME = 'ADMIN' AND p.NAME = 'admin:delete';

INSERT INTO ROLE_PERMISSION_RELATION_TABLE (ROLE_ID, PERMISSION_ID)
SELECT r.ID, p.ID FROM ROLES r, PERMISSIONS p
WHERE r.NAME = 'USER' AND p.NAME = 'user:get';
```
</details>

[![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white&style=for-the-badge)](https://dev.mysql.com/downloads/)

<details>
  <summary>Show SQL Script</summary>

```sql
-- Insert roles
INSERT INTO ROLES (ID, NAME, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY)
VALUES (UUID(), 'ADMIN', NOW(), 'system', NOW(), 'system');

INSERT INTO ROLES (ID, NAME, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY)
VALUES (UUID(), 'USER', NOW(), 'system', NOW(), 'system');

-- Insert permissions
INSERT INTO PERMISSIONS (ID, NAME, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY)
VALUES (UUID(), 'admin:create', NOW(), 'system', NOW(), 'system');

INSERT INTO PERMISSIONS (ID, NAME, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY)
VALUES (UUID(), 'admin:get', NOW(), 'system', NOW(), 'system');

INSERT INTO PERMISSIONS (ID, NAME, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY)
VALUES (UUID(), 'admin:update', NOW(), 'system', NOW(), 'system');

INSERT INTO PERMISSIONS (ID, NAME, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY)
VALUES (UUID(), 'admin:delete', NOW(), 'system', NOW(), 'system');

INSERT INTO PERMISSIONS (ID, NAME, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY)
VALUES (UUID(), 'user:get', NOW(), 'system', NOW(), 'system');

-- Insert role-permission relations
INSERT INTO ROLE_PERMISSION_RELATION_TABLE (ROLE_ID, PERMISSION_ID)
SELECT r.ID, p.ID FROM ROLES r, PERMISSIONS p
WHERE r.NAME = 'ADMIN' AND p.NAME = 'admin:create';

INSERT INTO ROLE_PERMISSION_RELATION_TABLE (ROLE_ID, PERMISSION_ID)
SELECT r.ID, p.ID FROM ROLES r, PERMISSIONS p
WHERE r.NAME = 'ADMIN' AND p.NAME = 'admin:get';

INSERT INTO ROLE_PERMISSION_RELATION_TABLE (ROLE_ID, PERMISSION_ID)
SELECT r.ID, p.ID FROM ROLES r, PERMISSIONS p
WHERE r.NAME = 'ADMIN' AND p.NAME = 'admin:update';

INSERT INTO ROLE_PERMISSION_RELATION_TABLE (ROLE_ID, PERMISSION_ID)
SELECT r.ID, p.ID FROM ROLES r, PERMISSIONS p
WHERE r.NAME = 'ADMIN' AND p.NAME = 'admin:delete';

INSERT INTO ROLE_PERMISSION_RELATION_TABLE (ROLE_ID, PERMISSION_ID)
SELECT r.ID, p.ID FROM ROLES r, PERMISSIONS p
WHERE r.NAME = 'USER' AND p.NAME = 'user:get';
```
</details>

### Explore Rest APIs

<table style="width:100%">
  <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Description</th>
      <th>Request Body</th>
      <th>Header</th>
      <th>Valid Path Variable</th>
      <th>No Path Variable</th>
  </tr>
  <tr>
      <td>POST</td>
      <td>/api/v1/authentication/user/register</td>
      <td>User Register</td>
      <td>RegisterRequest</td>
      <td></td>
      <td></td>
      <td></td>
  <tr>
  <tr>
      <td>POST</td>
      <td>/api/v1/authentication/user/login</td>
      <td>User Login</td>
      <td>LoginRequest</td>
      <td></td>
      <td></td>
      <td></td>
  <tr>
  <tr>
      <td>POST</td>
      <td>/api/v1/authentication/user/refresh-token</td>
      <td>User Refresh Token</td>
      <td>TokenRefreshRequest</td>
      <td></td>
      <td></td>
      <td></td>
  <tr>
  <tr>
      <td>POST</td>
      <td>/api/v1/authentication/user/logout</td>
      <td>User Logout</td>
      <td>TokenInvalidateRequest</td>
      <td></td>
      <td></td>
      <td></td>
  <tr>
  <tr>
      <td>POST</td>
      <td>/api/v1/products</td>
      <td>Create Product</td>
      <td>ProductCreateRequest</td>
      <td></td>
      <td></td>
      <td></td>
  <tr>
  <tr>
      <td>GET</td>
      <td>/api/v1/products/{productId}</td>
      <td>Get Product By Id</td>
      <td></td>
      <td></td>
      <td>ProductId</td>
      <td></td>
  <tr>
  <tr>
      <td>GET</td>
      <td>/api/v1/products</td>
      <td>Get Products</td>
      <td>ProductPagingRequest</td>
      <td></td>
      <td></td>
      <td></td>
  <tr>
  <tr>
      <td>PUT</td>
      <td>/api/v1/products/{productId}</td>
      <td>Update Product By Id</td>
      <td>ProductUpdateRequest</td>
      <td></td>
      <td>ProductId</td>
      <td></td>
  <tr>
  <tr>
      <td>DELETE</td>
      <td>/api/v1/products/{productId}</td>
      <td>Delete Product By Id</td>
      <td></td>
      <td></td>
      <td>ProductId</td>
      <td></td>
  <tr>
</table>


### Technologies

---
- Java 21
- Spring Boot 3.0
- Restful API
- Lombok
- Maven
- Junit5
- Mockito
- TestContainer
- Integration Tests
- Docker
- Docker Compose
- CI/CD (Github Actions)
- Postman
- Spring Boot Open Api


### Postman

```
Import postman collection under postman_collection folder
```

### Open Api

```
http://localhost:9991/swagger-ui/index.html
```

### Prerequisites

---
- Maven or Docker
---


### Docker Run
The application can be built and run by the `Docker` engine. The `Dockerfile` has multistage build, so you do not need to build and run separately.

Please follow directions shown below in order to build and run the application with Docker Compose file;

```sh
$ cd rolepermissionexample
$ docker-compose up -d
```

If you change anything in the project and run it on Docker, you can also use this command shown below

```sh
$ cd rolepermissionexample
$ docker-compose up --build
```

---
### Maven Run
To build and run the application with `Maven`, please follow the directions shown below;

```sh
$ cd rolepermissionexample
$ mvn clean install
$ mvn spring-boot:run
```

### Screenshots

<summary>> Here is show some the screenshots of project</summary>
    <p> http://localhost:9991/swagger-ui/index.html </p>
    <img src ="screenshots/swagger.png">
    <p> register with role and permissions </p>
    <img src ="screenshots/register.png">
    <p> Login </p>
    <img src ="screenshots/login.png">
    <p> Get All Products </p>
    <img src ="screenshots/get-products.png">

## 📞 Get Support

For inquiries, feel free to reach out through the following channels:

[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:roemreaksmey7@gmail.com)  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/roem-reaksmey-163421280/)  
[![Telegram](https://img.shields.io/badge/Telegram-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white)](https://t.me/Smey_Advance)  
[![Portfolio](https://img.shields.io/badge/Portfolio-000000?style=for-the-badge&logo=vercel&logoColor=white)](https://my-portfolio-gold-mu-11.vercel.app/)

🚀 Let me know if you need further modifications!
