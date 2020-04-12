package assignment2;

/**
 * BlumBlumShub generates a series of random integers using the formula x_n+1 =
 * (x_n * x_n) mod M in which M = p*q (large prime integers)
 */
public class BlumBlumShub {

	long p;
	long q;
	long seed;
	long M;

	/**
	 * Default Constructor
	 */
	BlumBlumShub() {
		seed = 45;
		p = 1091;
		q = 1109;
		M = p * q;
	}

	/**
	 * Override Constructor
	 * 
	 * @param num
	 * @param p
	 * @param q
	 */
	BlumBlumShub(long num, long p, long q) {
		this();
		if (num == 1 | num == 0 | gcd(p * q, num) != 1 | !isPrime(p) | !isPrime(q))
			System.out.println("Failed to set seed. Seed should be prime number!");
		else {
			this.seed = num;
			this.p = p;
			this.q = q;
			this.M = p * q;
		}
	}

	public void changeParam(long p, long q) {
		this.p = p;
		this.q = q;
		this.M = p * q;
	}

	public void changeSeed(long seed) {
		this.seed = seed;
	}

	/**
	 * Greatest Common Divisor
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static long gcd(long a, long b) {
		long remainder = 1;
		if (a > b) {
			while (remainder != 0) {
				remainder = a % b;
				a = b;
				b = remainder;
			}
			return a;
		} else {
			while (remainder != 0) {
				remainder = b % a;
				b = a;
				a = remainder;
			}
			return b;
		}
	}

	/**
	 * Check if n is a prime number
	 * 
	 * @param n
	 * @return
	 */
	static boolean isPrime(long n) {
		// Corner case
		if (n <= 1)
			return false;

		// Check from 2 to n-1
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;

		return true;
	}

	/**
	 * Generate the next random number using the Blum Blum Shub algorithm
	 * 
	 * @param seed, the previous number or the initial seed
	 * @return the next random number
	 */
	public long generateNext(long seed) {
		return (seed * seed) % M;
	}

	/**
	 * Print information about the settings
	 */
	public void printInfo() {
		System.out.println(
				"Test BBS with seed = " + seed + " and other parameters: p = " + p + " q = " + q + " M = " + M);
	}

	/**
	 * Test the algorithm by generating 1000 numbers
	 * 
	 * @return array of random numbers
	 */
	public long[] test() {
		long[] lcg1000 = new long[1000];
		lcg1000[0] = seed;
		for (int i = 1; i < 1000; i++)
			lcg1000[i] = generateNext(lcg1000[i - 1]);
		return lcg1000;
	}
}
