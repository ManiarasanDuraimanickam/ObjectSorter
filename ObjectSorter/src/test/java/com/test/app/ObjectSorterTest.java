package com.test.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.nsm.sorter.ChainExecutionSorter;
import com.nsm.sorter.DefaultObjectSorter;
import com.nsm.sorter.ObjectSorter;
import com.nsm.sorter.model.Student;

@RunWith(JUnit4.class)
public class ObjectSorterTest {

	@Test
	public void basicTest() throws IOException {
		ObjectSorter<Student> configReader = new DefaultObjectSorter<>();

		List<Student> students = getStudentList();
		configReader.sort(students, "studentSorter",1);
		printList(students);
		System.out.println("Completed");
	}

	@Test
	public void chainofSortingTest() throws IOException {
		ObjectSorter<Student> configReader = new ChainExecutionSorter<>();

		List<Student> students = getStudentList();
		configReader.sort(students, "studentSorter");
		printList(students);
		System.out.println("Completed");
	}

	private static List<Student> getStudentList() {
		List<Student> stds = new ArrayList<Student>();
		Student std1 = new Student();
		std1.setAge(25);
		std1.setName("Parthi");
		std1.setPgt(80.45f);

		Student std2 = new Student();
		std2.setAge(28);
		std2.setName("Maniarasan");
		std2.setPgt(70.59f);

		Student std3 = new Student();
		std3.setAge(24);
		std3.setName("Arun");
		std3.setPgt(70.58f);

		Student std4 = new Student();
		std4.setAge(23);
		std4.setName("Arun");
		std4.setPgt(72.58f);

		stds.add(std1);
		stds.add(std2);
		stds.add(std3);
		stds.add(std4);
		return stds;
	}

	private static String printList(List<Student> students) {
		for (Student std : students) {
			System.out.println("Name- " + std.getName() + " Age- "
					+ std.getAge() + " Pgt- " + std.getPgt());
		}
		return "";
	}

}
