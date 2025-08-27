
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
    private int tempoPerdidoCigarro;


    public void setCigarroPorDia(String CigarroPorDia) {
        this.cigarroPorDia = CigarroPorDia;
    }

    public String getCigarroPorDia() {
        return this.cigarroPorDia;
    }

    public void setTempo(String Tempo) {
        this.tempo = Tempo;
    }

    public String getTempo() {
        return this.tempo;
    }

    public void setTempoPerdidoCigarro() {
        this.tempoPerdidoCigarro = 600; // 10min em segundos é 600
    }

    public int getTempoPerdidoCigarro() {
        return this.tempoPerdidoCigarro;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando um objeto da classe Fumante
        Fumante fumante = new Fumante();

        System.out.print("Quantos cigarros você fuma por dia?:  ");
        fumante.setCigarroPorDia(scanner.nextLine());

        System.out.print("Quantos anos você fuma?:  ");
        fumante.setTempo(scanner.nextLine());

        String result = fumante.tempoVidaPerdido();

        System.out.println(result);


    }

    public String tempoVidaPerdido() {

        int resultFumar = this.fumar();

        int totalTempoPerdidoDias = resultFumar / 86400; // dividindo o valor por 86400, faz o resultado aparecer em dias
        int totalTempoPerdidoAnos = totalTempoPerdidoDias / 365; // dividindo os meses por 365, faz o resultado aparecer em anos

        if (totalTempoPerdidoAnos < 1) { // nessa linha eu verifico se o valor é menor que um ano
            // se o valor for menor que 1 ano retorna o resultado em meses
            return "Você perdeu " + totalTempoPerdidoDias + " dias de vida!";
        } else {
            // caso contrário retorna em anos
            return "Você perdeu " + totalTempoPerdidoAnos + " anos de vida!";
        }

    }

    public int fumar() {
        /*
         * Premissa: 1 Cigarro fumado = -10 mintutos de vida
         * 10 minutos = 600 segundos
         * 1 ano = 31556952 segundos
         * */

        int pCigarro = Integer.parseInt(this.getCigarroPorDia());
        int pTempo = Integer.parseInt(this.getTempo());

        int diasPorAno = 365;

        this.setTempoPerdidoCigarro();

        int totalDias = pTempo * diasPorAno;
        int totalCigarros = pCigarro * totalDias;

        return totalCigarros * this.getTempoPerdidoCigarro();
    }

}