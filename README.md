```graph TD;
    subgraph UserOperations
        direction TB
        A1[Register User] --> B1[Authenticate User]
        B1 --> C1[Extract User Role]
        style A1 fill:#ffccf2,stroke:#0033cc,stroke-width:2px;
        style B1 fill:#ccffcc,stroke:#0033cc,stroke-width:2px;
        style C1 fill:#ccff99,stroke:#0033cc,stroke-width:2px;
    end

    subgraph AdminOperations
        direction TB
        D1[Delete User]
        style D1 fill:#ff9999,stroke:#0033cc,stroke-width:2px;
    end

    subgraph ManagerOperations
        direction TB
        E1[Delete Product]
        style E1 fill:#99ccff,stroke:#0033cc,stroke-width:2px;
    end

    subgraph SellerOperations
        direction TB
        F1[Create Product]
        style F1 fill:#ccffcc,stroke:#0033cc,stroke-width:2px;
    end

    subgraph CustomerOperations
        direction TB
        G1[View Product]
        style G1 fill:#ccff99,stroke:#0033cc,stroke-width:2px;
    end

    A[Auth API] -->|Register/Login| UserOperations
    style A fill:#ffccf2,stroke:#0033cc,stroke-width:2px;
    UserOperations -->|JWT Token| H[JWT Service]
    style H fill:#99ccff,stroke:#0033cc,stroke-width:2px;
    H -->|Authorization| AdminOperations
    H -->|Authorization| ManagerOperations
    H -->|Authorization| SellerOperations
    H -->|Authorization| CustomerOperations
    UserOperations -->|Data Access| I[MongoDB]
    style I fill:#ccffcc,stroke:#0033cc,stroke-width:2px;
    AdminOperations -->|Data Access| I
    ManagerOperations -->|Data Access| I
    SellerOperations -->|Data Access| I
    CustomerOperations -->|Data Access| I```
