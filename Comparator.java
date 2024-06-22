import java.util.ArrayList;

public class Comparator {
    public static void main(String args[]) {
        // Initializing students
        Student s1 = new Student(24, "Jeff", "9332 Willow Street");
        Student s2 = new Student(2, "Sally", "8229 Maple Ave");
        Student s3 = new Student(85, "Jim", "6622 Oak Road");
        Student s4 = new Student(5, "Sue", "1324 Spruce Ave");
        Student s5 = new Student(107, "Jack", "2222 Aspen Road");

        // Creating arraylist of students
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        // Sorting by rollno
        MergeSort sorter = new MergeSort();
        ArrayList<Student> sorted = sorter.sort(students);

        // Printing out sorted rollno
        for (int i = 0; i < sorted.size(); i++) {
            System.out.println((i+1) + ": " + sorted.get(i).rollno);
        }


    }
}
