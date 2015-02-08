package edu.gatech.seclass.prj1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Calculates average number of words per sentence.
 */
public class AvgSentenceLength
{

	private String sentenceDelimiters;
	private int minWordLength;
	private File file;

	/**
	 * Construct a new average sentence length calculator using some default values for its properties:
	 * <ul>
	 * <li>sentenceDelimiters = &quot;.?!&quot;</li>
	 * <li>minWordLength = 3</li>
	 * </ul>
	 */
	public AvgSentenceLength()
	{
		sentenceDelimiters = Constants.SENTENCE_DELIMITERS;
		minWordLength = Constants.MIN_WORD_LENGTH;
		file = null;
	}

	/**
	 * Reads the file and compute the average number of words per sentence.
	 *
	 * @return average sentence length, or -1 if there was a problem opening or reading the file
	 */
	public long computeAverageSentenceLength() throws IOException
	{
		List<String> lines = readLinesFromFile(file);
		return computeAverage(lines);
	}

	/**
	 * Reads the content of the given file into a list of Strings.
	 *
	 * @param file file to read from
	 * @return all lines of the file or an empty list if the file is empty
	 * @throws IOException if the file cannot be opened or read from
	 */
	List<String> readLinesFromFile(File file) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		List<String> lines = new ArrayList<String>();
		String line = reader.readLine();
		while (line != null)
		{
			lines.add(line);
			line = reader.readLine();
		}
		reader.close();
		return lines;
	}

	/**
	 * Computes average sentence length in terms of number of words
	 *
	 * @param lines list of strings, must not be null
	 * @return average sentence length
	 */
	long computeAverage(List<String> lines)
	{
		if (lines == null)
		{
			throw new IllegalArgumentException("lines must not be null");
		}

		String text = joinLines(lines, " ");
		String[] sentences = text.split("[" + sentenceDelimiters + "]");
		long totalWords = 0;

		for (String sentence : sentences)
		{
			//'\s' - short for whitespace characters [ \t\n\x0b\r\f]
			String[] words = sentence.trim().split("\\s+");
			for (String word : words)
			{
				if (word.length() >= minWordLength)
				{
					totalWords++;
				}
			}
		}

		long sentenceCount = sentences.length;
		return totalWords / sentenceCount;
	}

	/**
	 * Join all strings in the given list using the specified delimiter.
	 *
	 * @param lines list of strings
	 * @return all strings joined by the delimiter
	 */
	String joinLines(List<String> lines, String delimiter)
	{
		if ((lines == null) || (delimiter == null))
		{
			return null;
		}

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < lines.size(); i++)
		{
			builder.append(lines.get(i));
			if (i != (lines.size() - 1))
			{
				builder.append(delimiter);
			}
		}
		return builder.toString();
	}

	/**
	 * Returns the currently configured sentence delimiter.
	 *
	 * @return sentence delimiter as a String, every character is another delimiter
	 */
	public String getSentenceDelimiters()
	{
		return sentenceDelimiters;
	}

	/**
	 * Set the sentence separators to be used
	 *
	 * @param sentenceDelimiters sentence delimiters
	 */
	public void setSentenceDelimiters(String sentenceDelimiters)
	{
		this.sentenceDelimiters = sentenceDelimiters;
	}

	/**
	 * Returns the currently configured minimum word length.
	 *
	 * @return minimum word length (inclusive)
	 */
	public int getMinWordLength()
	{
		return minWordLength;
	}

	/**
	 * Set the minimum word length.
	 *
	 * @param minWordLength set the minimum word length
	 */
	public void setMinWordLength(int minWordLength)
	{
		this.minWordLength = minWordLength;
	}

	/**
	 * Returns the currently configured file to process.
	 *
	 * @return input file
	 */
	public File getFile()
	{
		return file;
	}

	/**
	 * Set the file to be read from.
	 *
	 * @param file file with content to be analyzed
	 */
	public void setFile(File file)
	{
		this.file = file;
	}
}
