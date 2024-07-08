package biblioteca;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private Usuario usuario;
    private Exemplar exemplar;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Usuario usuario, Exemplar exemplar, LocalDate dataEmprestimo) {
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = null;
    }

    public boolean devolvido() {return this.dataDevolucao == null;}

    public Exemplar getExemplar() {return exemplar;}

    public void marcarDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void info() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataEmprestimoStr = dataEmprestimo.format(formatter);
        String dataDevolucaoStr = (dataDevolucao != null) ? dataDevolucao.format(formatter) : "N/A";
        String tituloObra = exemplar.obra.titulo;

        System.out.format("%-20s %-20s %-15s %-15s %-10s%n", 
                          usuario.nome, tituloObra, dataEmprestimoStr, dataDevolucaoStr, this.devolvido() ? "Sim" : "Não");
    }
}
