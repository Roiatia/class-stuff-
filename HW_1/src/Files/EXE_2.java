package Files;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
public class EXE_2 {

	    // Maximum number of students allowed
	    public static final int MAX_STUDENTS = 1000;

	    public static void main(String[] args) throws FileNotFoundException {

	        // ---- Files ----
	        File csFile = new File("CS.txt");
	        File hedvaFile = new File("hedva.txt");
	        PrintWriter reportWriter = new PrintWriter("report.txt");

	        // ---- Arrays for the first file (CS.txt) ----
	        int[] ids1 = new int[MAX_STUDENTS];
	        String[] firstNames = new String[MAX_STUDENTS];
	        String[] lastNames = new String[MAX_STUDENTS];
	        int count1 = 0; // number of students in first file

	        // ---- Arrays for the second file (hedva.txt) ----
	        int[] ids2 = new int[MAX_STUDENTS];
	        int[] grade1 = new int[MAX_STUDENTS];
	        int[] grade2 = new int[MAX_STUDENTS];
	        int count2 = 0; // number of students in second file

	        // ===== Reading the first file (CS.txt) ONCE =====
	        Scanner csScanner = new Scanner(csFile);

	        while (csScanner.hasNext() && count1 < MAX_STUDENTS) {

	            // reading: firstName lastName ID
	            String f = csScanner.next();
	            String l = csScanner.next();
	            int id = csScanner.nextInt();

	            firstNames[count1] = f;
	            lastNames[count1] = l;
	            ids1[count1] = id;

	            count1++;
	        }
	        csScanner.close();

	        // ===== Reading the second file (hedva.txt) ONCE =====
	        Scanner hedvaScanner = new Scanner(hedvaFile);

	        while (hedvaScanner.hasNext() && count2 < MAX_STUDENTS) {

	            // reading: ID grade1 grade2
	            int id = hedvaScanner.nextInt();
	            int g1 = hedvaScanner.nextInt();
	            int g2 = hedvaScanner.nextInt();

	            ids2[count2] = id;
	            grade1[count2] = g1;
	            grade2[count2] = g2;

	            count2++;
	        }
	        hedvaScanner.close();

	        // ===== Sorting both files by ID using Insertion Sort =====
	        insertionSortFirstGroup(ids1, firstNames, lastNames, count1);
	        insertionSortSecondGroup(ids2, grade1, grade2, count2);

	        // ===== Merge-like scan through both sorted lists =====
	        int i = 0; // index for first group
	        int j = 0; // index for second group

	        while (i < count1 && j < count2) {

	            if (ids1[i] == ids2[j]) {
	                // Student exists in both files
	                int avg = (grade1[j] + grade2[j]) / 2;

	                // Write line to report.txt
	                reportWriter.println(ids1[i] + " " +
	                                     firstNames[i] + " " +
	                                     lastNames[i] + " " +
	                                     avg);

	                i++;
	                j++;
	            }
	            else if (ids1[i] < ids2[j]) {
	                // Move forward in the first list
	                i++;
	            }
	            else {
	                // Move forward in the second list
	                j++;
	            }
	        }

	        reportWriter.close();
	    }

	    // ================= Helper Functions =================

	    // Insertion Sort for first group (ID + names)
	    public static void insertionSortFirstGroup(int[] ids,
	                                               String[] firstNames,
	                                               String[] lastNames,
	                                               int n) {

	        for (int i = 1; i < n; i++) {

	            int currentId = ids[i];
	            String currentFirst = firstNames[i];
	            String currentLast = lastNames[i];

	            int j = i - 1;

	            // Shift larger IDs to the right
	            while (j >= 0 && ids[j] > currentId) {
	                ids[j + 1] = ids[j];
	                firstNames[j + 1] = firstNames[j];
	                lastNames[j + 1] = lastNames[j];
	                j--;
	            }

	            // Insert at correct position
	            ids[j + 1] = currentId;
	            firstNames[j + 1] = currentFirst;
	            lastNames[j + 1] = currentLast;
	        }
	    }

	    // Insertion Sort for second group (ID + 2 grades)
	    public static void insertionSortSecondGroup(int[] ids,
	                                                int[] g1,
	                                                int[] g2,
	                                                int n) {

	        for (int i = 1; i < n; i++) {

	            int currentId = ids[i];
	            int currentG1 = g1[i];
	            int currentG2 = g2[i];

	            int j = i - 1;

	            // Shift larger IDs to the right
	            while (j >= 0 && ids[j] > currentId) {
	                ids[j + 1] = ids[j];
	                g1[j + 1] = g1[j];
	                g2[j + 1] = g2[j];
	                j--;
	            }

	            // Insert at correct position
	            ids[j + 1] = currentId;
	            g1[j + 1] = currentG1;
	            g2[j + 1] = currentG2;
	        }
	    }
	

}
