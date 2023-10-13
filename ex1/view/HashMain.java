package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

public class HashMain {

    public static void main(String[] args) {
        //Cria o hashmap onde vai ir os nomes, com a letra na ordem
        HashMap<Character, List<String>> hashMap = new HashMap<>();

        //Inicializa o hash com a lista, tudo vazio
        char[] alphabet = makeAlphabet();
        for (char c : alphabet) {
            hashMap.put(c, new ArrayList<>());
        }

        boolean telaInicial = true;
        String[] escolhasDisponiveis = {"Adicionar entidades","Imprimir dados","Pesquisar nome","Destruir nome","Sair"};
        while(telaInicial) {
            int escolha = JOptionPane.showOptionDialog(null, "Escolha...","Armazenador de dados", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null,escolhasDisponiveis,escolhasDisponiveis[0]);

            //Switch case madness
            switch(escolha) {
                case 0:
                    int pessoasAdicionar = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de nomes que queres adicionar",4));
                    adicionarAoHash(hashMap,alphabet,pessoasAdicionar);
                    break;
                case 1:
                    System.out.println(hashMap);
                    break;
                case 2:
                    String nomePesquisar = JOptionPane.showInputDialog("Digite o nome que será pesquisado");
                    pesquisarNome(hashMap,nomePesquisar); //deve mandar string
                    break;
                case 3:
                    String nomeDestruir = JOptionPane.showInputDialog("Digite o nome que será destruído");
                    nomeExplodir(hashMap, nomeDestruir);
                    break;
                default:
                    telaInicial = false;
                    break;
            }

        }
    }


    private static void nomeExplodir(HashMap<Character, List<String>> hashMap, String nomeDestruir) {

        nomeDestruir = nomeDestruir.toUpperCase();
        char searchKey = nomeDestruir.charAt(0);
        if(pesquisarNome(hashMap,nomeDestruir)) {
            List<String> list = hashMap.get(searchKey);
            list.remove(nomeDestruir);
            JOptionPane.showMessageDialog(null, "Destruição de nome concluída com sucesso");
        }

    }


    private static boolean pesquisarNome(HashMap<Character, List<String>> hashMap, String nomePesquisar) {

        nomePesquisar = nomePesquisar.toUpperCase();
        char searchKey = nomePesquisar.charAt(0);
        if (hashMap.containsKey(searchKey)) {
            List<String> list = hashMap.get(searchKey);
            if (list.contains(nomePesquisar)) {
                JOptionPane.showMessageDialog(null, "Nome '"+nomePesquisar+"' localizado | Chave atual: "+searchKey);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Nome '"+nomePesquisar+"' não localizado");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nome não localizado | Iniciais com '" + searchKey + "' não existem");
            return false;
        }

    }


    //Faz o hashmap com as informações que o user vai dando
    public static void adicionarAoHash(HashMap<Character, List<String>> hashMap, char[] alphabet, int numeroAdicionar) {

        String[] nome = new String[numeroAdicionar];

        for(int i = 0; i < nome.length; i++) {
            //pega o nome
            nome[i] = JOptionPane.showInputDialog(null,"Insira o nome aqui").toUpperCase();

            //verifica a primeira letra e faz alguma coisa
            for (char c : alphabet) {
                if (nome[i].charAt(0) == c) {
                    //coloca na lista
                    hashMap.get(c).add(nome[i]);
                    break;
                }
            }
        }
    }

    //É só o alfabeto
    public static char[] makeAlphabet() {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }


}