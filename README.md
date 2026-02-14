# Framework de Mapeamento Objeto-Relacional (MOR)

> Uma implementação de um framework de persistência em Java puro, desenhado para transpor o abismo entre a Orientação a Objetos e o modelo Relacional.

<div align="center">

  ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
  ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
  ![GoF](https://img.shields.io/badge/Design_Patterns-GoF-333333?style=for-the-badge&logo=uml&logoColor=white)

</div>

---

## Sobre o Projeto

Implementação prática dos conceitos avançados apresentados no livro *"Utilizando UML e Padrões"* de **Craig Larman**.

O objetivo não é apenas salvar dados, mas construir uma arquitetura desacoplada, coesa e extensível, aplicando rigorosamente os princípios de engenharia de software para resolver o problema da impedância objeto-relacional.

---

## Arquitetura e Design Patterns

O núcleo do framework é construído sobre uma base sólida de padrões **GoF (Gang of Four)**. Cada decisão arquitetural resolve um problema específico de persistência:

| Padrão | Aplicação no Projeto |
| :--- | :--- |
| **Façade** | A classe `Persistencia` atua como porta de entrada única, escondendo a complexidade interna do subsistema de persistência do resto da aplicação. |
| **Factory** | A `FabricaDeMapeador` lê o arquivo `configuracao.xml` e instancia dinamicamente o Mapeador correto para cada entidade, desacoplando a lógica SQL das classes de negócio. |
| **Template Method** | As classes abstratas de mapeamento definem o "esqueleto" dos algoritmos CRUD, permitindo que novas entidades sejam adicionadas apenas implementando os detalhes específicos, maximizando o reuso. |
| **State** | O ciclo de vida do objeto (`NOVO`, `ANTIGO_LIMPO`, `ANTIGO_SUJO...`) é gerido por classes de estado, eliminando condicionais complexas (`if/else`) e delegando o comportamento para o estado atual. |
| **Command & UoW** | Operações de banco são encapsuladas em objetos (`Command`). A classe `Transacao` atua como **Unit of Work**, agrupando esses comandos para execução em lote e garantindo atomicidade. |
| **Singleton** | Garante que serviços críticos como a `Persistencia` e a `FabricaDeMapeador` tenham instância única, centralizando o controle de recursos. |

---

## Funcionalidades

O framework oferece um ciclo completo de persistência:

* ✅ **CRUD Completo:** Operações de Create, Read, Update e Delete abstraídas.
* ✅ **Identity Map:** Cache de objetos para evitar leituras duplicadas do banco na mesma transação.
* ✅ **Extensibilidade XML:** Adição de novas entidades via configuração sem recompilar o núcleo.
* ✅ **Gestão Transacional:** Lógica de "commit em duas fases" para integridade referencial.
* ✅ **Dirty Checking:** O sistema sabe automaticamente quais objetos foram modificados e precisam ser salvos.

---

## Tecnologias Utilizadas

<div align="left">
  <img src="https://img.shields.io/badge/Java-JDK_8-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" />
  <img src="https://img.shields.io/badge/JDBC-Connector-gray?style=for-the-badge&logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/XML-JDOM_2-orange?style=for-the-badge&logo=xml&logoColor=white" />
</div>

---

## Como Executar

### Pré-requisitos
* **Java JDK 8+**
* **PostgreSQL** instalado e rodando.
* **pgAdmin** (Opcional, para visualização).

### Configuração
1.  Clone o repositório.
2.  Importe o projeto na sua IDE favorita (Eclipse/IntelliJ/VS Code).
3.  Configure o arquivo `configuracao.xml` com as credenciais do seu banco PostgreSQL.
4.  Execute a classe `Principal` (ou a classe de teste fornecida).

