public class Player {
    java.util.Random dice = new java.util.Random();
    private int sumScore;
    public void throwDice(){
        int num = dice.nextInt(6) + 1;
        if(sumScore + num <= 100){
            if(num == 1){
                sumScore = 0;
            }else{
                sumScore += num;
            }
        }
    }
    public boolean isFinished(){
        return sumScore == 100;
    }
    public int getSumScore() {
        return sumScore;
    }
}
