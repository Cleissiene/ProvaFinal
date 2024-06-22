```graph TD;
    subgraph UserOperations
        direction TB
        A1[Register] --> B1[Authenticate]
        B1 --> C1[Extract Role]
        style A1 fill:#ffccf2,stroke:#0033cc,stroke-width:2px;
        style B1 fill:#ff99e6,stroke:#0033cc,stroke-width:2px;
        style C1 fill:#ff66d9,stroke:#0033cc,stroke-width:2px;
    end

    subgraph AdminOperations
        direction TB
        D1[Delete User]
        style D1 fill:#ff99e6,stroke:#0033cc,stroke-width:2px;
    end

    subgraph ManagerOperations
        direction TB
        E1[Delete Product]
        style E1 fill:#ff66d9,stroke:#0033cc,stroke-width:2px;
    end

    subgraph SellerOperations
        direction TB
        F1[Create Product]
        style F1 fill:#ffccf2,stroke:#0033cc,stroke-width:2px;
    end

    subgraph CustomerOperations
        direction TB
        G1[View Product]
        style G1 fill:#ff99e6,stroke:#0033cc,stroke-width:2px;
    end

    A[Auth API] -->|Reg/Login| UserOperations
    style A fill:#ffccf2,stroke:#0033cc,stroke-width:2px;
    UserOperations -->|JWT Token| H[JWT Service]
    style H fill:#ff66d9,stroke:#0033cc,stroke-width:2px;
    H -->|Auth| AdminOperations
    H -->|Auth| ManagerOperations
    H -->|Auth| SellerOperations
    H -->|Auth| CustomerOperations
    UserOperations -->|Data Access| I[Database]
    style I fill:#ff99e6,stroke:#0033cc,stroke-width:2px;
    AdminOperations -->|Data Access| I
    ManagerOperations -->|Data Access| I
    SellerOperations -->|Data Access| I
    CustomerOperations -->|Data Access| I
```

