public class StudentManagementApp 
{
    public static void main(String[] args) 
	{
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do 
		{
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) 
			{
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();

                    if (name.isEmpty() || grade.isEmpty()) 
					{
                        System.out.println("Invalid input. Name and grade cannot be empty.");
                    } 
					else 
					{
                        Student newStudent = new Student(name, rollNumber, grade);
                        sms.addStudent(newStudent);
                    }
                    break;
					
                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int removeRollNumber = scanner.nextInt();
                    sms.removeStudent(removeRollNumber);
                    break;
					
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRollNumber = scanner.nextInt();
                    Student foundStudent = sms.findStudentByRollNumber(searchRollNumber);
                    if (foundStudent != null) 
					{
                        System.out.println(foundStudent);
                    } 
					else 
					{
                        System.out.println("Student not found.");
                    }
                    break;
					
                case 4:
                    sms.displayAllStudents();
                    break;
					
                case 5:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
					
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
		while (choice != 5);
        scanner.close();
    }
}
