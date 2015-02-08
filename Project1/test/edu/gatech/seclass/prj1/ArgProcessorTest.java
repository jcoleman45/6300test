package edu.gatech.seclass.prj1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ArgProcessorTest
{

	private String fileDir;

	@Before
	public void setUp() throws Exception
	{
		fileDir = "test" + File.separator + "inputfiles" + File.separator;
	}

	@After
	public void tearDown() throws Exception
	{
		fileDir = null;
	}

	@Test
	public void test_NoArguments()
	{
		String[] args = new String[]{};
		ArgResult result = new ArgProcessor(args).process();
		assertEquals(Constants.ERR_FILE_NAME_MISSING, result.getErrorMessage());
	}

	@Test
	public void test_MissingDelimiters()
	{
		String[] args = new String[]{Constants.DELIMITER_COMMAND, fileDir};
		ArgResult result = new ArgProcessor(args).process();
		assertEquals(Constants.ERR_INVALID_COMMAND, result.getErrorMessage());
	}

	@Test
	public void test_NegativeMinimumWordLength()
	{
		String[] args = new String[]{Constants.DELIMITER_COMMAND, ".!?", Constants.MIN_LENGTH_COMMAND, "-2", fileDir};
		ArgResult result = new ArgProcessor(args).process();
		assertEquals(Constants.ERR_MIN_LENGTH_SHOULD_BE_GREATER_THAN_0 + " : " + "-2", result.getErrorMessage());
	}

	@Test
	public void test_MissingMinimumWordLength()
	{
		String[] args = new String[]{Constants.DELIMITER_COMMAND, ".!?", Constants.MIN_LENGTH_COMMAND, fileDir};
		ArgResult result = new ArgProcessor(args).process();
		assertEquals(Constants.ERR_INVALID_COMMAND, result.getErrorMessage());
	}

	@Test
	public void test_InvalidMinimumWordLength()
	{
		String[] args = new String[]{Constants.MIN_LENGTH_COMMAND, "a", fileDir};
		ArgResult result = new ArgProcessor(args).process();
		assertEquals(Constants.ERR_INVALID_MIN_LENGTH + " : a", result.getErrorMessage());
	}

	@Test
	public void test_MissingFileName()
	{
		String[] args = new String[]{Constants.DELIMITER_COMMAND, ".!?", Constants.MIN_LENGTH_COMMAND, "5"};
		ArgResult result = new ArgProcessor(args).process();
		assertEquals(Constants.ERR_INVALID_COMMAND, result.getErrorMessage());
	}

	@Test
	public void test_WrongFilePath()
	{
		String[] args = new String[]{Constants.DELIMITER_COMMAND, ".!?", Constants.MIN_LENGTH_COMMAND, "5", "input.txt"};
		ArgResult result = new ArgProcessor(args).process();
		assertEquals(Constants.ERR_FILE_DOES_NOT_EXIST + " : input.txt", result.getErrorMessage());
	}

	@Test
	public void test_MissingDelimiterArgument()
	{
		String[] args = new String[]{Constants.DELIMITER_COMMAND, Constants.MIN_LENGTH_COMMAND, "5", fileDir + "input.txt"};
		ArgResult result = new ArgProcessor(args).process();
		// -d -l is  valid (-l are delimiters), but then the length is missing
		assertEquals(Constants.ERR_INVALID_COMMAND, result.getErrorMessage());
	}

	@Test
	public void test_CorrectInput()
	{
		String[] args = new String[]{Constants.DELIMITER_COMMAND, ".!?", Constants.MIN_LENGTH_COMMAND, "5", fileDir};
		ArgResult result = new ArgProcessor(args).process();
		assertEquals(null, result.getErrorMessage());
		assertEquals(Status.RUN, result.getStatus());
		assertEquals(".!?", result.getAvgSentenceLength().getSentenceDelimiters());
		assertEquals(5, result.getAvgSentenceLength().getMinWordLength());
	}
}
