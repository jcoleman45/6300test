package edu.gatech.seclass.prj1;

import static edu.gatech.seclass.prj1.Status.PRINT_USAGE;
import static edu.gatech.seclass.prj1.Status.RUN;

/**
 * Calculates average sentence length per word of a raw text file.
 */
public class Main {

    /**
     * Application entry-point.
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        ProcessingResult result = new ArgProcessor(args).process();
        AvgSentenceLength asl = result.getAvgSentenceLength();
        if(result.getStatus() == RUN) {
            long average = asl.computeAverageSentenceLength();
            System.out.printf(Constants.OUT_AVERAGE_NUMBER, asl.getFile().getPath(), average);
        } else {
            System.err.printf(Constants.ERR_COULD_NOT_START_CALCULATION, result.getErrorMessage());
            if(result.getStatus() == PRINT_USAGE) {
                printUsage();
            }
            System.exit(1);
        }
    }

    /**
     * Print usage information.
     */
    private static void printUsage() 
    {
        System.err.println("Usage: java -cp . edu.gatech.seclass.prj1.Main [-d <delimiters>] [-l <min_length>] <file_path>");
        System.err.println("  delimiters: (optional) Specify a list of sentence delimiters - defaults to: .?!");
        System.err.println("  min_length: (optional) Specify minimum word length (inclusive) - defaults to: 3. Should be greater than 0");
    }
    
}