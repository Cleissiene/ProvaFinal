```mermaid
graph TD;
    subgraph User_Operations
        A1[Registra Usuário] --> B1[Autentica Usuário]
        B1 --> C1[Extrai Papel de Usuário]
        style A1 fill:#f9f,stroke:#333,stroke-width:2px;
        style B1 fill:#9f9,stroke:#333,stroke-width:2px;
        style C1 fill:#ff9,stroke:#333,stroke-width:2px;
    end

    subgraph Admin_Operations
        D1[Exclui Usuário]
        style D1 fill:#f96,stroke:#333,stroke-width:2px;
    end

    subgraph Manager_Operations
        E1[Exclui Produto]
        style E1 fill:#69f,stroke:#333,stroke-width:2px;
    end

    subgraph Seller_Operations
        F1[Cria Produto]
        style F1 fill:#96f,stroke:#333,stroke-width:2px;
    end

    subgraph Customer_Operations
        G1[Visualiza Produto]
        style G1 fill:#6f9,stroke:#333,stroke-width:2px;
    end

    A[API de Autenticação] -->|Registra/Login| User_Operations
    style A fill:#ffa,stroke:#333,stroke-width:2px;
    User_Operations -->|Token JWT| H[JWT Service]
    style H fill:#aaf,stroke:#333,stroke-width:2px;
    H -->|Autorização| Admin_Operations
    H -->|Autorização| Manager_Operations
    H -->|Autorização| Seller_Operations
    H -->|Autorização| Customer_Operations
    User_Operations -->|Acesso a Dados| I[MongoDB]
    style I fill:#fa9,stroke:#333,stroke-width:2px;
    Admin_Operations -->|Acesso a Dados| I
    Manager_Operations -->|Acesso a Dados| I
    Seller_Operations -->|Acesso a Dados| I
    Customer_Operations -->|Acesso a Dados| I```
