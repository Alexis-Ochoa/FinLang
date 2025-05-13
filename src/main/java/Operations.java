public class Operations {
    public void plus(int... numbers){
        int total = 0;
        for (int n:numbers){
            total += n;
        }
        System.out.println("La suma es "+ total);
    }

    public void minus(int... numbers){
        int total = 0;
        for (int n:numbers){
            total -= n;
        }
        System.out.println("La resta es "+ total);
    }

    public void multiply(int... numbers){
        int total = 1;
        for (int n:numbers){
            total *= n;
        }
        System.out.println("La multiplicacion es "+ total);
    }

    public void divide(int... numbers){
        int total = 1;
        for (int n:numbers) {
            total /= n;
        }
        System.out.println("La division es "+ total);
    }

    public void taxes(int percentage, int amount){
        int decimals = percentage / 100;
        int taxes = amount * decimals;
        System.out.println("Los impuestos de " + amount + "son ");
    }
}
