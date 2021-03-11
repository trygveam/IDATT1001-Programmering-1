import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TextAnalyzer {
    int[] list = new int[30];
    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public void analyze(String string){
        for (int i = 0; i < string.length(); i++) {
            char character = Character.toLowerCase(string.charAt(i));
            int ascii = (int) character;
            if(ascii == 230){
                list[26]+=1;
            }
            else if(ascii == 248){
                list[27]+=1;
            }
            else if(ascii == 220 ){
                list[28]+=1;
            }
            else if(ascii-97 > 25 || ascii-97 < 0){
                list[29] +=1;
            }
            else{
                list[ascii-97] +=1;
            }
        }
    }

    public void printList(){
        for (int i = 0; i <list.length; i++) {
            System.out.println( i + " : " + (char) (i +97) +  " : " + list[i]);
        }
    }

    public int differentLetters(){
        int temp = 0;
        for (int i = 0; i < 29; i++) {
            if(list[i] > 0){
                temp+=1;
            }
        }return temp;
    }

    public int totalLetters(){
        int temp = 0;
        for (int i = 0; i < 29; i++) {
                temp+=list[i];
        }return temp;
    }

    public String percentageLetters(){
        float f = (float) (list[29] * 100)/ (totalLetters() + list[29]);
        return String.format("%.2f", f) + "%";

    }

    public int instanceOfLetter(char c){
        return list[97- (int) c];
    }

    public String mostLetterInString(){
        int maxValue = 0;
        int posValue = 0;
        for (int i = 0; i < list.length-1; i++) {
            if(list[i] > maxValue) {
                maxValue = list[i];
                posValue = i;
            }
        }
        String s = "";
        for (int i = 0; i < list.length; i++) {
            if(list[i] == maxValue){
                s += alphabet[i] + "\n";
            }
        }

        return s;
    }

    public static void main(String[] args) {
        TextAnalyzer tx = new TextAnalyzer();
        tx.analyze("aaaaaaaafsdfsdfsdfsdfsdfsdfsdf æøå");
        tx.printList();
        System.out.println(tx.totalLetters());
        System.out.println(tx.differentLetters());
        System.out.println(tx.percentageLetters());
        System.out.println(tx.instanceOfLetter('a'));
        System.out.println(tx.mostLetterInString());
    }
}
