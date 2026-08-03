# Banking System — Project Plan

> Roadmap de aprendizado e evolução do Banking System.
> O projeto começa como uma aplicação Java via terminal e evolui de forma incremental.

## Visão do projeto

Construir um sistema bancário que permita gerenciar clientes, contas e transações, aplicando boas práticas de Java e Programação Orientada a Objetos.

O objetivo principal não é terminar rapidamente: cada etapa deve consolidar um conceito antes de introduzir novas tecnologias.

## Princípios de desenvolvimento

- Começar simples e evoluir somente quando houver necessidade;
- Manter o código em inglês e a documentação em português;
- Proteger regras de negócio dentro das classes do domínio;
- Priorizar objetos válidos e responsabilidades bem definidas;
- Fazer commits pequenos, descritivos e com uma única intenção;
- Usar Pull Requests como registro das mudanças relevantes;
- Criar testes gradualmente, junto com as regras de negócio.

## Arquitetura alvo

O projeto será inicialmente um **monólito modular**: uma única aplicação Java, com packages bem organizados e responsabilidades separadas.

```text
Terminal/Menu
    ↓
Casos de uso e serviços
    ↓
Domínio bancário (Client, Account, Transaction)
    ↓
Persistência (memória → arquivo → banco de dados)
```

Com a evolução do projeto, essa organização poderá se aproximar da arquitetura hexagonal:

- `domain`: regras e entidades bancárias;
- `application`: casos de uso, como cadastrar cliente e transferir;
- `adapters/input`: terminal e, futuramente, API REST;
- `adapters/output`: arquivos e banco de dados.

Não é necessário criar todos esses packages agora. A separação será feita de forma gradual e somente quando ajudar na compreensão do código.

---

# Milestone 1 — Núcleo bancário via terminal

> Objetivo: criar uma aplicação funcional de terminal e consolidar os fundamentos de Java e POO.

## Domínio

- [ ] Finalizar `Client`;
  - [ ] Validar CPF com 11 dígitos, sequências repetidas e dígitos verificadores;
  - [ ] Definir quais dados podem ou não ser alterados após o cadastro;
- [ ] Modelar `Account`;
  - [ ] Número da conta, agência, saldo e titular;
  - [ ] Encapsular o saldo, sem `setBalance()` público;
  - [ ] Criar operações de depósito, saque, transferência e consulta de saldo;
- [ ] Criar `CheckingAccount` e `SavingsAccount`;
  - [ ] Praticar herança;
  - [ ] Definir comportamentos específicos de cada tipo de conta;
- [ ] Modelar `Transaction`;
  - [ ] Tipo, valor, data/hora e contas envolvidas.

## Regras de negócio

- [ ] Impedir depósitos, saques e transferências com valor menor ou igual a zero;
- [ ] Impedir saque ou transferência sem saldo suficiente;
- [ ] Criar `InsufficientFundsException` como exceção personalizada;
- [ ] Registrar as operações realizadas;
- [ ] Validar dados obrigatórios no cadastro.

## Aplicação de terminal

- [ ] Implementar `Bank` para gerenciar clientes e contas em memória;
- [ ] Implementar `Menu` com `Scanner`;
- [ ] Criar opções de cadastro, consulta, depósito, saque, transferência e extrato;
- [ ] Tratar exceções no menu e permitir que o usuário tente novamente;
- [ ] Iniciar a aplicação por `Main`.

## Qualidade inicial

- [ ] Usar nomes claros, métodos pequenos e responsabilidades bem definidas;
- [ ] Revisar `toString()`, construtores, getters e setters;
- [ ] Criar testes manuais para os fluxos principais;
- [ ] Adicionar os primeiros testes automatizados para regras críticas.

### Critério de conclusão

O usuário consegue cadastrar clientes e contas, executar operações bancárias pelo terminal, consultar saldo e histórico, e recebe mensagens claras para entradas inválidas.

---

# Milestone 2 — Persistência em arquivos e testes

> Objetivo: manter os dados entre execuções sem introduzir banco de dados ainda.

