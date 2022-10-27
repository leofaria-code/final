import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class FinalCode {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        System.setProperty("sun.jnu.encoding", "UTF-8");
        System.setProperty("file.encoding", "UTF-8");
        
        Scanner ent = new Scanner(System.in);
    
        System.out.print("\nQuantos valores serão operados?\n");
        int tamanho = getIntNumber(ent);
        System.out.printf("\nSerão operados %s valores.\n", tamanho);
    
        double[] valores = new double[tamanho];
    
        for (int i = 0; i < valores.length; i++) {
            int j = i + 1;
            System.out.println("\nQual é o " + j + "° valor?");
            valores[i] = getDoubleNumber(ent);
        }
    
        double media = calculaMedia(valores);
        System.out.println("\nA média dos " + tamanho + " valores é " + media);

        System.out.println(LocalDate.now().getDayOfWeek() + ", " + LocalDate.now() + ", " + LocalTime.now());
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
    static double getDoubleNumber(Scanner input) {
        try {
            System.out.print("Digite um NÚMERO (se for necessário, use vírgula para decimais): ");
            return input.nextDouble();
        } catch (InputMismatchException e) {
            System.out.print("\nO valor digitado não é NÚMERO!\n");
            input.nextLine();
            return getDoubleNumber(input);
        }
    }
    private static double calculaMedia(double[] valores){
        double soma = 0;
        for (double i : valores) {
            soma += i;
        }
//        for (int i = 0; i < valores.length; i++) {
//            soma += valores[i];
//        }
        return soma / valores.length;
    }
}