# Sistema de Gerenciamento de Usuários

[cite_start]Este projeto consiste em um sistema desktop para gerenciamento de usuários, desenvolvido como atividade avaliativa da disciplina de **Projeto de Sistemas de Software** da **UFES**[cite: 5, 27].

O software implementa um controle de acesso onde novos usuários solicitam cadastro e dependem de aprovação de um administrador para utilizar o sistema. Também inclui funcionalidades de notificações internas e logs de operação.

## 🚀 Funcionalidades Principais

O sistema atende aos seguintes casos de uso e histórias de usuário:

* [cite_start]**Configuração Inicial:** Cadastro do primeiro administrador (autocadastro inicial)[cite: 22].
* [cite_start]**Autenticação:** Login seguro para usuários autorizados[cite: 32].
* **Gestão de Usuários:**
    * [cite_start]Solicitação de cadastro por novos usuários ("Não usuários")[cite: 23].
    * [cite_start]Autorização ou rejeição de novos cadastros pelo administrador[cite: 283].
    * [cite_start]Manutenção de usuários (CRUD), incluindo promoção e rebaixamento de perfil[cite: 342, 867].
* [cite_start]**Notificações:** Envio de notificações por administradores e visualização/leitura por usuários[cite: 33, 34].
* [cite_start]**Relatórios:** Listagem de usuários com estatísticas de notificações enviadas e lidas[cite: 35].
* [cite_start]**Segurança:** Validação forte de senhas e alteração de senha pelo usuário[cite: 36, 105].
* [cite_start]**Auditoria:** Registro de logs de operações em formatos configuráveis (CSV ou JSONL)[cite: 37, 54].
* [cite_start]**Restauração:** Funcionalidade para o administrador principal resetar o sistema ao estado original[cite: 925].

## 🛠 Tecnologias e Arquitetura

O projeto foi desenvolvido seguindo estritamente os requisitos não funcionais (RNFs) propostos:

* [cite_start]**Linguagem:** Java 17[cite: 113].
* [cite_start]**Gerenciamento de Projeto:** Maven[cite: 121].
* [cite_start]**Interface Gráfica:** Java Swing (construído com editor visual do NetBeans - arquivos `.form`)[cite: 69].
* [cite_start]**Estilo de Interface:** MDI (Multiple Document Interface)[cite: 83].
* [cite_start]**Arquitetura:** MVP (Model-View-Presenter) na abordagem *Passive View*[cite: 60].
* [cite_start]**Banco de Dados:** SQLite (arquivo local na raiz do projeto)[cite: 73].
* **Persistência:** Padrão *Repository* seguindo princípios S.O.L.I.D. (sem uso de frameworks ORM) [cite_start][cite: 75, 76].
* [cite_start]**Bibliotecas Externas:** Validador de Senha e Biblioteca de Log (via JitPack)[cite: 97, 105].

## 📋 Requisitos Implementados

Conforme exigido pelo **RNF09**, a lista detalhada de requisitos que **não** foram implementados (ou foram parcialmente implementados) encontra-se no documento a seguir:

 **[https://docs.google.com/document/d/1nUDwBixn4EnmQSvTFQwB3ogkeg9GEaN4AuLxN5oP6ls/edit?usp=sharing]** 

## 🔧 Como Executar

    Clone este repositório:
    ```bash
    git clone <link-do-repositorio>
    ```


## ✒️ Autores

* **André Tavares Louzada**
* **Lucas Herbest Lopes**
* **Yuri Sousa Almeida**

---
*Este projeto segue as diretrizes de integridade acadêmica do Departamento de Computação da UFES.*
