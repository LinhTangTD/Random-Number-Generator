package assignment2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitTest {

	LinearCongruentialGenerator test1 = new LinearCongruentialGenerator();

	@Test
	void testOne() {
		assertEquals(448, test1.generateNext(test1.seed));
	}

	@Test
	void testTwo() {
		assertEquals(269, test1.generateNext(448));
	}

	@Test
	void testThree() {
		long num = 100000000; // long value
		assertEquals(133, test1.generateNext(num));
	}

	LinearFeedBackShiftRegister test2 = new LinearFeedBackShiftRegister();

	@Test
	void testFour() {
		assertEquals(22, test2.generateNext(test2.seed));
	}

	@Test
	void testFive() {
		long[] resultList = { 22, 139, 69, 34, 145, 200, 228, 114, 185, 220 };
		long[] testList = new long[10];
		testList[0] = test2.generateNext(test2.seed);
		for (int i = 1; i < 10; i++) {
			testList[i] = test2.generateNext(testList[i - 1]);
		}
		assertArrayEquals(resultList, testList);
	}

	@Test
	void testSix() {
		int[] testArray = { 0, 0, 0, 1, 0, 1, 1, 0 };
		assertEquals(22, LinearFeedBackShiftRegister.toDecimal(testArray));
	}

	BlumBlumShub test3 = new BlumBlumShub();

	@Test
	void testSeven() {
		assertEquals(2025, test3.generateNext(test3.seed));
	}

	@Test
	void testEight() {
		long num = 226593; // long value
		assertEquals(264965, test3.generateNext(num));
	}

	@Test
	void testNine() {
		assertEquals(9, BlumBlumShub.gcd(12345678, 87654321));
	}
}
