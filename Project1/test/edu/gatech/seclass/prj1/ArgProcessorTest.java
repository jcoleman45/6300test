package edu.gatech.seclass.prj1;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArgProcessorTest {
	
    private String fileDir; 

    @Before
    public void setUp() throws Exception {
    	fileDir = "test" + File.separator + "inputfiles" + File.separator; 
    }
    @After
    public void tearDown() throws Exception {
        fileDir = null;        
    }    
    
	@Test
	public void test_NoArguments() {
		String[] args = new String[] { };
		ArgResult result = new ArgProcessor(args).process();
		assertEquals(Constants.ERR_FILE_NAME_MISSING, result.getErrorMessage());
	}
	
	@Test
	public void test_MissingDelimiters() {
		String[] args = new String[] {"-d"};
		ArgResult result = new ArgProcessor(args).process();
		assertEquals(Constants.ERR_MISSING_DELIMITERS, result.getErrorMessage());
	}
	
	@Test
	public void test_MinimumWordLength() {
		String[] args = new String[] {"-d", ".!?", "-l", "-1", fileDir};
		ArgResult result = new ArgProcessor(args).process();
		assertEquals(Constants.ERR_MIN_LENGTH_SHOULD_BE_GREATER_THAN_0 + "-1", result.getErrorMessage());
	}
	
	@Test
	public void test_MissingMinimumLength() {
		String[] args = new String[] {"-d", ".!?", "-l"};
		ArgResult result = new ArgProcessor(args).process();
		assertEquals(Constants.ERR_MISSING_MIN_LENGTH, result.getErrorMessage());
	}
	
	@Test
	public void test_MissingFileName() {
		String[] args = new String[] {"-d", ".!?", "-l", "5"};
		ArgResult result = new ArgProcessor(args).process();
		assertEquals(Constants.ERR_FILE_NAME_MISSING, result.getErrorMessage());
	}
	
	@Test
	public void test_WrongFilePath() {
		String[] args = new String[] {"-d",".!?","-l","5","input.txt"};
		ArgResult result = new ArgProcessor(args).process();
		assertEquals(Constants.ERR_FILE_DOES_NOT_EXIST + ": input.txt", result.getErrorMessage());
	}
	
	@Test
	public void test_CorrectInput() {
		String[] args = new String[] {"-d",".!?","-l","5",fileDir};
		ArgResult result = new ArgProcessor(args).process();
		assertEquals(null, result.getErrorMessage());
	}
}
