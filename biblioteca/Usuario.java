package biblioteca;
import java.util.ArrayList;
import java.util.List;


public class Usuario {
    String nome;
    private List<Exemplar> livrosEmprestados;           // ISSO DAQUI TUDO TAMBEM É A PARTE DE USUARIO 5. NAS FUNCIONALIDADES
    private List<Exemplar> livrosRetornados;               // EU NÃO TESTEI AINDA

    public Usuario(String nome) {
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<>();
        this.livrosRetornados = new ArrayList<>();
    }

    public void alugar(Exemplar exemplar) {
        if (exemplar.alugar()) {
            livrosEmprestados.add(exemplar);
        }
        else {
            System.out.println(this.nome + " falhou ao tentar alugar " + exemplar.obra.titulo);
        }
    }

    public void devolver(Exemplar exemplar) {
        if (exemplar.devolver()) {
            livrosRetornados.add(exemplar);
            livrosEmprestados.remove(exemplar);
        }
    }

    public void consultarLivrosEmprestados() {
        System.out.println("Livros emprestados por " + nome + ":");
        for (Exemplar exemplar : livrosEmprestados) {
            exemplar.consultar();
           
        }
        System.out.println("Livros retornados por " + nome + ":");
        for (Exemplar exemplar : livrosRetornados) {
            exemplar.consultar();
            
        }
    }
    
}

