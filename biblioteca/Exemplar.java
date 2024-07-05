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
            System.out.println(obra.titulo + "do id" + id + "não está disponível");
            return false;
        }
    }
}
