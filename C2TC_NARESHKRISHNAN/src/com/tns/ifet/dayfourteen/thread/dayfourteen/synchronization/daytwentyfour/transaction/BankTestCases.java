//Program to demonstrate Test Cases - Bank Test Case to validate AccNo
package com.tnsif.daytwentyfour.transaction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BankTestCases {
	BankTransaction trans1;

	@ParameterizedTest
	@ValueSource(ints= {1001, 1006})
	void validateAccountTest(int accNo) {
		trans1 = new BankTransaction();
		boolean status = trans1.validateAccount(accNo);
	//	assertEquals(true, status);
		assertTrue(status);
	}

}
