```mermaid
graph TD;
    subgraph User_Operations
        A1[Registra Usuário] --> B1[Autentica Usuário]
        B1 --> C1[Extrai Papel de Usuário]
        style A1 fill:#ffccf2,stroke:#0033cc,stroke-width:2px,font-family:"Arial",font-size:14px;
        style B1 fill:#ccffcc,stroke:#0033cc,stroke-width:2px,font-family:"Arial",font-size:14px;
        style C1 fill:#ccff99,stroke:#0033cc,stroke-width:2px,font-family:"Arial",font-size:14px;
    end

    subgraph Admin_Operations
        D1[Exclui Usuário]
        style D1 fill:#ff9999,stroke:#0033cc,stroke-width:2px,font-family:"Arial",font-size:14px;
    end

    subgraph Manager_Operations
        E1[Exclui Produto]
        style E1 fill:#99ccff,stroke:#0033cc,stroke-width:2px,font-family:"Arial",font-size:14px;
    end

    subgraph Seller_Operations
        F1[Cria Produto]
        style F1 fill:#ccffcc,stroke:#0033cc,stroke-width:2px,font-family:"Arial",font-size:14px;
    end

    subgraph Customer_Operations
        G1[Visualiza Produto]
        style G1 fill:#ccff99,stroke:#0033cc,stroke-width:2px,font-family:"Arial",font-size:14px;
    end

    A[API de Autenticação] -->|Registra/Login| User_Operations
    style A fill:#ffccf2,stroke:#0033cc,stroke-width:2px,font-family:"Arial",font-size:14px;
    User_Operations -->|Token JWT| H[JWT Service]
    style H fill:#99ccff,stroke:#0033cc,stroke-width:2px,font-family:"Arial",font-size:14px;
    H -->|Autorização| Admin_Operations
    H -->|Autorização| Manager_Operations
    H -->|Autorização| Seller_Operations
    H -->|Autorização| Customer_Operations
    User_Operations -->|Acesso a Dados| I[MongoDB]
    style I fill:#ccffcc,stroke:#0033cc,stroke-width:2px,font-family:"Arial",font-size:14px;
    Admin_Operations -->|Acesso a Dados| I
    Manager_Operations -->|Acesso a Dados| I
    Seller_Operations -->|Acesso a Dados| I
    Customer_Operations -->|Acesso a Dados| I
```
