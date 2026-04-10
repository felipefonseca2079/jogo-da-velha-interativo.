import java.util.Scanner;
import java.util.Random;

class JogoDaVelha {
    public static void main(String args[]) {
        Scanner leitor = new Scanner(System.in);
        Random random = new Random();
        Tabuleiro tabuleiro = new Tabuleiro();

        System.out.println("Bem-vindo ao Jogo da Velha!");
        System.out.print("Escolha seu símbolo (X ou O): ");
        char simboloHumano = leitor.next().toUpperCase().charAt(0);
        char simboloBot = (simboloHumano == 'X') ? 'O' : 'X';

        Jogador jogador1 = new Jogador("Humano", simboloHumano);
        Jogador jogador2 = new Jogador("Computador", simboloBot);

        Jogador atual = jogador1;

        while (true) {
            System.out.println(" Vez de: " + atual.getNome());
            int linha, coluna;

            if (atual == jogador1) {
                System.out.print(" Digite a linha (0-2): ");
                linha = leitor.nextInt();
                System.out.print(" Digite a coluna (0-2): ");
                coluna = leitor.nextInt();
            } else {
                linha = random.nextInt(3);
                coluna = random.nextInt(3);
            }

            if (tabuleiro.jogar(atual.getSimbolo(), linha, coluna)) {
                tabuleiro.mostrar();
                
                if (tabuleiro.haUmVencedor()) {
                    System.out.println("O " + atual.getNome() + " jogo bem!");
                    break;
                }
                if (tabuleiro.todasAsCasasPreenchidas()) {
                    System.out.println(" O jogo terminou empatado, nem fede nem cheira.");
                    break;
                }

                atual = (atual == jogador1) ? jogador2 : jogador1;
            } else {
                if (atual == jogador1) {
                    System.out.println(" Posição incorreta meu fih! faça de novo, faça.");
                }
            }
        }
        leitor.close();
        System.out.println("Feito por Felipe Fonseca Sanches");

    }
}
