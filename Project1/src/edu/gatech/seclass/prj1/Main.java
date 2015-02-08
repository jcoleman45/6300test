package edu.gatech.seclass.prj1;

import java.io.IOException;

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

		switch (result.getStatus())
		{
			case RUN:
				try
				{
					AvgSentenceLength asl = result.getAvgSentenceLength();
					long average = asl.computeAverageSentenceLength();
					System.out.println();
					System.out.printf(Constants.OUT_AVERAGE_NUMBER, asl.getFile().getPath(), average);
				} catch (IOException e)
				{
					System.out.println();
					System.err.printf(Constants.ERR_COULD_NOT_START_CALCULATION, Constants.ERR_READING_TEXT_FILE);
					System.exit(1);
				}
				break;

			case EXIT:
				System.out.println();
				System.err.printf(Constants.ERR_COULD_NOT_START_CALCULATION, result.getErrorMessage());
				System.exit(1);
				break;
			case PRINT_USAGE:
			default:
				System.out.println();
				System.err.printf(Constants.ERR_COULD_NOT_START_CALCULATION, result.getErrorMessage());
				printUsage();
				System.exit(1);
				break;
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