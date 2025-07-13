\# 🍽️ Microservices-based Food Ordering System



A distributed microservices architecture for a food ordering platform built using Spring Boot, Spring Cloud, Spring Security, JWT, and other modern Java technologies.



\## 🔧 Tech Stack



\- \*\*Spring Boot\*\* (REST APIs, business logic)

\- \*\*Spring Security\*\* \& \*\*JWT\*\* (user authentication \& authorization)

\- \*\*Spring Cloud Gateway\*\* (API gateway)

\- \*\*Eureka Server\*\* (service discovery)

\- \*\*Spring Data JPA\*\* (data persistence)

\- \*\*Feign Client\*\* (inter-service communication)

\- \*\*Postgres\*\* (database)

\- \*\*Maven\*\* (build tool)



---



\## 🧱 Microservices



| Service      | Description |

|--------------|-------------|

| `User-Service` | Handles user registration, authentication, and role-based access (uses JWT \& Spring Security). |

| `Menu-Service` | Manages menu items and allows fetching by name, category, etc. |

| `Order-Service` | Handles order creation, status tracking, and interacts with User/Menu/Delivery. |

| `Restaurant-Service` | Manages restaurant info, registration, and association with menus. |

| `Delivery-Service` | Manages delivery assignment and status updates. |

| `API Gateway` | Routes and filters requests to appropriate services securely. |

| `Eureka Server` | Registers and discovers all running microservices. |



---



\## 🔐 Security



\- JWT Token-based Authentication

\- Spring Security with Role-based Access Control (e.g., `ROLE\_CUSTOMER`, `ROLE\_ADMIN`)

\- Authentication is handled via API Gateway and validated at each service



---



\## 🔄 Inter-Service Communication



All services communicate via \*\*Feign clients\*\*, enabling declarative REST calls. Example:

```java

@FeignClient(name = "MenuService")

public interface MenuInterface {

&nbsp;   @GetMapping("/name/{name}")

&nbsp;   Menu getMenuByName(@PathVariable String name);

}



