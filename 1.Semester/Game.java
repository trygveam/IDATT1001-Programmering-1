public class Game {
    public static void main(String[] args) {
        Player p1 = new Player();
        Player p2 = new Player();
        int round = 0;
        while (!p1.isFinished() && !p2.isFinished()){
            round++;
            p1.throwDice();
            p2.throwDice();
            System.out.println("Round: " + round + " , P1:" + p1.getSumScore() + ", P2: " + p2.getSumScore()) ;
        }
        System.out.println(p1.isFinished() ? "Player 1 is finished" : "Player 2 is finished");

    }
}
