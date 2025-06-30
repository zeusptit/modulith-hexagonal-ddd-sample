# 🛠️ Spring Boot - Hexagonal Architecture with DDD

## 🧩 Tổng quan

Dự án này áp dụng mô hình **Hexagonal Architecture (Ports and Adapters)** kết hợp với **Domain-Driven Design (DDD)** nhằm tách biệt rõ ràng giữa:

- Logic nghiệp vụ (domain logic)
- Hạ tầng (infrastructure)
- Cổng vào (REST, events)
- Cổng ra (database, hệ thống ngoài)

Mô hình này giúp code dễ kiểm thử, dễ bảo trì và dễ mở rộng.

--- 
## Hexagonal Architecture

```
                [ External World ]
┌────────────┬──────────────┬────────────┐
│ REST API   │ CLI, Events  │ UI         │   ← Input Adapters
└────────────┴──────────────┴────────────┘
         ↓         ↓            ↓
      [ INPUT PORT / USE CASES ]        ← Xử lý yêu cầu
         ↓
    [ DOMAIN (Entities, Logic) ]        ← Nơi nghiệp vụ "sống"
         ↓
   [ OUTPUT PORT / INTERFACE ]          ← Định nghĩa hành vi cần từ bên ngoài
         ↓
┌────────────┬──────────────┬────────────┐
│ Database   │ Kafka, Email │ External   │   ← Output Adapters
└────────────┴──────────────┴────────────┘

```

## Domain-Driven Design (DDD)
DDD là phương pháp thiết kế phần mềm tập trung vào nghiệp vụ thực tế thông qua mô hình "domain model".

DDD gồm 3 lớp chính:

- Domain Layer – nơi định nghĩa Entity, ValueObject, DomainService

- Application Layer – nơi xử lý Use Case (như CreateOrder, RegisterUser)

- Infrastructure Layer – nơi implement chi tiết kỹ thuật (DB, REST, Kafka...)

---

---

## 🧱 Kiến trúc tổng quát

```
           [ External World ]
┌─────────────────────────────────────────────┐
│           REST / External Adapter           │
│                                             │
│   ┌─────────────────────────────────────┐   │
│   │          Application Layer          │   │   ← Cổng vào (Input Port)
│   │  - Use cases                        │   │
│   │  - Điều phối nghiệp vụ              │   │
│   └─────────────────────────────────────┘   │
│   ┌─────────────────────────────────────┐   │
│   │            Domain Layer             │   │
│   │  - Domain model                     │   │
│   │  - Domain services                  │   │   ← Cốt lõi nghiệp vụ
│   └─────────────────────────────────────┘   │
│   ┌─────────────────────────────────────┐   │
│   │       Infrastructure Adapter        │   │   ← Cổng ra (Output Port)
│   │  - JPA, Kafka, etc.                 │   │
│   └─────────────────────────────────────┘   │
└─────────────────────────────────────────────┘
```

---

## 📁 Cấu trúc thư mục

```
src/main/java/com/example/product
├── domain
│   ├── model         # Các entity, value object
│   ├── service       # Domain service (logic nghiệp vụ)
│   └── port
│       ├── input     # Use case interface (Input Port)
│       └── output    # Repository interface (Output Port)
│
├── application
│   └── service       # Implement use case (gọi domain, repo)
│
├── adapter
│   ├── rest          # REST Controller (input adapter)
│   └── jpa           # Repository JPA implement (output adapter)
│
└── infrastructure
    └── persistence   # JPA Entity, cấu hình DB
```

---

## 📦 Ví dụ Use Case: Tạo sản phẩm

1. `ProductController` nhận HTTP POST → gọi `CreateProductUseCase`
2. `ProductService` implement use case → gọi `ProductRepository`
3. `ProductJpaAdapter` map sang `ProductEntity` và lưu DB
4. Kết quả được trả ngược lên controller

---

## ✅ Lợi ích mô hình

- 🎯 Tách biệt **logic nghiệp vụ** khỏi công nghệ cụ thể
- 🔁 Dễ dàng **thay thế adapter** (REST → gRPC, JPA → Mongo...)
- 🧪 Thuận tiện **unit test domain** mà không cần đến Spring context
- 💡 Hướng theo **DDD** giúp thiết kế rõ ràng theo nghiệp vụ

---
