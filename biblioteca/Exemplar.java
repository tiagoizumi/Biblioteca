package biblioteca;

public class Exemplar {
    String id;
    Obra obra;
    boolean disponivel;
    int edicao;
    public Exemplar(String id, Obra obra, int edicao){
        this.id = id;
        this.obra = obra;
        this.disponivel = true;
        this.edicao = edicao;
    }
    public boolean alugar() {
        if (disponivel) {
            disponivel = false;
            return true;
        }
        else {
            System.out.println(obra.titulo + " do id " + id + " não está disponível");
            return false;
        }
    }
    public boolean devolver() {
        if(disponivel == false){
            disponivel = true;      // CRIEI iSSO DAQUI
            return true;

        }
        else {
            System.out.println(obra.titulo + " do id " + id + " já foi devolvido ou não foi alugado");
            return false;
        }
    }
    public void consultar() {  
        System.out.println("ID: " + id);
        System.out.println("Título: " + obra.titulo);          // E ISSO DAQUI , não entendi a parte de HIERARQUIA
        System.out.println("Autores: ");
        for (Autor autor : obra.autores) {
            System.out.println(autor.nome);
        }
        System.out.println("Edição: " + edicao);
        if (disponivel) {
            System.out.println("Disponível");
        }
        else {
            System.out.println("Indisponível");
        }

    }
}
