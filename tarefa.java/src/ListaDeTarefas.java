import java.util.ArrayList;
import java.util.Scanner;

class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }

    @Override
    public String toString() {
        return descricao + (concluida ? " [✔️]" : " [✖️]");
    }
}

public class ListaDeTarefas {
    private ArrayList<Tarefa> tarefas;

    public ListaDeTarefas() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        tarefas.add(novaTarefa);
        System.out.println("Tarefa adicionada: " + descricao);
    }

    public void marcarTarefaComoConcluida(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).marcarComoConcluida();
            System.out.println("Tarefa marcada como concluída: " + tarefas.get(indice).getDescricao());
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void exibirTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
            return;
        }
        System.out.println("Lista de Tarefas:");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println(i + ": " + tarefas.get(i));
        }
    }

    public void excluirTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            System.out.println("Tarefa excluída: " + tarefas.get(indice).getDescricao());
            tarefas.remove(indice);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void main(String[] args) {
        ListaDeTarefas lista = new ListaDeTarefas();
        Scanner scanner = new Scanner(System.in);
        String comando;

        do {
            System.out.println("\nComandos:");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Marcar tarefa como concluída");
            System.out.println("3 - Exibir todas as tarefas");
            System.out.println("4 - Excluir tarefa");
            System.out.println("0 - Sair");
            System.out.print("Escolha um comando: ");
            comando = scanner.nextLine();

            switch (comando) {
                case "1":
                    System.out.print("Descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    lista.adicionarTarefa(descricao);
                    break;
                case "2":
                    System.out.print("Índice da tarefa a marcar como concluída: ");
                    int indiceConcluida = Integer.parseInt(scanner.nextLine());
                    lista.marcarTarefaComoConcluida(indiceConcluida);
                    break;
                case "3":
                    lista.exibirTarefas();
                    break;
                case "4":
                    System.out.print("Índice da tarefa a excluir: ");
                    int indiceExcluir = Integer.parseInt(scanner.nextLine());
                    lista.excluirTarefa(indiceExcluir);
                    break;
                case "0":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Comando inválido.");
            }
        } while (!comando.equals("0"));

        scanner.close();
    }
}
