public class MainVivi1 {

    //O conteúdo daqui pode ser facilmente modelado para as 3 atividades

    //Métodos que podem ser chamados:
    //hashVivi
    // | - adicionarNome(String nome) = adiciona um nome
    // | - hashCheio() = verifica o se está cheio
    // | - nomeExiste(String nome) = verifica se o nome existe
    // | - nomeExplodir(String nome) = deleta o nome
    // | - showHash() = mostra a tabela

    public static void main(String[] args) {

        final int TAMANHO = 26;

        HashVivi hashVivi = new HashVivi(TAMANHO);

        hashVivi.adicionarNome("Alpha");
        hashVivi.adicionarNome("Alpha");
        hashVivi.adicionarNome("Alabama");
        hashVivi.adicionarNome("Beta");
        hashVivi.adicionarNome("Gama");
        hashVivi.adicionarNome("Sigma");

        System.out.print("\n");

        System.out.println("Está cheio? : "+hashVivi.hashCheio());
        System.out.println("Nome existe? (Beta) : "+hashVivi.nomeExiste("Beta"));
        System.out.println("Kaboom (Gama)");
        hashVivi.nomeExplodir("Gama");


        System.out.print("\n");

        hashVivi.showHash();
    }
}
