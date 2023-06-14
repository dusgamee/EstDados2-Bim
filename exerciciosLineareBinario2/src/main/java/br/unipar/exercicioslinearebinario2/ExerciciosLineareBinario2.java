
package br.unipar.exercicioslinearebinario2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class ExerciciosLineareBinario2{
   
    public static int menu() {
        String menu = "Escolha uma opção:\n" +
                      "1 - Cadastrar cliente\n" +
                      "2 - Ordenar clientes por código\n" +
                      "3 - Buscar cliente por código\n" +
                      "4 - Sair";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }
 
    public static void cadastrarCliente(ArrayList<Cliente> clientes) {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do cliente"));
        
        String nome = JOptionPane.showInputDialog("Informe o nome:");
        
        String dataNascimento = JOptionPane.showInputDialog("Informe a data de nascimento:");
        
        String cpf = JOptionPane.showInputDialog("Informe o CPF:");
        
        Cliente cliente = new Cliente(codigo, nome, dataNascimento, cpf);
        clientes.add(cliente);
        JOptionPane.showMessageDialog(null, "Cadastrado realizado com sucesso!");
    }
 
    public static void ordenarClientes(ArrayList<Cliente> clientes) {
        Collections.sort(clientes, new Comparator<Cliente>() {
            public int compare(Cliente c1, Cliente c2) {
                return c1.getCodigo() - c2.getCodigo();
            }
        });
        JOptionPane.showMessageDialog(null, "Cadastros ordenados pelo código");
    }

    public static void buscarCliente(ArrayList<Cliente> clientes) {
        int codigoBusca = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do cliente"));
        int indice = buscaBinaria(clientes, codigoBusca);
        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
        } else {
            Cliente cliente = clientes.get(indice);
            String mensagem = "Código: " + cliente.getCodigo() + "\n" +
                              "Nome: " + cliente.getNome() + "\n" +
                              "Data de Nascimento: " + cliente.getDataNascimento() + "\n" +
                              "CPF: " + cliente.getCpf();
            JOptionPane.showMessageDialog(null, mensagem);
        }
    }

    private static int buscaBinaria(ArrayList<Cliente> clientes, int codigoBusca) {
        int inicio = 0;
        int fim = clientes.size() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            Cliente cliente = clientes.get(meio);
            if (cliente.getCodigo() == codigoBusca) {
                return meio;
            } else if (cliente.getCodigo() < codigoBusca) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        int opcao;

        do {
            opcao = menu();

            switch (opcao) {
                case 1:
                    cadastrarCliente(clientes);
                    break;
                case 2:
                    ordenarClientes(clientes);
                    break;
                case 3:
                    buscarCliente(clientes);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saindo do programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }
        } while (opcao != 4);
    }
}

