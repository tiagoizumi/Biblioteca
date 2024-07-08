package biblioteca;

public class Exemplar {
    String id;
    Obra obra;
    int edicao;
    Usuario alugadoPor;

    public Exemplar(String id, Obra obra, int edicao){
        this.id = id;
        this.obra = obra;
        this.edicao = edicao;
        this.alugadoPor = null;

    }

    public boolean alugar(Usuario usuario) {
        if (alugadoPor == null) {
            alugadoPor = usuario;
            return true;
        }
        else {
            System.out.println(obra.titulo + " do id " + id + " não está disponível");
            return false;
        }
    }
    public boolean devolver(Usuario usuario, Exemplar exemplar) {
        if(alugadoPor == usuario){
            alugadoPor = null;
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
        if (alugadoPor == null) {
            System.out.println("Disponível");
        }
        else {
            System.out.println("Indisponível");
        }

    }
}
