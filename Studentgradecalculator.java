import java.util.Scanner;

class StudentReportCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();


        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();
        sc.nextLine();

        String[] subjectNames = new String[numSubjects];
        int[] marks = new int[numSubjects];
        int totalMarks = 0;


        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter name of Subject " + (i + 1) + ": ");
            subjectNames[i] = sc.nextLine();

            System.out.print("Enter marks for " + subjectNames[i] + " (out of 100): ");
            marks[i] = sc.nextInt();
            sc.nextLine();
            totalMarks += marks[i];
        }


        double average = (double) totalMarks / numSubjects;


        String grade;
        if (average >= 90) {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else if (average >= 60) {
            grade = "D";
        } else if (average >= 50) {
            grade = "E";
        } else {
            grade = "F";
        }


        String remarks;
        switch (grade) {
            case "A": remarks = "Excellent Performance"; break;
            case "B": remarks = "Very Good"; break;
            case "C": remarks = "Good"; break;
            case "D": remarks = "Average - Keep Improving"; break;
            case "E": remarks = "Below Average - Needs Work"; break;
            default:  remarks = "Poor - Must Work Hard"; break;
        }


        System.out.println("\n==============================");
        System.out.println("         REPORT CARD");
        System.out.println("==============================");
        System.out.println("Student Name : " + studentName);
        System.out.println("Number of Subjects : " + numSubjects);
        System.out.println("------------------------------");
        System.out.println(" Subject\tMarks");
        System.out.println("------------------------------");
        for (int i = 0; i < numSubjects; i++) {
            System.out.println(" " + subjectNames[i] + "\t\t" + marks[i]);
        }
        System.out.println("------------------------------");
        System.out.println("Total Marks : " + totalMarks);
        System.out.println("Average %   : " + String.format("%.2f", average));
        System.out.println("Grade       : " + grade);
        System.out.println("Remarks     : " + remarks);
        System.out.println("==============================");

        sc.close();

}}