package view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMain2 {
    public static void main(String[] args) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        String[] escolhasDisponiveis = {"Adicionar entidades","Imprimir dados","Pesquisar nome","Destruir nome","Status espaço","Sair"};

        boolean locked = true;
        while(locked) {
            int escolha = JOptionPane.showOptionDialog(null, "TEXTO","TITULO", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null,escolhasDisponiveis,escolhasDisponiveis[0]);


            switch(escolha) {
                case 0:
                    adicionarAoHash(hashMap);
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

    private static void adicionarAoHash(HashMap<String, List<String>> hashMap) {

        String pessoa = JOptionPane.showInputDialog("Digite o nome a ser adicionado").toUpperCase();
        String pessoaChave = JOptionPane.showInputDialog("Digite a chave desse nome").toUpperCase();

        System.out.println(pessoaChave+" : "+pessoa);

        if(hashMap.containsKey(pessoaChave)){
            hashMap.get(pessoaChave).add(pessoa);
        } else {
            List<String> listaAdicionada = new ArrayList<>();
            listaAdicionada.add(pessoa);
            //cria o hashmap agora
            hashMap.put(pessoaChave,listaAdicionada);
        }

    }

    //Se getKey() funcionar e retornar o valor desejado, usar essa fórmula para pesquisa e deletar
    //Se existe, retorna a chave, senão, null
    private static void pesquisarNome(HashMap<String, List<String>> hashMap, String pessoaPesquisada) {
        var value = getKey(hashMap,pessoaPesquisada);

        if(value != null) {
            JOptionPane.showMessageDialog(null,"Nome '"+pessoaPesquisada+"' localizado | Chave: "
                    +value);
        } else {
            JOptionPane.showMessageDialog(null,"Nome não encontrado!!!!");
        }

    }

    private static void destruirNome(HashMap<String, List<String>> hashMap, String pessoaDestruida) {
        var value = getKey(hashMap,pessoaDestruida);

        if(value != null) {
            hashMap.get(value).remove(pessoaDestruida);
            JOptionPane.showMessageDialog(null,"Nome foi destruído com sucesso");
        } else {
            JOptionPane.showMessageDialog(null,"Nome não encontrado!!!!");
        }
    }


    private static void verificarMemory(HashMap<String, List<String>> hashMap) {
        String listaDeListas = "";
        for (HashMap.Entry<String, List<String>> entrada : hashMap.entrySet()) {
            String chave = entrada.getKey();
            List<String> lista = entrada.getValue();
            int tamanhoLista = lista.size();
            listaDeListas = listaDeListas.concat("Tamanho da lista da chave " + chave + ": [" + tamanhoLista+"]\n");
            System.out.println("Size of list for chave " + chave + ": " + tamanhoLista);
        }
        JOptionPane.showMessageDialog(null,"> Chaves existentes = "+hashMap.size()+"\n\n"+listaDeListas);

    }

    //Pega a key, só que usando string dessa vez
    public static String getKey(HashMap<String, List<String>> hashMap, String valueToSearch) {
        for (HashMap.Entry<String, List<String>> entrada : hashMap.entrySet()) {
            if (entrada.getValue().contains(valueToSearch)) {
                return entrada.getKey();
            }
        }
        return null; // Value not found
    }

}
