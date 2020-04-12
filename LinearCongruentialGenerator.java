package assignment2;

/**
 * LinearCongruentialGenerator generates a series of random integers using the
 * formula x_n+1 = (a*x_n + b) mod m
 */

public class LinearCongruentialGenerator {
	public long a;
	public long b;
	public long m;
	public long seed;

	/**
	 * Default Constructor
	 */
	public LinearCongruentialGenerator() {
		a = 7;
		b = 133;
		m = 1000;
		seed = 45;
	}

	/**
	 * Override Constructor
	 * 
	 * @param a
	 * @param b
	 * @param m
	 */
	public LinearCongruentialGenerator(long a, long b, long m, long seed) {
		this.a = a;
		this.b = b;
		this.m = m;
		this.seed = seed;
	}

	public void changeParam(long a, long b, long m) {
		this.a = a;
		this.b = b;
		this.m = m;
	}

	public void changeSeed(long seed) {
		this.seed = seed;
	}

	/**
	 * Generate the next random number using the Linear Congruential algorithm
	 * 
	 * @param seed, the previous number or the initial seed
	 * @return the next random number
	 */
	public long generateNext(long seed) {
		return (a * seed + b) % m;
	}

	/**
	 * Print information about the settings
	 */
	public void printInfo() {
		System.out.println(
				"Test LCG with seed = " + seed + " and other parameters: a = " + a + " b = " + b + " m = " + m);
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
