public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *  If the denominator is negative, negate both numerator and denominator
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored! 
    if (deno == 0) {
      this.numerator = 0;
      this.denominator = 1;
    } else if(deno < 0){
      this.numerator = -1 * nume;
      this.denominator = -1 * deno;
    } else {
      this.numerator = nume;
      this.denominator = deno;
    }
  }

  public double getValue(){
    return 0.0;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return this.numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return this.denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return new RationalNumber(this.denominator, this.numerator);
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    if (this.numerator == other.getNumerator() && this.denominator == other.getDenominator()) {
      return true;
    }
    return false;
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    return this.numerator + "/" + this.denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    http://sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
    if (a < b) {
      int temp = a;
      a = b;
      b = temp;
    }
    while(a % b != 0) {
      int r = a % b;
      a = b;
      b = r;
    }
    return b;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int gcf = gcd(this.numerator, this.numerator);
    this.numerator = this.numerator/gcf;
    this.denominator = this.denominator/gcf;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    int nume = this.numerator * other.getNumerator();
    int denu = this.denominator * other.getDenominator();
    int gcf = gcd(nume, denu);
    RationalNumber res = new RationalNumber(nume / gcf, denu / gcf);
    return res;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return null;
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    return null;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    return null;
  }
} 