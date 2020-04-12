package assignment2;

import java.util.*;
import java.lang.Math;

/**
 * LinearFeedBackShiftRegister generates a series of random integers using XOR
 * bit manipulation
 */

public class LinearFeedBackShiftRegister {

	long seed;
	int bit; // number of bits using to represent the integers in binary form

	/**
	 * Default Constructor
	 */
	LinearFeedBackShiftRegister() {
		seed = 45;
		bit = 8;
	}

	/**
	 * Override Constructor
	 * 
	 * @param seed
	 * @param bit
	 */
	LinearFeedBackShiftRegister(long seed, int bit) {
		this.seed = seed;
		this.bit = bit;
	}

	public void changeBit(int bit) {
		this.bit = bit;
	}

	public void changeSeed(long seed) {
		this.seed = seed;
	}

	/**
	 * Convert long integers into binary format
	 * 
	 * @param num
	 * @return array of binaries representing the number
	 */
	public int[] toBinary(long num) {
		// Convert parameter to binary in string format
		String bitString = Long.toBinaryString(num);

		// We are handling long integers which take 8 bits
		// Add more zeros to the first of the binary form until the length = 8
		while (bitString.length() != bit)
			bitString = "0" + bitString;

		// Convert from string to integer array
		int[] bitArray = new int[bitString.length()];
		for (int i = 0; i < bitString.length(); i++)
			bitArray[i] = Integer.parseInt(bitString.split("")[i]);

		return bitArray;
	}

	/**
	 * Convert binary format of long integers to decimal format
	 * 
	 * @param bitArray
	 * @return decimal
	 */
	public static long toDecimal(int[] bitArray) {
		long result = 0;
		int len = bitArray.length;
		for (int i = len - 1; i >= 0; i--)
			if (bitArray[i] == 1)
				result += Math.pow(2, len - 1 - i);
		return result;
	}

	/**
	 * Find tap bits from given seed
	 * 
	 * @return list of tap bits
	 */
	public ArrayList<Integer> findTap() {
		int[] bitSeed = toBinary(seed);
		ArrayList<Integer> tap = new ArrayList<Integer>();
		for (int i = 0; i < bitSeed.length; i++) {
			if (bitSeed[i] == 1)
				tap.add(i);
		}
		return tap;
	}

	/**
	 * Calculate the first bit to replace in the vacant after shifting
	 * 
	 * @param bitArray
	 * @param tap
	 * @return
	 */
	public int firstBit(int[] bitArray, ArrayList<Integer> tap) {
		int firstBit = bitArray[tap.get(0)];
		for (int i = 1; i < tap.size(); i++) {
			firstBit ^= bitArray[tap.get(i)];
		}
		return firstBit;
	}

	/**
	 * Generate the next random number using the Linear Feed Back Shift Register
	 * algorithm
	 * 
	 * @param seed, the previous number or the initial seed
	 * @return the next random number
	 */
	public long generateNext(long seed) {

		// convert previous number into binary arrays
		int[] old_bitArray = toBinary(seed);
		int len = old_bitArray.length;

		// initialize new array to hold binary form of new number
		int[] new_bitArray = new int[len];

		// shift to the right by 1 position
		for (int i = 0; i < len - 1; i++) {
			new_bitArray[i + 1] = old_bitArray[i];
		}
		// set the left-most bit using XOR operation
		new_bitArray[0] = firstBit(old_bitArray, findTap());

		// convert binary arrays to decimal format
		long res = toDecimal(new_bitArray);
		return res;
	}

	/**
	 * Print information about the settings
	 */
	public void printInfo() {
		System.out.println("Test LFSR with seed = " + seed + " and bit = " + bit);
	}

	/**
	 * Test the algorithm by generating 1000 numbers
	 * 
	 * @return array of random numbers
	 */
	public long[] test() {
		long[] lfsr1000 = new long[1000];
		lfsr1000[0] = seed;
		for (int i = 1; i < 1000; i++)
			lfsr1000[i] = generateNext(lfsr1000[i - 1]);
		return lfsr1000;
	}
}
