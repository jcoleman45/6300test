package edu.gatech.seclass.prj1;

import java.io.File;

/**
 * Calculates average sentence length per word of a raw text file.
 */
public class Main {

    /**
     * Application entry-point.
     * @param args command-line arguments
     */
    public static void main(String [] args) {
        if(args.length < 1) {
            printUsageAndExit();
        }
        
        String fileName = null;
        AvgSentenceLength asl = new AvgSentenceLength();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-d":
                    if (i + 1 < args.length) {
                        asl.setSentenceDelimiters(args[i + 1]);
                        i++;
                    } else {
                        System.err.println("missing delimiters");
                        printUsageAndExit();
                    }
                    break;
                case "-l":
                    if (i + 1 < args.length) {
                        try {
                            asl.setMinWordLength(Integer.valueOf(args[i + 1]));
                        } catch (NumberFormatException e) {
                            System.err.println("invalid min_length: " + args[i + 1]);
                            printUsageAndExit();
                        }
                        i++;
                    } else {
                        System.err.println("missing min_length");
                        printUsageAndExit();
                    }
                    break;
                default:
                    fileName = args[i];
                    break;
            }
        }
        if (fileName != null) {
            File file = new File(fileName);
            if (file.exists()) {
                asl.setFile(file);
                long average = asl.computeAverageSentenceLength();
                System.out.println("Average number of words per sentence in the file - " + fileName + " : " + average);
            } else {
                System.err.println("specified file does not exist: " + fileName);
                System.exit(1);
            }
        } else {
            System.err.println("missing filename");
            printUsageAndExit();
        }
    }

    /**
     * Print usage information and exit the application with exit code 1. 
     */
    private static void printUsageAndExit() {
        System.err.println("Usage: java -cp . edu.gatech.seclass.prj1.Main [-d <delimiters>] [-l <min_length>] <file_path>");
        System.err.println("  delimiters: (optional) Specify a list of sentence delimiters - defaults to: .?!");
        System.err.println("  min_length: (optional) Specify minimum word length (inclusive) - defaults to: 3");
        System.exit(1);
    }

}