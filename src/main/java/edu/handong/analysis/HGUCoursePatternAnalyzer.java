package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {

	private String[] lines = { "1999-1, JC Nam, Java Programming", "1999-2, JC Nam, Programming Language Theory",
			"1999-1, JC Nam, Data Structures", "2001-1, JC Nam, Database Systems", "2018-1, SB Lim, Java Programming",
			"2018-2, SB Lim, Programming Language Theory", "2019-1, SB Lim, Data Structures",
			"2019-1, SB Lim, Algorithm Analysis", "2018-1, SJ Kim, Java Programming",
			"2018-2, SJ Kim, Programming Language Theory", "2019-1, SJ Kim, Logic Design",
			"2019-1, SJ Kim, Algorithm Analysis", };

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;

	public void run(String[] args) {

		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);

		students = initiateStudentArrayFromLines(lines);

		System.out.println("Number of All Students: " + numOfStudents);
		for (Student student : students) {
			if (student != null)
				System.out.println(student.getName());
		}

		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for (Course course : courses) {
			if (course != null)
				System.out.println(course.getCourseName());
		}

	}

	private Student[] initiateStudentArrayFromLines(String[] lines) {
		int j = 0, k;
		String s;
		k = lines.length;
		students = new Student[k];
		for (int i = 0; i < k; i++) {
			s = lines[i].trim().split(", ")[1];
			Student elementStudent = new Student(s);
			if (studentExist(students, elementStudent)) {
				students[j] = elementStudent;
				j++;
			}
		}
		return students;
	}

	private boolean studentExist(Student[] students, Student student) {
		int i = 0;
		while (students[i] != null) {
			if (students[i].getName().equals(student.getName())) {
				return false;
			}
			i++;
		}
		return true;

	}

	private Course[] initiateCourseArrayFromLines(String[] lines) {
		int j = 0, k;
		String s;
		k = lines.length;
		courses = new Course[k];
		for (int i = 0; i < k; i++) {
			s = lines[i].trim().split(", ")[2];
			Course elementCourse = new Course(s);
			if (courseExist(courses, elementCourse)) {
				courses[j] = elementCourse;
				j++;
			}
		}
		return courses;
	}

	private boolean courseExist(Course[] courses, Course course) {
		int i = 0;
		while (courses[i] != null) {
			if (courses[i].getCourseName().equals(course.getCourseName())) {
				return false;
			}
			i++;
		}
		return true;

	}

}
