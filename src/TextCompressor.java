/******************************************************************************
 *  Compilation:  javac TextCompressor.java
 *  Execution:    java TextCompressor - < input.txt   (compress)
 *  Execution:    java TextCompressor + < input.txt   (expand)
 *  Dependencies: BinaryIn.java BinaryOut.java
 *  Data files:   abra.txt
 *                jabberwocky.txt
 *                shakespeare.txt
 *                virus.txt
 *
 *  % java DumpBinary 0 < abra.txt
 *  136 bits
 *
 *  % java TextCompressor - < abra.txt | java DumpBinary 0
 *  104 bits    (when using 8-bit codes)
 *
 *  % java DumpBinary 0 < alice.txt
 *  1104064 bits
 *  % java TextCompressor - < alice.txt | java DumpBinary 0
 *  480760 bits
 *  = 43.54% compression ratio!
 ******************************************************************************/

/**
 *  The {@code TextCompressor} class provides static methods for compressing
 *  and expanding natural language through textfile input.
 *
 *  @author Zach Blick, YOUR NAME HERE
 */
public class TextCompressor {

    private static void compress() {
        String text = BinaryStdIn.readString();
        String window = text.substring(0, 5);
        int currentIndex = 0;
        HashMap map = new HashMap();
        while (!BinaryStdIn.isEmpty()) {
            String windowThree = window.substring(0, 3);
            map.add(windowThree);
            String windowFour = window.substring(0, 4);
            map.add(windowFour);
            map.add(window);
            // shift window by one
            currentIndex += 5;
            window = text.substring(currentIndex, currentIndex + 5);
        }
        // find most repeated tokens
        String[] repeats = map.getRepeats();
        String copy = text;
        // find locations of those repeats
        for (String repeat : repeats) {
            int index;
            while ((index = copy.indexOf("repeat")) != -1) {
                index
            }
        }

        BinaryStdOut.close();
    }

    private static void expand() {

        // TODO: Complete the expand() method

        BinaryStdOut.close();
    }

    public static void main(String[] args) {
        if      (args[0].equals("-")) compress();
        else if (args[0].equals("+")) expand();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}
