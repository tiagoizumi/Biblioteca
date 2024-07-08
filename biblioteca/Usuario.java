package biblioteca;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class Usuario {
    String nome;
    private List<Emprestimo> emprestimos;

    public Usuario(String nome) {
        this.nome = nome;
        this.emprestimos = new ArrayList<>();
    }

    public void alugar(Exemplar exemplar, LocalDate dataEmprestimo) {
        if (exemplar.alugar(this)) {
            emprestimos.add(new Emprestimo(this, exemplar, dataEmprestimo));
        }
        else {
            System.out.println(this.nome + " falhou ao tentar alugar " + exemplar.obra.titulo);
            System.out.println();
        }
    }

    public void devolver(Exemplar exemplar, LocalDate dataDevolucao) {
        if (exemplar.devolver(this, exemplar)) {
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getExemplar() == exemplar) {
                    emprestimo.marcarDevolucao(dataDevolucao);
                    return;
                }
            }
        }
        else {
            System.out.println(this.nome + " falhou ao tentar devolver " + exemplar.obra.titulo);
            System.out.println();
        }
    }
    
    public void consultarHistorico() {
        System.out.format("%-20s %-20s %-15s %-15s %-10s%n", 
                          "Usuário", "Título da Obra", "Data Empréstimo", "Data Devolução", "Devolvido");
        System.out.println("----------------------------------------------------------------------------------------");
        for (Emprestimo emprestimo : emprestimos) {
            emprestimo.info();
        }
    }
}

