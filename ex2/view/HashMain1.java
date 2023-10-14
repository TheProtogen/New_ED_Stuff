package view;

import java.util.HashMap;
import java.util.Random;
import javax.swing.JOptionPane;

public class HashMain1 {

    public static final int MEMORY_TOTAL = 50;
    public static Random random = new Random();
    public static int[] vetores = new int[50];
    public static int contador = 0;

    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<>(50);

        String[] escolhasDisponiveis = {"Adicionar entidades","Imprimir dados","Pesquisar nome","Destruir nome","Status espaço","Sair"};

        boolean locked = true;
        while(locked) {
            int escolha = JOptionPane.showOptionDialog(null, "TEXTO","TITULO", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null,escolhasDisponiveis,escolhasDisponiveis[0]);


            switch(escolha) {
                case 0:
                    String pessoaNome = JOptionPane.showInputDialog("Digite o nome a ser adicionado");
                    adicionarAoHash(hashMap,pessoaNome.toUpperCase());
                    break;
                case 1:
                    System.out.println(hashMap);
                    break;
                case 2:
                    String pessoaPesquisada = JOptionPane.showInputDialog("Digite o nome a ser pesquisado");
                    pesquisarNome(hashMap,pessoaPesquisada.toUpperCase());
                    break;
                case 3:
                    String pessoaDestruida = JOptionPane.showInputDialog("Digite o nome a ser destruido");
                    destruirNome(hashMap,pessoaDestruida.toUpperCase());
                    break;
                case 4:
                    verificarMemory(hashMap);
                    break;
                default: //yeah
                    locked = false;
                    break;
            }

        }



    }

    private static void verificarMemory(HashMap<Integer, String> hashMap) {
        String statusMemory;
        if (hashMap.size() == MEMORY_TOTAL) {
            statusMemory = "MEMÓRIA CHEIA";
        } else {
            statusMemory = "MEMÓRIA DISPONÍVEL: "+(MEMORY_TOTAL - hashMap.size());
        }
        JOptionPane.showMessageDialog(null,"> Contador: "+contador+"\n> HashMap.size(): "+
                hashMap.size()+"\n"+statusMemory);
    }

    //[IMPORTANTE] útil para localizar a chave de um valor
    public static <K, V> K getKey (HashMap<K, V> hashMap, V nomePesquisarChave) {
        for (HashMap.Entry<K, V> entry : hashMap.entrySet()) {
            if (entry.getValue().equals(nomePesquisarChave)) {
                return entry.getKey(); // valor localizado: retorna a chave
            }
        }
        return null; // valor não localiado
    }

    private static void destruirNome(HashMap<Integer, String> hashMap, String pessoaDestruida) {
        var value = getKey(hashMap,pessoaDestruida);

        if(value != null) {
            hashMap.remove(value,pessoaDestruida);
            contador--;
            JOptionPane.showMessageDialog(null,"Nome destruido");
        } else {
            JOptionPane.showMessageDialog(null,"Nome não pode ser destruído, pois não existe");
        }
    }

    private static void pesquisarNome(HashMap<Integer, String> hashMap, String pessoaPesquisada) {
        var value = getKey(hashMap,pessoaPesquisada);

        if(value != null) {
            JOptionPane.showMessageDialog(null,"Nome '"+pessoaPesquisada+"' localizado | Chave: "
                    +value);
        } else {
            JOptionPane.showMessageDialog(null,"Nome não encontrado!!!!");
        }
    }

    private static void adicionarAoHash(HashMap<Integer, String> hashMap, String pessoa) {
        if (contador < MEMORY_TOTAL) {
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