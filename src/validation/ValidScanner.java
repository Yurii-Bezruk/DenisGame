package validation;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 * This class is for using utility Scanner object, with which you can perform special
 * actions during scanning from the console or other source (just need to add specific
 * Scanner constructor). {@link java.util.Scanner} class is final, so this class is
 * non-professional "extending" of it using delegation technique. All scanner methods
 * are "implemented", some are "overridden", now there are:<br>
 * nextInt()<br>
 * nextLine()<br>
 *  
 * @author Yurii Bezruk
 * @version 1.0
 * @see java.util.Scanner
 */
public class ValidScanner /*extends java.util.Scanner*/{
	/**Scanner object to be delegated*/
	private Scanner scanner;
	/**
	 * VALID_MIN & VALID_MAX fields using for establishing validation during scanning 
	 * some numbers (low and high limit of scanning). In this version, they used for 
	 * method nextInt().
	 */
	private double VALID_MIN = Double.MIN_VALUE;
	private double VALID_MAX = Double.MAX_VALUE;
	
	public ValidScanner(Readable source){
		scanner = new Scanner(source);		
	}
	public ValidScanner(InputStream source){
		scanner = new Scanner(source);		
	}
	
	/**
	 * Returns current high limit of validation during scanning numbers.
	 * @return validation high limit.
	 */
	public double getValidMax() {
		return VALID_MAX;
	}
	
	/**
	 * Sets high limit of validation during scanning numbers by given value.
	 * @param validMax new validation high limit to be set.
	 */
	public void setValidMax(double validMax) {
		VALID_MAX = validMax;
	}
	
	/**
	 * Returns current low limit of validation during scanning numbers.
	 * @return validation low limit.
	 */
	public double getValidMin() {
		return VALID_MIN;
	}
	
	/**
	 * Sets low limit of validation during scanning numbers by given value.
	 * @param validMin new validation low limit to be set.
	 */
	public void setValidMin(double validMin) {
		VALID_MIN = validMin;
	}
	
	/**---Extended and overridden Scanner methods---*/
	
	public void close() {
		scanner.close();
	}
	public Pattern delimiter() {
		return scanner.delimiter();
	}
	public String findInLine(Pattern pattern) {
		return scanner.findInLine(pattern);
	}
	public String findInLine(String pattern) {
		return scanner.findInLine(pattern);
	}
	public String findWithinHorizon(Pattern pattern, int horizon) {
		return scanner.findWithinHorizon(pattern, horizon);		
	}
	public String findWithinHorizon(String pattern, int horizon) {
		return scanner.findWithinHorizon(pattern, horizon);		
	}
	public boolean hasNext() {
		return scanner.hasNext();
	}
	public boolean hasNext(Pattern pattern) {
		return scanner.hasNext(pattern);
	}
	public boolean hasNext(String pattern) {
		return scanner.hasNext(pattern);
	}
	public boolean hasNextBigDecimal() {
		return scanner.hasNextBigDecimal();
	}
	public boolean hasNextBigInteger() {
		return scanner.hasNextBigInteger();
	}
	public boolean hasNextBigInteger(int radix) {
		return scanner.hasNextBigInteger(radix);
	}
	public boolean hasNextBoolean() {
		return scanner.hasNextBoolean();
	}
	public boolean hasNextByte() {
		return scanner.hasNextByte();
	}
	public boolean hasNextByte(int radix) {
		return scanner.hasNextByte(radix);
	}
	public boolean hasNextDouble() {
		return scanner.hasNextDouble();
	}
	public boolean hasNextFloat() {
		return scanner.hasNextFloat();
	}
	public boolean hasNextInt() {
		return scanner.hasNextInt();
	}
	public boolean hasNextInt(int radix) {
		return scanner.hasNextInt(radix);
	}
	public boolean hasNextLine() {
		return scanner.hasNextLine();
	}
	public boolean hasNextLong() {
		return scanner.hasNextLong();
	}
	public boolean hasNextLong(int radix) {
		return scanner.hasNextLong(radix);
	}
	public boolean hasNextShort() {
		return scanner.hasNextShort();
	}
	public boolean hasNextShort(int radix) {
		return scanner.hasNextShort(radix);
	}
	public IOException ioException() {
		return scanner.ioException();
	}
	public Locale locale() {
		return scanner.locale();
	}
	public MatchResult match() {
		return scanner.match();
	}
	public String next() {
		return scanner.next();
	}
	public String next(Pattern pattern) {
		return scanner.next(pattern);
	}
	public String next(String pattern) {
		return scanner.next(pattern);
	}
	public BigDecimal nextBigDecimal() {
		return scanner.nextBigDecimal();
	}
	public BigInteger nextBigInteger() {
		return scanner.nextBigInteger();
	}
	public BigInteger nextBigInteger(int radix) {
		return scanner.nextBigInteger(radix);
	}
	public boolean nextBoolean() {
		return scanner.nextBoolean();
	}
	public byte nextByte() {
		return scanner.nextByte();
	}
	public byte nextByte(int radix) {
		return scanner.nextByte(radix);
	}
	public double nextDouble() {
		return scanner.nextDouble();
	}
	public float nextFloat() {
		return scanner.nextFloat();
	}
	
	/**
	 * {@link Scanner#nextInt()} method was overridden. Now it using validation limits, and ask you
	 * to try entering a number again if number is smaller then VALID_MIN or bigger then
	 * VALID_MAX or entered symbol is not a number (catching {@link InputMismatchException})
	 * 
	 * @see java.util.Scanner#nextInt()
	 * @see java.util.InputMismatchException
	 */
	public int nextInt() {
		int number;
		do {
			try {
				number = scanner.nextInt();
				if(number >= VALID_MIN && number <= VALID_MAX)
					break;
				else
					System.out.println("Wrong! Try again:");
			}catch(InputMismatchException e) {
				scanner.next();
				System.out.println("Wrong! Try again:");
			}
		}while(true);
		return number;
	}
	public int nextInt(int radix) {
		return scanner.nextInt(radix);
	}
	
	/**
	 * This method returning result of second scanning line, skipping first. This is needed for
	 * cases, in which scanner was scanning message that was in other line, before needed one.
	 * 
	 * @return {@code String} object which represents second line of text, scanned by {@link Scanner#nextLine()}
	 * @see java.util.Scanner#nextLine()
	 */
	public String nextLine() {
		scanner.nextLine();
		return scanner.nextLine();
	}
	public long nextLong() {
		return scanner.nextLong();
	}
	public long nextLong(int radix) {
		return scanner.nextLong(radix);
	}
	public short nextShort() {
		return scanner.nextShort();
	}
	public short nextShort(int radix) {
		return scanner.nextShort(radix);
	}
	public int radix() {
		return scanner.radix();
	}
	public void remove() {
		scanner.remove();
	}
	public Scanner reset() {
		return scanner.reset();
	}
	public Scanner skip(Pattern pattern) {
		return scanner.skip(pattern);
	}
	public Scanner skip(String pattern) {
		return scanner.skip(pattern);
	}
	public String toString() {
		return scanner.toString();
	}
	public Scanner useDelimiter(Pattern pattern) {
		return scanner.useDelimiter(pattern);
	}
	public Scanner useDelimiter(String pattern) {
		return scanner.useDelimiter(pattern);
	}
	public Scanner useLocale(Locale locale) {
		return scanner.useLocale(locale);
	}
	public Scanner useRadix(int radix) {
		return scanner.useRadix(radix);
	}
}