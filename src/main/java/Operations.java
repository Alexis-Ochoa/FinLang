import java.util.ArrayList;

public class Operations {
    public static boolean plus(ArrayList<Double> numbers) {
        if (numbers.size() < 2) {
            System.out.println("Error: Se necesitan al menos dos números para sumar");
            return false;
        }
        double total = numbers.get(0);  // Empezamos con el primer número
        for (int i = 1; i < numbers.size(); i++) {
            total += numbers.get(i);
        }
        System.out.println("La suma es " + total);
        return true;
    }

    public static boolean minus(ArrayList<Double> numbers) {
        if (numbers.size() < 2) {
            System.out.println("Error: Se necesitan al menos dos números para restar");
            return false;
        }
        double total = numbers.get(0);  // Empezamos con el primer número
        for (int i = 1; i < numbers.size(); i++) {
            total -= numbers.get(i);
        }
        System.out.println("La resta es " + total);
        return true;
    }

    public static boolean times(ArrayList<Double> numbers) {
        if (numbers.size() < 2) {
            System.out.println("Error: Se necesitan al menos dos números para multiplicar");
            return false;
        }
        double total = numbers.get(0);  // Empezamos con el primer número
        for (int i = 1; i < numbers.size(); i++) {
            total *= numbers.get(i);
        }
        System.out.println("La multiplicación es " + total);
        return true;
    }

    public static boolean divide(ArrayList<Double> numbers) {
        if (numbers.size() < 2) {
            System.out.println("Error: Se necesitan al menos dos números para dividir");
            return false;
        }
        double total = numbers.get(0);  // Empezamos con el primer número
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) == 0) {
                System.out.println("Error: División por cero");
                return false;
            }
            total /= numbers.get(i);
        }
        System.out.println("La división es " + total);
        return true;
    }

    public static boolean iva(double amount){
        double taxes = amount * 0.16;
        double total = taxes+amount;
        System.out.println("El IVA de " + amount + " son " + taxes + ". Dando un total de "+ total);
        return true;
    }

    public static boolean isr(double salary){
        double[][] tarifas = {
                {0.01, 746.04, 0.00, 1.92},
                {746.05, 6332.05, 14.32, 6.40},
                {6332.06, 11128.01, 371.83, 10.88},
                {11128.02, 12935.82, 893.63, 16.00},
                {12935.83, 15487.71, 1182.88, 17.92},
                {15487.72, 31236.49, 1640.18, 21.36},
                {31236.50, 49233.00, 5004.12, 23.52},
                {49233.01, 93993.90, 9236.89, 30.00},
                {93993.91, 125325.20, 22665.17, 32.00},
                {125325.21, 375975.61, 32691.18, 34.00},
                {375975.62, Double.MAX_VALUE, 117912.32, 35.00}
                };

        for (double[] tarifa : tarifas) {
            double limiteInferior = tarifa[0];
            double limiteSuperior = tarifa[1];
            double cuotaFija = tarifa[2];
            double porcentajeExcedente = tarifa[3];

            if (salary >= limiteInferior && salary <= limiteSuperior) {
                double excedente = salary - limiteInferior;
                System.out.println("El ISR para " + salary + " es " + (cuotaFija + (excedente * (porcentajeExcedente / 100))));
                return true;
            }
        }
        throw new IllegalArgumentException("Ingreso fuera de los rangos definidos.");
    }

    public static boolean isan(double price){
        double[][] tarifas = {
                {0.01, 370741.94, 0.00, 2.0},
                {370741.95, 444890.26, 7414.71, 5.0},
                {444890.27, 519038.86, 11122.30, 10.0},
                {519038.87, 667335.21, 18537.12, 15.0},
                {667335.22, Double.MAX_VALUE, 40718.53, 17.0}
        };

        double impuesto = 0.0;

        for (double[] tarifa : tarifas) {
            double limiteInferior = tarifa[0];
            double limiteSuperior = tarifa[1];
            double cuotaFija = tarifa[2];
            double porcentajeExcedente = tarifa[3];

            if (price >= limiteInferior && price <= limiteSuperior) {
                double excedente = price - limiteInferior;
                impuesto = cuotaFija + (excedente * (porcentajeExcedente / 100));
                break;
            }
        }

        // Aplicar descuento si el precio supera $1,023,744.62
        if (price > 1023744.62) {
            double descuento = (price - 1023744.62) * 0.07;
            impuesto -= descuento;
        }
        System.out.println("El ISAN del vehículo que costó $" + price + " es " + impuesto);
        return true;
    }

    public static boolean isai(double maxValue){
        double[][] tarifas = {
                {0.12, 123988.81, 300.60, 0.01537},
                {123988.82, 198382.03, 1803.36, 0.03272},
                {198382.04, 297572.76, 3723.46, 0.04276},
                {297572.77, 595145.67, 7068.20, 0.04988},
                {595145.68, 1487864.15, 18774.71, 0.05543},
                {1487864.16, 2975728.34, 57786.53, 0.06054},
                {2975728.35, 5732476.11, 128817.18, 0.06567},
                {5732476.12, 14928323.92, 271589.16, 0.06829},
                {14928323.93, 27529938.63, 766209.23, 0.06888},
                {27529938.64, 55059877.21, 1451523.25, 0.06950},
                {55059877.22, Double.MAX_VALUE, 2960439.21, 0.07551}
        };

        for (double[] rango : tarifas) {
            double limiteInferior = rango[0];
            double limiteSuperior = rango[1];
            double cuotaFija = rango[2];
            double factor = rango[3];

            if (maxValue >= limiteInferior && maxValue <= limiteSuperior) {
                double excedente = maxValue - limiteInferior;
                System.out.println("El ISAI de " + maxValue + " es " + (cuotaFija + (excedente * factor)));
                return true;
            }
        }
        throw new IllegalArgumentException("Precio fuera de los rangos definidos.");
    }

    public static boolean isn(double amount){
        double taxes = amount * 0.03;
        double total = taxes+amount;
        System.out.println("El ISN de " + amount + " son " + taxes + ". Dando un total de " + total);
        return true;
    }

    public static boolean ish(double amount){
        double taxes = amount * 0.03;
        double total = taxes+amount;
        System.out.println("El ISH de " + amount + " son " + taxes + ". Dando un total de " + total);
        return true;
    }

    public static boolean margen_ganancia(double salesA, double salesC){
        double margen = salesA - salesC;
        System.out.println("El margen de ganacia es " + margen);
        return true;
    }

    public static boolean percentage (double amount, double percentage){
        double decimal = percentage / 100;
        double total = amount * decimal;
        System.out.println("El " + percentage + "% de " + amount + " es " + total);
        return true;
    }

    private static void throwIfInvalidOperation(boolean condition, String message) {
        if (!condition) {
            throw new RuntimeException(message);
        }
    }

}
