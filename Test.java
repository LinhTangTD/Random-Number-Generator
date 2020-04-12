/**
 * @Assignment2
 * @author Linh, Yolanda & Asya
 * @due: Feb 26
 */
package assignment2;

import java.io.*;
import java.util.*;

public class Assignment02Test {

	public static void analyzeAlgorithm(long[] randomNumber) {
		Set<Long> unique = new HashSet<Long>();
		for (long num : randomNumber)
			unique.add(num);
		System.out.println("Length of sequence: " + unique.size());
	}

	public static void printFile(long[] randomNumber, String file) {
		try {
			PrintStream fileOut = new PrintStream(file);
			System.setOut(fileOut);
			for (long num : randomNumber)
				System.out.println(num);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		LinearCongruentialGenerator lcg_test = new LinearCongruentialGenerator();
		LinearFeedBackShiftRegister lfsr_test = new LinearFeedBackShiftRegister();
		BlumBlumShub bbs_test = new BlumBlumShub();

		// generate 1000 random numbers using Linear Congruential, Linear Feed Back
		// Shift Register, Blum Blum Shub methods and save the
		// output in separate files
		printFile(lcg_test.test(), "./lcg_basic_test_01.dat");
		printFile(lfsr_test.test(), "./lfsr_basic_test_01.dat");
		printFile(bbs_test.test(), "./bbs_basic_test_01.dat");

		// Analyze Algorithms and save the output in separate file
		try {
			PrintStream fileOut = new PrintStream("./algorithmAnalysis.txt");
			System.setOut(fileOut);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		// LCG TEST
		System.out.println("LCG TEST");
		// our observations
		System.out.println("We found that as modulus increases and as seed decreases, length of random number sequence without duplication increases.");
		// test 1
		lcg_test.printInfo();
		analyzeAlgorithm(lcg_test.test());

		// test2
		lcg_test.changeParam(2, 3, 5);
		lcg_test.printInfo();
		analyzeAlgorithm(lcg_test.test());

		// test 3
		lcg_test.changeParam(2, 10, 500);
		lcg_test.printInfo();
		analyzeAlgorithm(lcg_test.test());

		// test 4
		lcg_test.changeSeed(200);
		lcg_test.printInfo();
		analyzeAlgorithm(lcg_test.test());

		// LFSR TEST
		System.out.println();
		System.out.println("LFSR TEST");
		// our observations
		System.out.println("We found that as number of bit increases and as seed decreases, length of random number sequence without duplication increases.");
		// test 1
		lfsr_test.printInfo();
		analyzeAlgorithm(lfsr_test.test());

		// test 2
		lfsr_test.changeBit(16);
		lfsr_test.printInfo();
		analyzeAlgorithm(lfsr_test.test());

		// test 3
		lfsr_test.changeSeed(200);
		lfsr_test.printInfo();
		analyzeAlgorithm(lfsr_test.test());

		// test 3
		lfsr_test.changeBit(32);
		lfsr_test.printInfo();
		analyzeAlgorithm(lfsr_test.test());

		// BBS TEST
		System.out.println();
		System.out.println("BBS TEST");
		// our observations
		System.out.println("We found that as M increases and as seed decreases, length of random number sequence without duplication increases.");
		// test 1
		bbs_test.printInfo();
		analyzeAlgorithm(bbs_test.test());

		// test 2
		bbs_test.changeParam(433, 439);
		bbs_test.printInfo();
		analyzeAlgorithm(bbs_test.test());

		// test 3
		bbs_test.changeSeed(200);
		bbs_test.printInfo();
		analyzeAlgorithm(bbs_test.test());

		// test 3
		bbs_test.changeParam(3673, 4337);
		bbs_test.printInfo();
		analyzeAlgorithm(bbs_test.test());
	}
}

/*
 * COMMENTS We spent ten hours on this assignment. The most interesting part
 * would be the process of understanding these three algorithms and starting to
 * build the classes. This process made us struggle and we spent lots of time
 * doing research and discussing.
 */