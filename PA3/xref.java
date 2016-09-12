/* Luke Lai  Gabriel Reyes
 * luelai    ghreyes
 * 1355154   1348575
 * 11/17/14
 * xref.java
 * prints out stuff
 */

import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

class xref {

    static void processFile(String filename, boolean debug) throws IOException {
        Scanner scan = new Scanner (new File(filename));
        Tree tree = new Tree();
        for (int linenr = 1; scan.hasNextLine (); ++linenr) {
            for (String word: scan.nextLine().split ("\\W+")) {
                out.printf ("%s: %d: %s%n", filename, linenr, word);
                tree.insert(word, linenr);
            }
        }
        scan.close();
        if (debug) {
            tree.debug();
        } else {
            tree.output();
        }
    }

    public static void main(String[] args) {
        String filename = args[0];
        //to handle the -d option
        Boolean d=false;
        if(args[0].contains("-d"))
          d=true;
        if(d)
           filename=args[1];
        try {
            processFile(filename, d);
        }catch (IOException error) {
            auxlib.warn (error.getMessage());
        }
        auxlib.exit();
    }

}
