import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class PrimeNumFinder {


    public static void main(String[] args) {
        PrimeNumFinder pm = new PrimeNumFinder();
        pm.checkPrimeNumber();
    }

    public void checkPrimeNumber() {
        String input = showInputDialog(null, "Skriv inn primtall: ");
        while (!input.isEmpty()) {

            int input_number = Integer.parseInt(input);
            boolean primtall = true;
            for (int i = 2; i < input_number; i++) {
                if (input_number % i == 0) {
                    primtall = false;
                    break;
                }
            }
            showMessageDialog(null, primtall ? input + " er et primtall" : input + " er ikke primtall");
            input = showInputDialog(null, "Skriv inn primtall: ");
        }


    }

}