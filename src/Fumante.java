
/*
* Máteria: Algoritmos e Estrutura de Dados
* Autor: Giovanny Leone
* Contato: https://giovannyleone.com
* -------
* Instituição de ensino: Faculdade Impacta de Tecnologia - FIT
* Site faculdade: https://www.impacta.edu.br/
* Atividade: Lista 01 aula 03 04 Java.pdf
* Número: 16
* Enunciado da atividade:
*
*
* [DESAFIO] Escreva um programa em Java para calcular a redução do tempo de vida de
  um fumante. Pergunte a quantidade de cigarros fumados por dias e quantos anos ele já
  fumou. Considere que um fumante perde 10 min de vida a cada cigarro. Calcule quantos
  dias de vida um fumante perderá e exiba o total em dias.
*
* Link do PDF: https://drive.google.com/file/d/1wnoEZDHMrpShXAZMpzHXE1F14pB4g7SV/view
*
* */

import java.util.Scanner;

public class Fumante {

    private String cigarroPorDia;
    private String tempo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando um objeto da classe Fumante
        Fumante fumante = new Fumante();

        System.out.print("Quantos cigarros você muda por dia?:  ");
        fumante.cigarroPorDia = scanner.nextLine();

        System.out.print("Quantos anos você fuma?:  ");
        fumante.tempo = scanner.nextLine();

        int result = tempoVidaPerdido(fumante.cigarroPorDia, fumante.tempo);

        int resultAno = result / 365;

        if (resultAno < 1){
            System.out.println("Você perdeu " + result + " dias de vida");
        } else {
            System.out.println("Você perdeu " + resultAno + " anos de vida");
        }

    }

    public static int tempoVidaPerdido(String _pCigarro, String _pTempo) {
        /*
        * Premissa: 1 Cigarro fumado = -10 mintutos de vida
        * 10 minutos = 600 segundos
        * 1 ano = 31556952 segundos
        * */

        int pCigarro = Integer.parseInt(_pCigarro);
        int pTempo = Integer.parseInt(_pTempo);


        int tempoPerdido1Cigarro = 600; // 10min em segundos
        int diasPorAno = 365;

        int totalDias = pTempo * diasPorAno;
        int totalCigarros = pCigarro * totalDias;
        int totalTempoPerdido = totalCigarros * tempoPerdido1Cigarro;


        return totalTempoPerdido / 86400;


    }

}