- [ ] Salvar clientes, contas e transações em arquivos;
- [ ] Carregar os dados automaticamente ao iniciar a aplicação;
- [ ] Definir um formato simples de armazenamento;
- [ ] Separar a lógica de persistência das regras bancárias;
- [ ] Expandir a cobertura de testes automatizados;
- [ ] Testar cenários de erro e bordas das regras de negócio.

### Critério de conclusão

Os dados criados em uma execução continuam disponíveis após fechar e iniciar o programa novamente.

---

# Milestone 3 — Banco de dados relacional

> Objetivo: migrar a persistência de arquivos para um banco de dados relacional.

- [ ] Escolher e configurar um banco de dados;
- [ ] Modelar tabelas para clientes, contas e transações;
- [ ] Criar a camada de acesso a dados;
- [ ] Implementar relacionamentos e consultas;
- [ ] Manter as regras de negócio independentes da tecnologia de armazenamento;
- [ ] Criar scripts ou instruções de configuração do banco.

---

# Milestone 4 — API REST

> Objetivo: disponibilizar o sistema para outros clientes além do terminal.

- [ ] Introduzir Spring Boot;
- [ ] Criar endpoints para clientes, contas e transações;
- [ ] Padronizar requisições e respostas;
- [ ] Converter exceções em respostas HTTP claras;
- [ ] Documentar a API;
- [ ] Manter o terminal como adaptador opcional ou substituí-lo gradualmente.

---

# Milestone 5 — Segurança

> Objetivo: introduzir autenticação, autorização e proteção de dados.

- [ ] Gerenciamento de usuários;
- [ ] Autenticação e autorização por perfil;
- [ ] Proteção de endpoints;
- [ ] Validação e tratamento seguro de dados;
- [ ] Estudar boas práticas relacionadas à LGPD.

---

# Milestone 6 — Produtos e serviços bancários

> Objetivo: expandir o domínio somente após o fluxo principal estar sólido.

- [ ] PIX e pagamentos;
- [ ] Cartões;
- [ ] Empréstimos;
- [ ] Investimentos;
- [ ] Produtos de conta, como conta PJ e conta conjunta.

---

# Milestone 7 — Qualidade e evolução arquitetural

> Objetivo: tornar a aplicação mais sustentável conforme ela cresce.

- [ ] Refatorar pontos que tenham se tornado complexos;
- [ ] Fortalecer a separação entre domínio, casos de uso e adaptadores;
- [ ] Aumentar testes unitários e de integração;
- [ ] Adicionar logs e centralizar configurações;
- [ ] Adicionar validações e documentação técnica.

---

# Milestone 8 — Infraestrutura e entrega

> Objetivo: preparar a aplicação para execução em ambientes externos.

- [ ] Containerização;
- [ ] Pipeline de CI/CD;
- [ ] Deploy;
- [ ] Monitoramento e observabilidade;
- [ ] Gerenciamento de configurações por ambiente.

---

# Milestone 9 — Arquitetura distribuída (opcional)

> Objetivo: estudar sistemas distribuídos somente se houver uma motivação de aprendizado concreta.

- [ ] Avaliar limites do monólito modular;
- [ ] Estudar comunicação entre serviços;
- [ ] Explorar API Gateway e escalabilidade;
- [ ] Considerar microsserviços apenas quando o problema justificar a complexidade.

---

## Fluxo de Git sugerido

```text
main
  └── feat/nome-da-funcionalidade
        └── commits pequenos e descritivos
              └── Pull Request
                    └── merge na main
```

Exemplos de mensagens de commit:

```text
feat(client): add basic CPF validation
feat(account): implement deposit operation
fix(account): reject withdrawal without funds
docs: add project plan
```

## Backlog futuro

- PIX agendado e recorrente;
- TED, boletos e cashback;
- Cartão virtual e programa de pontos;
- Dashboard web e aplicativo mobile;
- Relatórios e notificações;
- Open Finance;
- CDB, Tesouro Direto, fundos, ações e criptomoedas.

## Observação final

Este plano é um guia de evolução, não uma obrigação rígida. As milestones podem mudar conforme novos conhecimentos, necessidades e decisões de design surgirem durante o desenvolvimento.
