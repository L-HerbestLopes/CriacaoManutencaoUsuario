# Sistema de Gerenciamento de Usuários

Este projeto consiste em um sistema desktop para gerenciamento de usuários, desenvolvido como atividade avaliativa da disciplina de **Projeto de Sistemas de Software** da **UFES**.

O software implementa um controle de acesso onde novos usuários solicitam cadastro e dependem de aprovação de um administrador para utilizar o sistema. Também inclui funcionalidades de notificações internas e logs de operação.

## 🚀 Funcionalidades Principais

O sistema atende aos seguintes casos de uso e histórias de usuário:

* **Configuração Inicial:** Cadastro do primeiro administrador (autocadastro inicial).
* **Autenticação:** Login seguro para usuários autorizados.
* **Gestão de Usuários:**
    * Solicitação de cadastro por novos usuários ("Não usuários").
    * Autorização ou rejeição de novos cadastros pelo administrador.
    * Manutenção de usuários (CRUD), incluindo promoção e rebaixamento de perfil.
* **Notificações:** Envio de notificações por administradores e visualização/leitura por usuários.
* **Relatórios:** Listagem de usuários com estatísticas de notificações enviadas e lidas.
* **Segurança:** Validação forte de senhas e alteração de senha pelo usuário.
* **Auditoria:** Registro de logs de operações em formatos configuráveis (CSV ou JSONL).
* **Restauração:** Funcionalidade para o administrador principal resetar o sistema ao estado original.

## 🛠 Tecnologias e Arquitetura

O projeto foi desenvolvido seguindo estritamente os requisitos não funcionais (RNFs) propostos:

* **Linguagem:** Java 17.
* **Gerenciamento de Projeto:** Maven.
* **Interface Gráfica:** Java Swing (construído com editor visual do NetBeans - arquivos `.form`).
* **Estilo de Interface:** MDI (Multiple Document Interface).
* **Arquitetura:** MVP (Model-View-Presenter) na abordagem *Passive View*.
* **Banco de Dados:** SQLite (arquivo local na raiz do projeto).
* **Persistência:** Padrão *Repository* seguindo princípios S.O.L.I.D. (sem uso de frameworks ORM).
* **Bibliotecas Externas:** Validador de Senha e Biblioteca de Log (via JitPack).

## 📋 Requisitos Implementados

Conforme exigido pelo **RNF09**, a lista detalhada de requisitos que **não** foram implementados (ou foram parcialmente implementados) encontra-se no documento a seguir:

 **[https://docs.google.com/document/d/1nUDwBixn4EnmQSvTFQwB3ogkeg9GEaN4AuLxN5oP6ls/edit?usp=sharing]** 

## 🔧 Como Executar

    Clone este repositório:

    git clone <link-do-repositorio>

## ✒️ Autores

* **André Tavares Louzada**
* **Lucas Herbest Lopes**
* **Yuri Sousa Almeida**

---
*Este projeto segue as diretrizes de integridade acadêmica do Departamento de Computação da UFES.*
