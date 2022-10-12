package trabalho_pesquisa_em_largura;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao = 0;
        String verticeInicial = "";

        Hashtable<String, ArrayList<String>> tabela = new Hashtable<String, ArrayList<String>>();

        Scanner scan = new Scanner(System.in);

        ArrayList<String> vizinhosJuan = new ArrayList<String>();
        vizinhosJuan.add("Maria");
        vizinhosJuan.add("Lucia");
        vizinhosJuan.add("Milena");

        ArrayList<String> vizinhosJavier = new ArrayList<String>();
        vizinhosJavier.add("Andrés");
        vizinhosJavier.add("Milena");
        vizinhosJavier.add("Yadira");

        ArrayList<String> vizinhosMilena = new ArrayList<String>();
        vizinhosMilena.add("Juan");
        vizinhosMilena.add("Yadira");

        ArrayList<String> vizinhosAndres = new ArrayList<String>();
        vizinhosAndres.add("Maria");

        ArrayList<String> vizinhosYadira = new ArrayList<String>();
        vizinhosYadira.add("Lucia");

        tabela.put("Juan", vizinhosJuan);
        tabela.put("Javier", vizinhosJavier);
        tabela.put("Milena", vizinhosMilena);
        tabela.put("Yadira", vizinhosYadira);
        try {
            while (opcao != 7) {
                System.out.println("--- Pesquisa em Largura ---");
                System.out.println("Verifique o grafo abaixo: \n");
                showData(tabela);
                System.out.println("\nSelecione uma das opções abaixo do grado, para\n"
                    + "descobrir se o vértice (pessoa escolhida) encontra a pessoa 'Maria':");
                System.out.println(" 1 - Juan\n 2 - Milena\n 3 - Javier\n 4 - Andrés\n 5 - Yadira\n 6 - Lucia\n 7 - Sair");
                System.out.print("Opção escolhida: ");
                opcao = scan.nextInt();

                switch (opcao) {
                    case 1:
                        verticeInicial = "Juan";
                        System.out.println(pesquisaEmLargura(tabela, verticeInicial));

                        Thread.sleep(3000);
                        break;

                    case 2:
                        verticeInicial = "Milena";
                        System.out.println(pesquisaEmLargura(tabela, "Milena"));

                        Thread.sleep(3000);
                        break;

                    case 3:
                        verticeInicial = "Javier";
                        System.out.println(pesquisaEmLargura(tabela, "Javier"));

                        Thread.sleep(3000);
                        break;

                    case 4:
                        verticeInicial = "Andrés";
                        System.out.println(pesquisaEmLargura(tabela, "Andrés"));

                        Thread.sleep(3000);
                        break;

                    case 5:
                        verticeInicial = "Yadira";
                        System.out.println(pesquisaEmLargura(tabela, "Yadira"));

                        Thread.sleep(3000);
                        break;

                    case 6:
                        verticeInicial = "Lucia";
                        System.out.println(pesquisaEmLargura(tabela, "Lucia"));

                        Thread.sleep(3000);
                        break;
                        
                    case 7:
                        Thread.sleep(3000);
                        System.out.println("Programa finalizado!");
                        break;
                
                    default:
                        System.out.println("Opção inválida. Digite o número de alguma das opções mencionadas!");
                        break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String pesquisaEmLargura(Hashtable<String, ArrayList<String>> tabela, String verticeInicial){
        Queue<String> fila = new LinkedList<String>();
        ArrayList<String> verificados = new ArrayList<String>();

        fila = enfileirar(fila, (ArrayList<String>)tabela.get(verticeInicial));

        while(fila.size() > 0){
            String pessoa = fila.poll();

            if ("Maria".equals(pessoa))
                return "Maria foi encontrado!\n";

            if (verificados.contains(pessoa))
                continue;

            fila = enfileirar(fila, (ArrayList<String>)tabela.get(pessoa));
            verificados.add(pessoa);
        }

        return "Maria não foi encontrado!\n";
    }

    private static Queue<String> enfileirar(Queue<String> fila, ArrayList<String> lista){
        if (lista == null)
            return fila;

        for (String item : lista){
            fila.offer(item);
        }

        return fila;
    }

    private static void showData(Hashtable<String, ArrayList<String>> tabela){
        for (Map.Entry<String, ArrayList<String>> entry : tabela.entrySet()){
            String chave = entry.getKey();
            ArrayList<String> dados = entry.getValue();

            System.out.println("Chave: " + chave + " Dados: " + dados);
        }
    }
}
