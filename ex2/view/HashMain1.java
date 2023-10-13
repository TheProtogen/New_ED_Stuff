package view;

import java.util.HashMap;
import java.util.Random;
import javax.swing.JOptionPane;

public class HashMain1 {

    public static Random random = new Random();
    public static int[] vetores = new int[50];
    public static int contador = 0;

    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<>();

        String[] escolhasDisponiveis = {"Adicionar entidades","Imprimir dados","Pesquisar nome","Destruir nome","Sair"};

        boolean locked = true;
        while(locked) {
            int escolha = JOptionPane.showOptionDialog(null, "TEXTO","TITULO", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null,escolhasDisponiveis,escolhasDisponiveis[0]);


            switch(escolha) {
                case 0:
                    String pessoa = JOptionPane.showInputDialog("Digite um número");
                    adicionarAoHash(hashMap,pessoa.toUpperCase());
                    break;
                case 1:
                    System.out.println(hashMap);
                    break;
                case 2:
                    String pessoaPesquisada = JOptionPane.showInputDialog("Digite um número");
                    pesquisarNome(hashMap,pessoaPesquisada.toUpperCase());
                    break;
                case 3:
                    String pessoaDestruida = JOptionPane.showInputDialog("Digite um número");
                    destruirNome(hashMap,pessoaDestruida.toUpperCase());
                    break;
                default: //yeah
                    locked = false;
                    break;
            }

        }



    }

    private static void destruirNome(HashMap<Integer, String> hashMap, String pessoaDestruida) {
        if(hashMap.containsValue(pessoaDestruida)) {
            JOptionPane.showMessageDialog(null,"Nome localizado, destruindo...");
            //Destruição do nome
            hashMap.remove(pessoaDestruida);
        }
    }

    private static void pesquisarNome(HashMap<Integer, String> hashMap, String pessoaPesquisada) {
        if(hashMap.containsValue(pessoaPesquisada)) {
            JOptionPane.showMessageDialog(null,"Nome '");
        }


    }

    private static void adicionarAoHash(HashMap<Integer, String> hashMap, String pessoa) {
        if (contador < 50) {
            contador++;
            System.out.println("Contador: "+contador);

            int numeroEscolhido = random.nextInt(50);
            while(hashMap.containsKey(numeroEscolhido)){
                numeroEscolhido++;
                if (numeroEscolhido > vetores.length) {
                    numeroEscolhido = 0;
                }
            }

            hashMap.put(numeroEscolhido, pessoa);

        } else {
            JOptionPane.showMessageDialog(null, "Vetor está cheio, nome '"+pessoa.toUpperCase()+"' não pode ser colocado");
        }



    }

}