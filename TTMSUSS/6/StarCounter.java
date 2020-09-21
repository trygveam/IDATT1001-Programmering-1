import java.util.HashMap;
import java.util.Map;

public class StarCounter {
    java.util.Random random = new java.util.Random();
    int[] list = new int[10];

    public void generateNumbers(int amount){
        for (int i = 0; i < amount; i++) {
            int num = random.nextInt(10);
            list[num]+=1;
        }
    }

    public void printResult(){
        for (int i = 0; i <10 ; i++) {
           long temp = Math.round((float)list[i]/10f);
           StringBuilder spaces = new StringBuilder();
           for (int j = 0 ; j < temp ; j++) spaces.append("*");
           System.out.println(i + " : " + list[i] + " : " + temp*10 + " : " + temp + " : " +spaces);
       }
    }


    public static void main(String[] args) {
        StarCounter sc = new StarCounter();
        sc.generateNumbers(1000);
        sc.printResult();
    }
}
