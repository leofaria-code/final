import java.util.InputMismatchException;
import java.util.Scanner;

public class CodingTankFinal {
    public static void main(String[] args) {
        System.out.println("\nHello world!");
    
        Scanner input = new Scanner(System.in);
    
        System.out.print("\nQuantos valores serão operados?\n");
        int tamanho = getIntNumber(input);
        System.out.printf("\nSerão operados %s valores.\n", tamanho);
    
        double[] valores = new double[tamanho];
        for (int i = 0; i < valores.length; i++) {
            int j = i + 1;
            System.out.println("\nQual é o " + j + "° valor?");
            valores[i] = getDoubleNumber(input);
        }
    
        System.out.print("\nQual o tipo de média deverá ser calculada?\n");
        String tipoDeMedia = input.next();
        System.out.println("\nA média " + tipoDeMedia + "dos " + tamanho + " valores será calculada.");
        
        double mediaAritmetica = calculaMediaAritmetica(valores);
        System.out.println("\nA média aritmética dos " + tamanho + " valores é " + mediaAritmetica);

        double mediaHarmonica = calculaMediaHarmonica(valores);
        System.out.println("\nA média harmônica dos " + tamanho + " valores é " + mediaHarmonica);
        
        System.out.println("\nA média " + tipoDeMedia + " dos " + tamanho + " valores é " + mediaAritmetica);
        System.out.println("\nA média " + tipoDeMedia + " dos " + tamanho + " valores é " + mediaHarmonica);
        
        input.close();
    }
    static int getIntNumber(Scanner input) {
        try {
            System.out.print("Digite um NÚMERO INTEIRO: ");
            return input.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("\nO valor digitado não é NÚMERO INTEIRO!\n");
            input.nextLine();
            return getIntNumber(input);
        }
    }
    public static double getDoubleNumber(Scanner input) {
        try {
            System.out.print("Digite um NÚMERO: ");
            return input.nextDouble();
        } catch (InputMismatchException e) {
            System.out.print("\nO valor digitado não é NÚMERO!\n");
            input.nextLine();
            return getDoubleNumber(input);
        }
    }
    public static double calculaMediaAritmetica(double[] valores){
        double soma = 0;
        for (double i : valores) {
            soma += i;
        }
        return soma / valores.length;
    }
    public static double calculaMediaHarmonica(double[] valores){
        double somaDosInversos = 0;
        for (int i = 0; i < valores.length; i++) {
            somaDosInversos += 1 / valores[i];
        }
        return valores.length / somaDosInversos;
    }
}