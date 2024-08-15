public class Produto {
    private int codigo;
    private String nome;
    private int quantidade;

    public Produto(int codigo, String nome, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-20s | %-10s |", codigo, nome, quantidade);
    }

    public static String getCabecalhoTabela() {
        return String.format("| %-10s | %-20s | %-10s |", "Código", "Nome", "Quantidade");
    }
}

