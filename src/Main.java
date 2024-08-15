import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinariaDeBusca estoque = new ArvoreBinariaDeBusca();

        // Produtos já inicializados
        estoque.inserirProduto(new Produto(101, "Notebook", 50));
        estoque.inserirProduto(new Produto(50, "Mouse", 200));
        estoque.inserirProduto(new Produto(200, "Teclado", 150));
        estoque.inserirProduto(new Produto(75, "Monitor", 75));
        estoque.inserirProduto(new Produto(150, "Impressora", 40));

        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Inserir Produto");
            System.out.println("2. Remover Produto");
            System.out.println("3. Buscar Produto");
            System.out.println("4. Exibir Produtos em Ordem");
            System.out.println("5. Exibir Produto com Menor Código");
            System.out.println("6. Exibir Produto com Maior Código");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o código do produto: ");
                    int codigo = scanner.nextInt();
                    Produto produtoExistente = estoque.buscarProduto(codigo);

                    if (produtoExistente != null) {
                        System.out.println("Produto já existe: " + produtoExistente.getNome());
                        System.out.print("Digite a quantidade adicional: ");
                        int quantidadeAdicional = scanner.nextInt();
                        produtoExistente.setQuantidade(produtoExistente.getQuantidade() + quantidadeAdicional);
                        System.out.println("Quantidade do produto atualizada com sucesso!");
                    } else {
                        scanner.nextLine();  // Limpa o buffer
                        System.out.print("Digite o nome do produto: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite a quantidade: ");
                        int quantidade = scanner.nextInt();
                        estoque.inserirProduto(new Produto(codigo, nome, quantidade));
                        System.out.println("Produto inserido com sucesso!");
                    }
                    break;

                case 2:
                    System.out.print("Digite o código do produto a ser removido: ");
                    int codigoRemover = scanner.nextInt();
                    boolean removido = estoque.removerProduto(codigoRemover);
                    if (removido) {
                        System.out.println("Produto removido com sucesso!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o código do produto a ser buscado: ");
                    int codigoBuscar = scanner.nextInt();
                    Produto p = estoque.buscarProduto(codigoBuscar);
                    if (p != null) {
                        System.out.println("Produto encontrado:");
                        System.out.println(Produto.getCabecalhoTabela());
                        System.out.println("|------------|----------------------|------------|");
                        System.out.println(p);
                    } else {
                        System.out.println("Produto com código " + codigoBuscar + " não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\nProdutos em ordem:");
                    estoque.exibirProdutosEmOrdem();
                    break;

                case 5:
                    Produto menorProduto = estoque.buscarMenorCodigo();
                    if (menorProduto != null) {
                        System.out.println("\nProduto com menor código: ");
                        System.out.println(Produto.getCabecalhoTabela());
                        System.out.println("|------------|----------------------|------------|");
                        System.out.println(menorProduto);
                    }
                    break;

                case 6:
                    Produto maiorProduto = estoque.buscarMaiorCodigo();
                    if (maiorProduto != null) {
                        System.out.println("\nProduto com maior código: ");
                        System.out.println(Produto.getCabecalhoTabela());
                        System.out.println("|------------|----------------------|------------|");
                        System.out.println(maiorProduto);
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();

        } while (opcao != 0);

        scanner.close();
    }
}
