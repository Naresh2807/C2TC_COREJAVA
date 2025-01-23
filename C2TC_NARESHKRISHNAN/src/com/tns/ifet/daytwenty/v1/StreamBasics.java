//program to demonstrate Stream API
package com.tnsif.daytwenty.v1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamBasics {

	public static void main(String[] args) {
		// Create a list of integers from an array
		List<Integer> numList = Arrays.asList(4, 2, 3, 4, 5, 6);
		System.out.println("List of Numbers : "+numList);
		// Retrieve a stream from a list
		Stream<Integer> stream = numList.stream();
		
		// Perform map operation for squaring each element from list
		System.out.println("Square of numbers");
		stream = stream.map(x -> x * x);
		stream.forEach(x -> System.out.println(x));
		System.out.println("----------------------------------------");

		// map - receives Function object
		stream = numList.stream();
		Function<Integer, Integer> fun = (x) -> x * x * x;
		stream = stream.map(fun);
		System.out.println("Cube of numbers");
		stream.forEach(x -> System.out.println(x));
		System.out.println("----------------------------------------");

		// Count number of elements
		stream = numList.stream();
		System.out.println("Count : " + stream.count());
		System.out.println("----------------------------------------");

		// Collect all cubes into another list
		stream = numList.stream();
		List<Integer> cubeList = stream.map(fun).toList();
		// cubeList=stream.collect(Collectors.toList());
		System.out.println("Number List is " + numList);
		System.out.println("Cube list is " + cubeList);
		System.out.println("----------------------------------------");

		// Method Reference
		stream = numList.stream();
		stream = stream.map(fun);
		System.out.println("Using method reference");
		stream.forEach(System.out::println); // display each element
		System.out.println("----------------------------------------");

		// Using Functional Interface reference
		Function<Integer, Double> sqrt = x -> Math.sqrt(x);
		stream = numList.stream();
		Consumer<Double> consumer = x -> System.out.println("Result is " + x);
		Stream<Double> sqrtStream = stream.map(sqrt);
		System.out.println("Square roots of numbers");
		sqrtStream.forEach(consumer);
		System.out.println("----------------------------------------");

		// distinct
		stream = numList.stream();
		stream = stream.distinct();
		System.out.println("Distinct Numbers");
		stream.forEach(System.out::println);
		System.out.println("----------------------------------------");

		// filter - receives Predicate object
		System.out.println(numList);

		// stream=numList.stream().filter(x->x%2==0);
		System.out.println("even numbers");
		Predicate<Integer> evenPredicate = x -> x % 2 == 0;
		stream = numList.stream().filter(evenPredicate);
		stream.forEach(System.out::println);
		System.out.println("------------------------------");

		stream = numList.stream();
		// Returns sum of numbers
		Optional<Integer> result;
		result = stream.reduce((x, y) -> x + y);
		System.out.println("Sum of numbers : "+result.get());
		System.out.println("----------------------------------------");

		// returns maximum of numbers
		BinaryOperator<Integer> binaryOpr = (x, y) -> x > y ? x : y;
		stream = numList.stream();
		result = stream.reduce(binaryOpr);
		System.out.println("Maximum : "+result.get());
		System.out.println("----------------------------------------");

		// Creating List of names
		List<String> nameList = Arrays.asList("Neha", "Mihir", "Pooja", "Dhruv", "Meet");
		System.out.println(nameList);
		System.out.println("----------------------------------------");

		// Limit - retrieves top 3 values
		System.out.println("Top 3 Names");
		Stream<String> strStream = nameList.stream();
		strStream = strStream.limit(3);
		strStream.forEach(System.out::println);
		System.out.println("----------------------------------------");

		// Skip first 2 names
		System.out.println("Skip 2 Names");
		strStream = nameList.stream();
		strStream = strStream.skip(2);
		strStream.forEach(System.out::println);
		System.out.println("----------------------------------------");

	}

}
