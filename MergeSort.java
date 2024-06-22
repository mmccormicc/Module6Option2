import java.util.ArrayList;

public class MergeSort {
    public ArrayList<Student> merge(ArrayList<Student> s1, ArrayList<Student> s2) {
        // Empty arraylist to hold sorted students
        ArrayList<Student> sorted = new ArrayList<Student>();

        int i = 0;
        int j = 0;
        // Keeps running until elements in one list have all been added
        while(i < s1.size() && j < s2.size()) {
            int r1 = s1.get(i).rollno;
            int r2 = s2.get(j).rollno;
            // Choosing the smaller element to add to sorted list then incrementing to next element in that element's list
            if(r1 <= r2) {
                sorted.add(s1.get(i));
                i++;
            } else {
                sorted.add(s2.get(j));
                j++;
            }
        }

        // Adding extra elements in first list
        while(i < s1.size()) {
            sorted.add(s1.get(i));
            i++;
        }

        // Adding extra elements in second list
        while(j < s2.size()) {
            sorted.add(s2.get(j));
            j++;
        }

        return sorted;
    }

    public boolean checkSorted(ArrayList<Student> students) {
        // Checking if arraylist is already sorted
        boolean sorted = true;
        int lastV = 0;
        for (int n = 0; n < students.size(); n++) {
            if (lastV == 0) {
                lastV = students.get(n).rollno;
            } else if(students.get(n).rollno < lastV) {
                sorted = false;
                break;
            } else {
                lastV = students.get(n).rollno;
            }
        }
        return sorted;
    }

    public ArrayList<Student> sort(ArrayList<Student> students) {
        int size = students.size();
        int p = size/2;

        // Creating array list of first half
        ArrayList<Student> s1 = new ArrayList<Student>();
        for (int n = 0; n < p; n++) {
            s1.add(students.get(n));
        }


        // Creating array list of second half
        ArrayList<Student> s2 = new ArrayList<Student>();
        for (int n = p; n < size; n++) {
            s2.add(students.get(n));
        }

        // Deciding if arraylist is already sorted and ready to merge, or needs to be broken down more
        if (checkSorted(s1) && checkSorted(s2)) {
            return merge(s1, s2);
        } else if (checkSorted(s1)) {
            return merge(s1, sort(s2));
        } else if (checkSorted(s2)) {
            return merge(sort(s1), s2);
        } else {
            return merge(sort(s1), sort(s2));
        }
    }
}
