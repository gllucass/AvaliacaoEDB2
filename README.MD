# Sistema de Gerenciamento de Estoque com Árvore Binária de Busca (BST)

Este projeto implementa um sistema de gerenciamento de estoque para uma empresa de e-commerce utilizando uma Árvore Binária de Busca (BST - Binary Search Tree). A estrutura de dados foi escolhida para garantir a eficiência na inserção, remoção e busca de produtos, que são identificados por códigos únicos.

## Descrição do Projeto

Este projeto faz parte da disciplina **DIM0117 - Estruturas de Dados Básicas II** do curso de Bacharelado em Tecnologia da Informação na **Universidade Federal do Rio Grande do Norte (UFRN)**, proposto pelo professor **Edson Jackson de Medeiros Neto**.

O objetivo é criar um sistema que gerencie o estoque de produtos de uma empresa de e-commerce, permitindo operações de inserção, remoção, busca e exibição de produtos utilizando uma árvore binária de busca.

## Funcionalidades

O sistema implementa as seguintes operações:

1. **Inserir Produto:** Inserir um novo produto no estoque. Se um produto com o mesmo código já existir, atualizar a quantidade disponível.
2. **Remover Produto:** Remover um produto do estoque pelo seu código.
3. **Buscar Produto:** Buscar um produto pelo seu código e exibir suas informações (nome e quantidade em estoque).
4. **Exibir Produtos em Ordem:** Exibir todos os produtos ordenados pelo código (em ordem crescente).
5. **Exibir Produto com Menor Código:** Exibir as informações do produto com o menor código.
6. **Exibir Produto com Maior Código:** Exibir as informações do produto com o maior código.

## Requisitos Técnicos

- **Linguagem:** Java
- **Estrutura de Dados:** Árvore Binária de Busca (BST)
- **Classes Principais:**
    - `Produto`: Representa um produto no estoque, com código, nome e quantidade.
    - `ArvoreBinariaDeBusca`: Implementa as operações de gerenciamento do estoque utilizando a BST.

## Detalhes de Implementação

- **Inserção de Produto:** O produto é inserido na posição correta na árvore, comparando seu código com os existentes.

- **Remoção de Produto:** A remoção lida com três possíveis casos: nó folha, nó com um filho, e nó com dois filhos.

- **Busca de Produto:** A busca utiliza o código do produto para localizar sua posição na árvore.

- **Exibição em Ordem:** A exibição dos produtos é feita em ordem crescente de códigos através de uma travessia in-order na árvore.

- **Exibição do Menor/Maior Código:** Identificação do produto com menor ou maior código na árvore.

## Considerações Finais

Este sistema foi projetado para ser simples e eficiente no gerenciamento de estoque, utilizando a Árvore Binária de Busca para garantir rapidez nas operações essenciais.

---

**Desenvolvido por:** Geraldo Lucas Bezerra Rocha  
**Disciplina:** DIM0117 - Estruturas de Dados Básicas II  
**Universidade Federal do Rio Grande do Norte (UFRN)**  
**Professor:** Edson Jackson de Medeiros Neto
