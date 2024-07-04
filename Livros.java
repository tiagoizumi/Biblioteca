

public class Livros {
    String titulo;
    Autor[] autor;
    Categoria categoria;
    Boolean disponivel;

    public Livros(String titulo, Autor[] autor, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.disponivel = true;
    }

    void status() {
        if(disponivel){
            System.out.println("pode alugar");
        }
    }
}
