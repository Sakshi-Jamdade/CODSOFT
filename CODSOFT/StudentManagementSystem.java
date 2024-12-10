import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem 
{
    private List<Student> students = new ArrayList<>();
    private static final String FILE_NAME = "students.dat";

    public StudentManagementSystem() 
	{
        loadStudentsFromFile();
    }

    public void addStudent(Student student) 
	{
        if (findStudentByRollNumber(student.getRollNumber()) == null) 
		{
            students.add(student);
            System.out.println("Student added successfully.");
            saveStudentsToFile();
        } 
		else 
		{
            System.out.println("Student with the same roll number already exists.");
        }
    }

    public void removeStudent(int rollNumber) 
	{
        Student student = findStudentByRollNumber(rollNumber);
        if (student != null) 
		{
            students.remove(student);
            System.out.println("Student removed successfully.");
            saveStudentsToFile();
        } 
		else 
		{
            System.out.println("Student not found.");
        }
    }

    public Student findStudentByRollNumber(int rollNumber) 
	{
        for (Student student : students) 
		{
            if (student.getRollNumber() == rollNumber) 
			{
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() 
	{
        if (students.isEmpty()) 
		{
            System.out.println("No students found.");
        } 
		else 
		{
            for (Student student : students) 
			{
                System.out.println(student);
            }
        }
    }

    private void saveStudentsToFile() 
	{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) 
		{
            oos.writeObject(students);
        } 
		catch (IOException e) 
		{
            System.out.println("Error saving students to file: " + e.getMessage());
        }
    }

    private void loadStudentsFromFile() 
	{
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) 
		{
            students = (List<Student>) ois.readObject();
        } 
		catch (FileNotFoundException e) 
		{
            // File not found is fine, it means no students have been saved yet
        } 
		catch (IOException | ClassNotFoundException e) 
		{
            System.out.println("Error loading students from file: " + e.getMessage());
        }
    }
}
