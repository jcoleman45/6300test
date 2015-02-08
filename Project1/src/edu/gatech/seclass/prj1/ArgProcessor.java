package edu.gatech.seclass.prj1;

import java.io.File;

import static edu.gatech.seclass.prj1.Status.EXIT;
import static edu.gatech.seclass.prj1.Status.PRINT_USAGE;

/**
 * Processes command-line arguments.
 */
public class ArgProcessor
{

	final private String[] args;

	/**
	 * Instantiate an {@code ArgProcessor} class using the given command-line arguments
	 *
	 * @param args command-line arguments from a Java main() entry-point
	 */
	public ArgProcessor(String[] args)
	{
		this.args = args;
	}

	/**
	 * Process the stored command-line arguments and return the result and
	 * potentially an {@code AvgSentenceLength} instance configured using the
	 * command-line arguments *
	 * <p/>
	 * The only possible command type combinations are -
	 * 1 arg  : java -cp . edu.gatech.seclass.prj1.Main <file_path>
	 * 3 args : java -cp . edu.gatech.seclass.prj1.Main -d <delimiters> <file_path>
	 * 3 args : java -cp . edu.gatech.seclass.prj1.Main -l <min_length> <file_path>
	 * 5 args : java -cp . edu.gatech.seclass.prj1.Main -d <delimiters> -l <min_length> <file_path>
	 * 5 args : java -cp . edu.gatech.seclass.prj1.Main -l <min_length> -d <delimiters> <file_path>
	 *
	 * @return result of the argument processing
	 */
	public ArgResult process()
	{
		if (args.length < 1)
		{
			return new ArgResult(Constants.ERR_FILE_NAME_MISSING, PRINT_USAGE);
		}

		int minLengthIndex = -1;
		int delimitersIndex = -1;
		int fileNameIndex = -1;
		boolean wrongCommand = false;

		switch (args.length)
		{
			case 1:
				fileNameIndex = 0;
				break;

			case 3:
				if (args[0].equals(Constants.MIN_LENGTH_COMMAND))
				{
					minLengthIndex = 1;
				}
				else if (args[0].equals(Constants.DELIMITER_COMMAND))
				{
					delimitersIndex = 1;
				}
				else
				{
					wrongCommand = true;
				}
				fileNameIndex = 2;
				break;

			case 5:
				if (args[0].equals(Constants.MIN_LENGTH_COMMAND) && args[2].equals(Constants.DELIMITER_COMMAND))
				{
					minLengthIndex = 1;
					delimitersIndex = 3;
				}
				else if (args[0].equals(Constants.DELIMITER_COMMAND) && args[2].equals(Constants.MIN_LENGTH_COMMAND))
				{
					minLengthIndex = 3;
					delimitersIndex = 1;
				}
				else
				{
					wrongCommand = true;
				}
				fileNameIndex = 4;
				break;

			default:
				wrongCommand = true;
				break;
		}

		if (wrongCommand)
		{
			return new ArgResult(Constants.ERR_INVALID_COMMAND, PRINT_USAGE);
		}

		AvgSentenceLength avgSentenceLength = new AvgSentenceLength();

		if (delimitersIndex != -1)
		{
			avgSentenceLength.setSentenceDelimiters(args[delimitersIndex]);
		}

		if (minLengthIndex != -1)
		{
			try
			{
				int minWordLength = Integer.valueOf(args[minLengthIndex]);
				if (minWordLength <= 0)
				{
					return new ArgResult(Constants.ERR_MIN_LENGTH_SHOULD_BE_GREATER_THAN_0 + " : " + args[minLengthIndex], PRINT_USAGE);
				}
				avgSentenceLength.setMinWordLength(minWordLength);
			} catch (NumberFormatException e)
			{
				return new ArgResult(Constants.ERR_INVALID_MIN_LENGTH + " : " + args[minLengthIndex], PRINT_USAGE);
			}
		}

		String fileName = args[fileNameIndex];
		File file = new File(fileName);
		if (file.exists())
		{
			avgSentenceLength.setFile(file);
			return new ArgResult(avgSentenceLength);
		}
		else
		{
			return new ArgResult(Constants.ERR_FILE_DOES_NOT_EXIST + " : " + fileName, EXIT);
		}
	}
}
