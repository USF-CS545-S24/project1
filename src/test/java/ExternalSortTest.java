import externalSort.ExternalSort;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class ExternalSortTest {
    public final static String INPUT_FILE = "inputFile";
    public final static String SORTED_FILE = "sortedFile";

    @Test
    public void testExternalSort() {
        ExternalSort listSorter = new ExternalSort();
        try {
            Files.deleteIfExists(Paths.get(INPUT_FILE));
            Files.deleteIfExists(Paths.get(SORTED_FILE));
            for (int i = 0; i < 100; i++) {
                Files.deleteIfExists(Paths.get("temp" + i + ".txt"));
            }

        } catch (IOException e1) {
            System.out.println("inputFile did not exist, no need to remove");
        }
        generateLargeFile(INPUT_FILE, 1000000); // total number of values is n = 1000000

        // Important note: in the externalSort method, we are NOT passing n, the total number of values,
        // we are passing k (how many elements can fit into memory at once)
        // and m = the number of chunks of size k in the file (the last chunk may contain less than k elements).
        listSorter.sort(INPUT_FILE, SORTED_FILE, 10000, 100);
        try (BufferedReader br = new BufferedReader(new FileReader(SORTED_FILE))) {
            String line;
            int num = 0;
            int lineNum = 0;
            while ((line = br.readLine()) != null) {
                int nextNum = Integer.parseInt(line);
                lineNum++;
                if ((nextNum < num) || (nextNum == Integer.MAX_VALUE)) {
                    Assert.fail("External file is not sorted properly. See line # " + lineNum);
                }
                num = nextNum;
            }
            if (lineNum == 0)
                Assert.fail("Sorted file is empty");
            if (lineNum != 1000000)
                Assert.fail("External sort did not result an output file which has all the elements of the input file.");
            // Delete temp files
            for (int i = 0; i < 100; i++) {
                Files.deleteIfExists(Paths.get("temp" + i + ".txt"));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not open file: " + e);
            Assert.fail();
        } catch (IOException e) {
            System.out.println("Could not read from file: " + e);
            Assert.fail();
        }
    }

    /** Used for testing external sort. Generates a large file of ints. */
    public static void generateLargeFile(String filename, int n) {
        Random rand = new Random();
        try (PrintWriter pw = new PrintWriter(filename)) {
            for (int i = 0; i < n; i++)
                pw.println(rand.nextInt(1000) + rand.nextInt(100));
        } catch (IOException e) {
            System.out.println("Error writing to a file " + filename);
        }

    }
}
