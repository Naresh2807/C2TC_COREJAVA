//Program to use checked Exception
package com.tnsif.daytwelve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class CheckedException {
	static String acceptText() throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Enter the string: ");
			String str = br.readLine();
			// br.close(); The BufferedReader will be closed automatically when the try
			// block is exited, regardless of whether an exception is thrown or not.
			return str;
		}
	}
}
