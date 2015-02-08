package edu.gatech.seclass.prj1;

import java.io.IOException;

import static edu.gatech.seclass.prj1.Status.PRINT_USAGE;
import static edu.gatech.seclass.prj1.Status.RUN;

/**
 * Calculates average sentence length per word of a raw text file.
 */
public class Main
{

	/**
	 * Application entry-point.
	 *
	 * @param args command-line arguments
	 */
	public static void main(String[] args)
	{

		ArgResult result = new ArgProcessor(args).process();
		AvgSentenceLength asl = result.getAvgSentenceLength();
		if (result.getStatus() == RUN)
		{
			long average = 0;
			try
			{
				average = asl.computeAverageSentenceLength();
			} catch (IOException e)
			{
				System.err.println("\n" + Constants.ERR_READING_TEXT_FILE);
			}
			if (average != -1)
			{
				System.out.printf("\n" + Constants.OUT_AVERAGE_NUMBER, asl.getFile().getPath(), average);
			} else
			{
				System.err.printf("\n" + Constants.ERR_COULD_NOT_START_CALCULATION, Constants.ERR_READING_TEXT_FILE);
				System.exit(1);
			}
		} else
		{
			System.err.printf("\n" + Constants.ERR_COULD_NOT_START_CALCULATION, result.getErrorMessage());
			if (result.getStatus() == PRINT_USAGE)
			{
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
		System.err.println("\nUsage: java -cp . edu.gatech.seclass.prj1.Main [-d <delimiters>] [-l <min_length>] <file_path>");
		System.err.println("  delimiters: (optional) Specify a list of sentence delimiters - defaults to: .?!");
		System.err.println("  min_length: (optional) Specify minimum word length (inclusive) - defaults to: 3. Should be greater than 0");
	}

}