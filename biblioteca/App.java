package biblioteca;

public class App {
    public static void main(String[] args) {
        Autor autor1 = new Autor("ana almeida");
        Autor autor2 = new Autor("bernardo bruno");
        Obra obra1 = new Obra("calculo 1", new Autor[]{autor1, autor2});
        Exemplar ob01ex01 = new Exemplar("ob01ex01", obra1, 0);
        Usuario usuario1 = new Usuario("Tiago");
        Usuario usuario2 = new Usuario("Vitor");

        usuario1.alugar(ob01ex01);
        usuario2.alugar(ob01ex01);
        usuario1.consultarLivrosEmprestados();
    }
}
