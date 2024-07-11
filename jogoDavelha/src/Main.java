

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        //Criar um objeto Scanner para ler a entrada do usuário
        
        char[][] jogoVelha = new char [3] [3];
        // Cria um tabuleiro 3x3 para o jogo da velha
        
        System.out.println("Jogador 1 = X");
        System.out.println("Jogador 2 = O");

        boolean ganhou = false; // Variável para controlar se alguém ganhou o jogo
        int jogada = 1; // Contador de jogadas
        char sinal;  // Variável para armazenar o símbolo do jogador atual
        int linha = 0, coluna = 0; // Variáveis para armazenar a linha e coluna escolhidas pelo jogador

        while (!ganhou){ //Loop principal que continua até que alguém ganhe

            if(jogada % 2==1){// Jogador 1 joga nas jogadas ímpares

                System.out.println("Vez do jogador 1. Escolha linha e coluna (1-3)");
                sinal = 'X';
            } else { // Jogador 2 joga nas jogadas pares
                System.out.println("Vez do jogador 2. Escolha linha e coluna (1-3)");
                sinal = 'O';
            }

            boolean linhaValida = false;
            while (!linhaValida){ // Verifica se a linha escolhida é válida
                System.out.println("Entre com a linha (1,2 ou 3)");
                linha = scanner.nextInt();
                if (linha >=1 && linha <=3) {
                    linhaValida = true;
                } else {
                    System.out.println("Entrda inválida, tente novamente");
                }
            }

            boolean colunaValida = false;
            while (!colunaValida){ // Verifica se a coluna escolhida é válida
                System.out.println("Entre com a coluna (1,2 e 3)");
                coluna = scanner.nextInt();
                if (coluna >=1 && coluna<=3) {
                    colunaValida = true;
                } else {
                    System.out.println("Entrda inválida, tente novamente");
                }
            }

            linha--; // Ajusta a linha para índice de array
            coluna--; // Ajusta a coluna para índice de array
            if (jogoVelha[linha] [coluna] == 'X' || jogoVelha[linha][coluna] == 'O'){
                System.out.println("Posição já usada, tente novamente");
            } else {//jogada válida
                jogoVelha[linha][coluna] = sinal;
                jogada++;
            }

            //imprimir tabuleiro
            for(int i = 0; i<jogoVelha.length; i++){
                for (int j = 0; j<jogoVelha[i].length;j++){
                    System.out.print(jogoVelha[i][j] + "|");
                }
                System.out.println();
            }

            //verifica se tem ganhador
            if((jogoVelha[0][0]== 'X' && jogoVelha[0][1]== 'X' && jogoVelha[0][2]== 'X') ||       //linha 1
                    (jogoVelha[1][0]== 'X' && jogoVelha[1][1]== 'X' && jogoVelha[1][2]== 'X') ||  //linha 2
                    (jogoVelha[2][0]== 'X' && jogoVelha[2][1]== 'X' && jogoVelha[2][2]== 'X') ||  //linha 3
                    (jogoVelha[0][0]== 'X' && jogoVelha[1][0]== 'X' && jogoVelha[2][0]== 'X') ||  //coluna 1
                    (jogoVelha[0][1]== 'X' && jogoVelha[1][1]== 'X' && jogoVelha[2][2]== 'X') ||  //coluna 2
                    (jogoVelha[0][2]== 'X' && jogoVelha[1][2]== 'X' && jogoVelha[2][2]== 'X') ||  //coluna 3
                    (jogoVelha[2][0]== 'X' && jogoVelha[1][1]== 'X' && jogoVelha[0][2]== 'X') ||  //diagonal
                    (jogoVelha[0][0]== 'X' && jogoVelha[1][1]== 'X' && jogoVelha[2][2]== 'X')){   //diagonal
                ganhou = true;
                System.out.println("Parabéns, jogador 1 ganhou!");
            } else if ((jogoVelha[0][0]== 'O' && jogoVelha[0][1]== 'O' && jogoVelha[0][2]== 'O') || //linha 1
                    (jogoVelha[1][0]== 'O' && jogoVelha[1][1]== 'O' && jogoVelha[1][2]== 'O') ||    //linha 2
                    (jogoVelha[2][0]== 'O' && jogoVelha[2][1]== 'O' && jogoVelha[2][2]== 'O') ||    //linha 3
                    (jogoVelha[0][0]== 'O' && jogoVelha[1][0]== 'O' && jogoVelha[2][0]== 'O') ||    //coluna 1
                    (jogoVelha[0][1]== 'O' && jogoVelha[1][1]== 'O' && jogoVelha[2][2]== 'O') ||    //coluna 2
                    (jogoVelha[0][2]== 'O' && jogoVelha[1][2]== 'O' && jogoVelha[2][2]== 'O') ||    //coluna 3
                    (jogoVelha[2][0]== 'O' && jogoVelha[1][1]== 'O' && jogoVelha[0][2]== 'O') ||  //diagonal
                    (jogoVelha[0][0]== 'O' && jogoVelha[1][1]== 'O' && jogoVelha[2][2]== 'O')){     //diagonal
                ganhou = true;
                System.out.println("Parabéns, jogador 2 ganhou!");
            } else if (jogada > 9) {
                ganhou = true;
                System.out.println("Ninguém ganhou essa partida");
            }
        }
    }
}
