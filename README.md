# Prova Final - Aplicação Spring Boot

## Descrição do Projeto:
Implementação de um sistema de autenticação e autorização de usuários utilizando Spring Boot e JWT (JSON Web Token). O sistema permite o registro, login e controle de acesso baseado em funções de usuário, como ADMIN, GERENTE (encarregada), VENDEDOR e CLIENTE.

## Funcionalidades:

### Parte 1: Autenticação de usuários 
- **Registro de Usuário:** Permite que novos usuários se registrem com nome de usuário, senha e e-mail. Cada usuário é identificado com uma das seguintes funções: administrador, gerente de produtos, vendedor ou cliente.
- **Login Seguro:** Permite que os usuários se autentiquem utilizando suas credenciais (nome de usuário e senha). As credenciais são verificadas em relação aos dados armazenados no banco de dados.
- **Geração de Token JWT:** Após um login bem-sucedido, um token JWT é gerado, contendo informações como ID do usuário, tipo de conta e e-mail.

### Parte 2: Controle de Acesso com JWT 
- **Endpoints Baseados em Funções:** Implementa endpoints que permitem o acesso baseado nas funções dos usuários, garantindo que apenas usuários autorizados possam acessar determinados recursos.
  - **Administradores:** Endpoint para gerenciamento de usuários (criação, atualização e exclusão). Exemplo: `POST /admin/users`
  - **Gerentes de Produtos:** Endpoint para gerenciamento de produtos e categorias. Exemplo: `POST /manager/products`
  - **Vendedores:** Endpoint para gerenciamento de pedidos e devoluções. Exemplo: `POST /seller/orders`
  - **Clientes:** Endpoint para acesso ao catálogo de produtos e histórico de pedidos. Exemplo: `GET /customer/products`

## Estrutura do Projeto
- **Pacote com.example.ProvaFinal.application**
  - `ProvaFinalApplication.java`: Classe principal que inicia a aplicação Spring Boot.
- **Pacote com.example.ProvaFinal.config**
  - `SecurityConfig.java`: Configurações de segurança para a aplicação, definindo as regras de autorização e os usuários em memória com suas respectivas funções.
- **Pacote com.example.ProvaFinal.controller**
  - `UsuarioController.java`: Controlador responsável pelas operações de login, extração de nome de usuário a partir do token JWT e verificação de funções específicas dos usuários.
- **Pacote com.example.ProvaFinal.model**
  - `UsuarioEntity.java`: Classe que representa a entidade de usuário com atributos como id, nome, email e senha.
- **Pacote com.example.ProvaFinal.security**
  - `JwtUtil.java`: Classe utilitária para geração e extração de informações de tokens JWT.
- **Pacote com.example.ProvaFinal.service**
  - `UsuarioService.java`: Serviço responsável por gerar tokens JWT e extrair nomes de usuário a partir dos tokens.

## Print do funcionamento do sistema:

![img1](https://github.com/Cleissiene/ProvaFinal/assets/125709420/69139ef6-18b1-46d8-a70e-f64f8e22811d)
![img2](https://github.com/Cleissiene/ProvaFinal/assets/125709420/e3b540f5-4de1-4e31-b6c1-674a25081be9)
![img3](https://github.com/Cleissiene/ProvaFinal/assets/125709420/8746f5cb-525b-45e2-b825-9f1032bccfce)
![img4](https://github.com/Cleissiene/ProvaFinal/assets/125709420/96092095-19f4-4f6a-ace8-351f7e976a16)

## Abaixo segue diagrama da aplicação:

```mermaid
graph TD;
    subgraph User_Operations
        A1[Registra Usuário] --> B1[Autentica Usuário]
        B1 --> C1[Extrai Papel de Usuário]
        style A1 fill:#ffe6f2,stroke:#fff,stroke-width:2px;
        style B1 fill:#fff,stroke:#fff,stroke-width:2px;
        style C1 fill:#fff,stroke:#fff,stroke-width:2px;
    end

    subgraph Admin_Operations
        D1[Exclui Usuário]
        style D1 fill:#fff,stroke:#fff,stroke-width:2px;
    end

    subgraph Manager_Operations
        E1[Exclui Produto]
        style E1 fill:#fff,stroke:#fff,stroke-width:2px;
    end

    subgraph Seller_Operations
        F1[Cria Produto]
        style F1 fill:#fff,stroke:#fff,stroke-width:2px;
    end

    subgraph Customer_Operations
        G1[Visualiza Produto]
        style G1 fill:#fff,stroke:#fff,stroke-width:2px;
    end

    A[API de Autenticação] -->|Registra/Login| User_Operations
    style A fill:#ffe6f2,stroke:#fff,stroke-width:2px;
    User_Operations -->|Token JWT| H[JWT Service]
    style H fill:#fff,stroke:#fff,stroke-width:2px;
    H -->|Autorização| Admin_Operations
    H -->|Autorização| Manager_Operations
    H -->|Autorização| Seller_Operations
    H -->|Autorização| Customer_Operations
    User_Operations -->|Acesso a Dados| I[MongoDB]
    style I fill:#fff,stroke:#fff,stroke-width:2px;
    Admin_Operations -->|Acesso a Dados| I
    Manager_Operations -->|Acesso a Dados| I
    Seller_Operations -->|Acesso a Dados| I
    Customer_Operations -->|Acesso a Dados| I
```

