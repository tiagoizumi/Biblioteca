package biblioteca;
import java.util.List;
import java.util.ArrayList;

public class Obra {
    private String titulo;
    private Autor[] autores;
    private List<Exemplar> exemplares;

    public Obra(String titulo, Autor[] autores) {
        this.titulo = titulo;
        this.autores = autores;
        this.exemplares = new ArrayList<>();
    }

    public void addExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }

    // getters
    public String getTitulo() {return this.titulo;}
    public Autor[] getAuotres() {return this.autores;}
}
