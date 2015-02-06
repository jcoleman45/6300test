package edu.gatech.seclass.prj1;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class ArgProcessorTest {
	
    private String fileDir = "test" + File.separator + "inputfiles" + File.separator; 
    
	//-- test no arguments
	@Test
	public void test1() {
		String[] args = new String[]{};
		
		ArgResult result = new ArgProcessor(args).process();
		assertEquals("Missing filename",result.errorMessage);
	}
	
	//test missing delimiters
	@Test
	public void test2() {
		String[] args = new String[]{"-d"};
			
		ArgResult result = new ArgProcessor(args).process();
		assertEquals("Missing delimiters",result.errorMessage);
	}
	
	//test wrong minimum word length
	@Test
	public void test3() {
		String[] args = new String[]{"-d",".!?","-l", "-1",fileDir};
				
		ArgResult result = new ArgProcessor(args).process();
		assertEquals("min_length should be greater than 0-1",result.errorMessage);
	}
	
	//test missing minimum length
	@Test
	public void test4() {

		String[] args = new String[]{"-d",".!?","-l"};
				
		ArgResult result = new ArgProcessor(args).process();
		assertEquals("Missing min_length",result.errorMessage);
	}
	
	//test missing filename
	@Test
	public void test5() {
		String[] args = new String[]{"-d",".!?","-l", "5",null};
				
		ArgResult result = new ArgProcessor(args).process();
		assertEquals("Missing filename",result.errorMessage);
	}
	
	//test wrong file path
	@Test
	public void test6() {
		String[] args = new String[]{"-d",".!?","-l","5","input.txt"};
				
		ArgResult result = new ArgProcessor(args).process();
		assertEquals("Specified file does not exist: input.txt",result.errorMessage);
	}
	
	//test correct input
	@Test
	public void test7() {
		String[] args = new String[]{"-d",".!?","-l","5",fileDir};
				
		ArgResult result = new ArgProcessor(args).process();
		assertEquals(null,result.errorMessage);
	}
}
