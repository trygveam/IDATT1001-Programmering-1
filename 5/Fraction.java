public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if(denominator == 0){
            throw new IllegalArgumentException("cant be zero");
        }
        this.denominator = denominator;
        this.numerator = numerator;
    }
    public Fraction(int numerator){
        this.numerator = numerator;
        this.denominator = 1;
    }
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void addition(int numerator, int denominator){
        this.numerator = (this.numerator * denominator) + (this.denominator * numerator);
        this.denominator = this.denominator * denominator;
    }

    public void subtraction(int numerator, int denominator){
        this.numerator = (this.numerator * denominator) - (this.denominator * numerator);
        this.denominator = this.denominator * denominator;
    }

    public void multiplication(int numerator, int denominator){
        this.numerator = this.numerator * numerator;
        this.denominator = this.denominator * denominator;
    }

    public void division(int numerator, int denominator){
        this.numerator = this.numerator * denominator;
        this.denominator = this.denominator * numerator;
    }

    public void reduceFraction()
    {
        int d;
        d = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / d;
        this.denominator = this.denominator / d;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b,a%b);
    }

    public static void main(String[] args) {
        Fraction f = new Fraction(1,4);
        f.addition(3,8);
        System.out.println(f.getNumerator() + " " + f.getDenominator());
        f.reduceFraction();
        System.out.println(f.getNumerator() + " " + f.getDenominator());
    }
}
