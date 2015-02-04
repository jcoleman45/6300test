package edu.gatech.seclass.prj1;

import java.io.File;
import java.util.Objects;

import static edu.gatech.seclass.prj1.Status.PRINT_USAGE;
import static edu.gatech.seclass.prj1.Status.SYSTEM_EXIT;

/**
 * Processes command-line arguments.
 */
public class ArgProcessor {
    
    final private String[] args;

    public ArgProcessor(String[] args) {
        this.args = args;
    }

    public ProcessingResult process() {
        if (args.length < 1) 
        {
            return new ProcessingResult(Constants.ERR_FILE_NAME_MISSING, PRINT_USAGE);
        }

        String fileName = null;
        AvgSentenceLength avgSentenceLength = new AvgSentenceLength();

        for (int i = 0; i < args.length; i++) 
        {
            if (Objects.equals(args[i], "d")) 
            {
                if (i + 1 < args.length) 
                {
                    avgSentenceLength.setSentenceDelimiters(args[i + 1]);
                    i++;
                } 
                else {
                    return new ProcessingResult(Constants.ERR_MISSING_DELIMITERS, PRINT_USAGE);
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
                            return new ProcessingResult(Constants.ERR_MIN_LENGTH_SHOULD_BE_GREATER_THAN_0 + args[i + 1], PRINT_USAGE);
                    	}
                    	avgSentenceLength.setMinWordLength(minWordLength);
                    }
                    catch (NumberFormatException e) 
                    {
                        return new ProcessingResult(Constants.ERR_INVALID_MIN_LENGTH + ": " + args[i + 1], PRINT_USAGE);
                    }
                    i++;
                } 
                else 
                {
                    return new ProcessingResult(Constants.ERR_MISSING_MIN_LENGTH, PRINT_USAGE);
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
                avgSentenceLength.setFile(file);
                return new ProcessingResult(avgSentenceLength);
            }
            else 
            {
                return new ProcessingResult(Constants.ERR_FILE_DOES_NOT_EXIST + ": " + fileName, SYSTEM_EXIT);
            }
        } 
        else 
        {
            return new ProcessingResult(Constants.ERR_FILE_NAME_MISSING, PRINT_USAGE);
        }
    }
}
