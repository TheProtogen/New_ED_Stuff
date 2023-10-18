import java.util.LinkedList;

public class HashVivi {

    //OBS: Já que ainda tou aprendendo a criar um hash próprio, ele vai usar system.out.print() para testes mais rápidos


    public int TAMANHO;
    public LinkedList<String>[] tabelinha1;
    public int positionsNoNo = 0;

    public HashVivi(int TAMANHO){
        this.TAMANHO = TAMANHO;

        startHashAlfabetico();
    }

    private void startHashAlfabetico() {
        tabelinha1 = new LinkedList[TAMANHO];

        for (int i = 0; i < TAMANHO; i++) {
            tabelinha1[i] = new LinkedList<>();
        }
    }

    public void adicionarNome(String nomeAdicionar){
        if(!hashCheio()) {
            if (!nomeExiste(nomeAdicionar)){
                int position = assignerHash(nomeAdicionar);
                tabelinha1[position].add(nomeAdicionar);

                positionsNoNo++;

                System.out.println("Beep boop, adicionado");
            } else {
                System.out.println("Nome já existe");
            }

        } else {
            System.out.println("Hash está cheio!!!");
        }
    }

    public void nomeExplodir(String nome){
        if(nomeExiste(nome)){
            int position = assignerHash(nome);
            tabelinha1[position].remove(nome);
            positionsNoNo--;
        }
    }

    public boolean nomeExiste(String nome){
        int position = assignerHash(nome);
        return tabelinha1[position].contains(nome);
    }


    private int assignerHash(String nome) {
        final int VALOR_A = 97;
        int position = nome.toLowerCase().charAt(0);

        return position - VALOR_A;
    }

    public boolean hashCheio(){
        return positionsNoNo == TAMANHO;
    }

    public void showHash(){
        for (int i = 0; i < TAMANHO; i++) {
            if(!tabelinha1[i].isEmpty()){
                System.out.println(tabelinha1[i]);
            }
        }

    }
}
