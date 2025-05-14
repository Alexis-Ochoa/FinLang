import java.util.ArrayList;

public class Operations {
    public static void plus(ArrayList<Double> numbers){
        double total = 0;
        for (double n:numbers){
            total += n;
        }
        System.out.println("La suma es "+ total);
    }

    public static void minus(ArrayList<Double> numbers){
        double total = 0;
        for (double n:numbers){
            total -= n;
        }
        System.out.println("La resta es "+ total);
    }

    public static void times(ArrayList<Double> numbers){
        double total = 1;
        for (double n:numbers){
            total *= n;
        }
        System.out.println("La multiplicacion es "+ total);
    }

    public static void divide(ArrayList<Double> numbers){
        double total = 1;
        for (double n:numbers) {
            total /= n;
        }
        System.out.println("La division es "+ total);
    }

    public static void iva(double amount){
        double taxes = amount * 0.16;
        double total = taxes+amount;
        System.out.println("El IVA de " + amount + "son " + taxes + ". Dando un total de "+ total);
    }

    public static void isn(double amount){
        double taxes = amount * 0.03;
        double total = taxes+amount;
        System.out.println("El ISN de " + amount + "son " + taxes + ". Dando un total de " + total);
    }

    public static void ish(double amount){
        double taxes = amount * 0.03;
        double total = taxes+amount;
        System.out.println("El ISH de " + amount + "son " + taxes + ". Dando un total de " + total);
    }

    public static void percentage (double amount, double percentage){
        double decimal = percentage / 100;
        double total = amount * decimal;
        System.out.println("El " + percentage + "% de " + amount + " es " + total);
    }
}
