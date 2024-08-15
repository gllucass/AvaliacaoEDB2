public class ArvoreBinariaDeBusca {
    private class No {
        Produto produto;
        No esquerda, direita, pai;

        No(Produto produto) {
            this.produto = produto;
        }
    }

    private No raiz;

    // Método para inserir um produto na árvore
    public void inserirProduto(Produto produto) {
        raiz = inserirProduto(raiz, produto);
    }

    private No inserirProduto(No noAtual, Produto produto) {
        if (noAtual == null) {
            return new No(produto);
        }

        if (produto.getCodigo() < noAtual.produto.getCodigo()) {
            noAtual.esquerda = inserirProduto(noAtual.esquerda, produto);
        } else if (produto.getCodigo() > noAtual.produto.getCodigo()) {
            noAtual.direita = inserirProduto(noAtual.direita, produto);
        } else {
            // Produto já existe, atualize a quantidade
            noAtual.produto.setQuantidade(noAtual.produto.getQuantidade() + produto.getQuantidade());
        }

        return noAtual;
    }

    // Método para buscar um produto pelo código
    public Produto buscarProduto(int codigo) {
        No no = buscarProduto(raiz, codigo);
        return no != null ? no.produto : null;
    }

    private No buscarProduto(No noAtual, int codigo) {
        if (noAtual == null || noAtual.produto.getCodigo() == codigo) {
            return noAtual;
        }

        if (codigo < noAtual.produto.getCodigo()) {
            return buscarProduto(noAtual.esquerda, codigo);
        } else {
            return buscarProduto(noAtual.direita, codigo);
        }
    }

    public boolean removerProduto(int codigo) {
        // Verifica se o produto existe antes de tentar removê-lo
        No noParaRemover = buscarProduto(raiz, codigo);
        if (noParaRemover == null) {
            System.out.println("Produto com código " + codigo + " não encontrado.");
            return false;  // Indica que o produto não foi removido
        }

        // Se o produto existe, prossegue com a remoção
        raiz = removerProduto(raiz, codigo);
        return true;  // Indica que o produto foi removido com sucesso
    }

    private No removerProduto(No noAtual, int codigo) {
        if (noAtual == null) {
            return null;
        }

        if (codigo < noAtual.produto.getCodigo()) {
            noAtual.esquerda = removerProduto(noAtual.esquerda, codigo);
        } else if (codigo > noAtual.produto.getCodigo()) {
            noAtual.direita = removerProduto(noAtual.direita, codigo);
        } else {
            // Caso 1: Nó com apenas um filho ou nenhum
            if (noAtual.esquerda == null) {
                return noAtual.direita;
            } else if (noAtual.direita == null) {
                return noAtual.esquerda;
            }

            // Caso 2: Nó com dois filhos, pegue o menor na subárvore direita
            noAtual.produto = buscarMenorCodigo(noAtual.direita).produto;

            // Remova o sucessor
            noAtual.direita = removerProduto(noAtual.direita, noAtual.produto.getCodigo());
        }

        return noAtual;
    }


    // Método para exibir todos os produtos em ordem crescente pelo código
    public void exibirProdutosEmOrdem() {
        System.out.println(Produto.getCabecalhoTabela());
        System.out.println("|------------|----------------------|------------|");
        exibirProdutosEmOrdem(raiz);
    }

    private void exibirProdutosEmOrdem(No noAtual) {
        if (noAtual != null) {
            exibirProdutosEmOrdem(noAtual.esquerda);
            System.out.println(noAtual.produto);
            exibirProdutosEmOrdem(noAtual.direita);
        }
    }

    // Método para buscar o produto com menor código
    public Produto buscarMenorCodigo() {
        No no = buscarMenorCodigo(raiz);
        return no != null ? no.produto : null;
    }

    private No buscarMenorCodigo(No noAtual) {
        while (noAtual != null && noAtual.esquerda != null) {
            noAtual = noAtual.esquerda;
        }
        return noAtual;
    }

    // Método para buscar o produto com maior código
    public Produto buscarMaiorCodigo() {
        No no = buscarMaiorCodigo(raiz);
        return no != null ? no.produto : null;
    }

    private No buscarMaiorCodigo(No noAtual) {
        while (noAtual != null && noAtual.direita != null) {
            noAtual = noAtual.direita;
        }
        return noAtual;
    }
}
