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

public class ValidScanner{
	private Scanner scanner;
	private double VALID_MIN = Double.MIN_VALUE;
	private double VALID_MAX = Double.MAX_VALUE;
	
	public ValidScanner(Readable source){
		scanner = new Scanner(source);		
	}
	public ValidScanner(InputStream source){
		scanner = new Scanner(source);		
	}
	public double getValidMax() {
		return VALID_MAX;
	}	
	public void setValidMax(double validMax) {
		VALID_MAX = validMax;
	}	
	public double setValidMin() {
		return VALID_MIN;
	}
	public void setValidMin(double vALID_MIN) {
		VALID_MIN = vALID_MIN;
	}
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
