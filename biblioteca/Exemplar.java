package biblioteca;

public class Exemplar {
    private String id;
    private Obra obra;
    private int edicao;
    private Usuario alugadoPor;

    public Exemplar(String id, Obra obra, int edicao){
        this.id = id;
        this.obra = obra;
        this.edicao = edicao;
        this.alugadoPor = null;
        obra.addExemplar(this);
    }

    public boolean alugar(Usuario usuario) {
        if (alugadoPor == null) {
            alugadoPor = usuario;
            return true;
        }
        else {
            System.out.println(obra.getTitulo() + " do id " + id + " não está disponível");
            return false;
        }
    }
    public boolean devolver(Usuario usuario, Exemplar exemplar) {
        if(alugadoPor == usuario){
            alugadoPor = null;
            return true;
        }
        else {
            System.out.println(obra.getTitulo() + " do id " + id + " não está alugado por " + usuario.getNome());
            return false;
        }
    }
    public void consultar() {  
        System.out.println("ID: " + id);
        System.out.println("Título: " + obra.getTitulo());
        System.out.println("Autores: ");
        for (Autor autor : obra.getAuotres()) {
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

    public String getId() {return id;}
    public Obra getObra() {return obra;}
    public int getEdicao() {return edicao;}
    public Usuario getAlugadoPor() {return alugadoPor;}

    public String getTituloDaObra() {return obra.getTitulo();}
}
