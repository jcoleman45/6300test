package edu.gatech.seclass.prj1;

import java.io.File;
import java.util.Objects;

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
        if (args.length < 1) 
        {
            printUsageAndExit();
        }
        
        String fileName = null;
        AvgSentenceLength asl = new AvgSentenceLength();
        
        for (int i = 0; i < args.length; i++) 
        {
            if (Objects.equals(args[i], "d")) 
            {
                if (i + 1 < args.length) 
                {
                    asl.setSentenceDelimiters(args[i + 1]);
                    i++;
                } 
                else 
                {
                    System.err.println(Consts.ERR_MISSING_DELIMITERS);
                    printUsageAndExit();
                }
            }
            else if (Objects.equals(args[i], "-l")) 
            {
                if (i + 1 < args.length) 
                {
                    try 
                    {
                    	int minWordLength = Integer.valueOf(args[i + 1]);
                    	if (minWordLength <= 0)
                    	{
                    		System.err.println(Consts.ERR_MIN_LENGTH_SHOULD_BE_GREATER_THAN_0 + args[i + 1]);
                        	printUsageAndExit();
                    	}
                    	asl.setMinWordLength(minWordLength);
                    }
                    catch (NumberFormatException e) 
                    {
                        System.err.println(Consts.ERR_INVALID_MIN_LENGTH + ": " + args[i + 1]);
                        printUsageAndExit();
                    }
                    i++;
                } 
                else 
                {
                    System.err.println(Consts.ERR_MISSING_MIN_LENGTH);
                    printUsageAndExit();
                }
            }
            else
            {
                fileName = args[i];
            }
        }
        
        if (fileName != null) 
        {
            File file = new File(fileName);
            if (file.exists()) 
            {
                asl.setFile(file);
                long average = asl.computeAverageSentenceLength();
                System.out.println("Average number of words per sentence in the file - " + fileName + " : " + average);
            }
            else 
            {
                System.err.println(Consts.ERR_FILE_DOES_NOT_EXIST + ": " + fileName);
                System.exit(1);
            }
        } 
        else 
        {
            System.err.println(Consts.ERR_FILE_NAME_MISSING);
            printUsageAndExit();
        }
    }

    /**
     * Print usage information and exit the application with exit code 1. 
     */
    private static void printUsageAndExit() 
    {
        System.err.println("Usage: java -cp . edu.gatech.seclass.prj1.Main [-d <delimiters>] [-l <min_length>] <file_path>");
        System.err.println("  delimiters: (optional) Specify a list of sentence delimiters - defaults to: .?!");
        System.err.println("  min_length: (optional) Specify minimum word length (inclusive) - defaults to: 3. Should be greater than 0");
        System.exit(1);
    }
}