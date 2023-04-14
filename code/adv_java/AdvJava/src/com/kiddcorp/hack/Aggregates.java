package com.kiddcorp.hack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Aggregates {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("hediyeh", 7000L), new Person("sara", 10000L),
				new Person("shabnam", 150000L), new Person("shiva", 230000L));

		Optional<Person> maxSalary = people.stream().max(Comparator.comparingLong(Person::getSalary));
		maxSalary.ifPresent(System.out::println);

		String maxSalaryName = people.stream().max(Comparator.comparingLong(Person::getSalary)).map(Person::getName)
				.get();
		System.out.println("Name-> " + maxSalaryName);
		OptionalDouble avgSalary=people.stream().mapToLong(Person::getSalary).average();
		System.out.println(avgSalary.getAsDouble());
		
		DoubleSummaryStatistics summary=people.stream().mapToDouble(Person::getSalary)
				.summaryStatistics();
		System.out.println(summary);
		summary.accept(1L);
		System.out.println(summary);
	}

	public static class Person {
		private String name;
		private Long salary;

		public Person() {
		}

		public Person(String name, Long salary) {
			this.name = name;
			this.salary = salary;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getSalary() {
			return salary;
		}

		public void setSalary(Long salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Person{" + "name='" + name + '\'' + ", salary=" + salary + '}';
		}
	}

}
