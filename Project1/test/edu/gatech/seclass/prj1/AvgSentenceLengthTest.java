package edu.gatech.seclass.prj1;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AvgSentenceLengthTest {
	
    private AvgSentenceLength asl;
    private String fileDir;
    
    @Before
    public void setUp() throws Exception {
        asl = new AvgSentenceLength();
        fileDir = "test" + File.separator + "inputfiles" + File.separator;        
    }
    @After
    public void tearDown() throws Exception {
        asl = null;
        fileDir = null;        
    }
    // -- START OF PROVIDED TEST CASES, DON'T CHANGE THESE --
    @Test
    public void testComputeAverageSentenceLength1() {
        String comment = "Testing sentences that span multiple lines";
        asl.setFile(new File(fileDir + "input.txt"));
        assertEquals(comment, 7, asl.computeAverageSentenceLength(), 0);
    }
    @Test
    public void testComputeAverageSentenceLength2() {
        String comment = "Testing customized delimiters";
        asl.setFile(new File(fileDir + "input.txt"));
        asl.setSentenceDelimiters("%.");
        assertEquals(comment, 3, asl.computeAverageSentenceLength(), 0);
    }
    @Test
    public void testComputeAverageSentenceLength3() {
        String comment = "Testing customized minimal word length";
        asl.setFile(new File(fileDir + "input.txt"));
        asl.setMinWordLength(5);
        assertEquals(comment, 3, asl.computeAverageSentenceLength(), 0);
    }
    // -- END OF PROVIDED TEST CASES --
    
    @Test
    public void testJoinLines_MultipleLines() {
    	List<String> lines = Arrays.asList("Line 1", "Line 2", "Line 3", "Line 4");
    	String joinedLine = asl.joinLines(lines, " ");
    	assertEquals("Line 1 Line 2 Line 3 Line 4", joinedLine);
    }
    
    @Test
    public void testJoinLines_SingleLine() {
    	List<String> lines = Arrays.asList("Line");
    	String joinedLine = asl.joinLines(lines, "#");
    	assertEquals("Line", joinedLine);
    }
    
    @Test
    public void testJoinLines_NoLine() {
        List<String> lines = new ArrayList<String>();
    	String joinedLine = asl.joinLines(lines, "@");
    	assertEquals("", joinedLine);
    }
    
    @Test
    public void testJoinLines_NoDelimiter() {
    	List<String> lines = Arrays.asList("Line 1", "Line 2", "Line 3");
    	String joinedLine = asl.joinLines(lines, "");
    	assertEquals("Line 1Line 2Line 3", joinedLine);    	
    }
    
    @Test
    public void testJoinLines_NullChecks() {
    	List<String> lines1 = Arrays.asList("Line 1", "Line 2");
    	String joinedLine1 = asl.joinLines(lines1, null);
    	assertEquals(null, joinedLine1);
    	
    	String joinedLine2 = asl.joinLines(null, " ");
    	assertEquals(null, joinedLine2);
    }

    @Test
    public void testComputeAverage_NullCheck() {
    	long average = asl.computeAverage(null);
    	assertEquals(-1, average);
    }

    @Test
    public void testComputeAverage_EmptyString() {
    	List<String> lines = new ArrayList<String>();
    	long average = asl.computeAverage(lines);
    	assertEquals(0, average);
    }
    
    @Test
    public void testComputeAverage_MultipleSpacesTabsSepartedText() {
        String comment = "Testing multiple spaces separated file";
        List<String> list = Arrays.asList("Testing     multiple spaces  text.","Will   it      work?I	guess		it			will");
        assertEquals(comment, 2, asl.computeAverage(list), 0);
    }
    
    @Test
    public void testComputeAverage_NoDelimiters() {
    	List<String> lines = Arrays.asList("This is sentence 1\n", "This is a bigger sentence 2\n", "This is the biggest sentence of all and it is sentence 3");
    	long average = asl.computeAverage(lines);
    	assertEquals(12, average);
    }
    
    @Test
    public void testComputeAverage_GoodText() {
    	List<String> lines = Arrays.asList("This is sentence 1.\n", "Is this a bigger sentence 2?\n", "This is the biggest sentence of all and it is sentence 3!");
    	long average = asl.computeAverage(lines);
    	assertEquals(4, average);
    }
    
    @Test
    public void testComputeAverage_TooManyDelimiters() {
    	List<String> lines = Arrays.asList("This is sentence 1...\n", "Is this a bigger bigger sentence 2??\n", "This is the biggest sentence of all and it is sentence 3!");
    	long average = asl.computeAverage(lines);
    	assertEquals(2, average);
    }    
    
    @Test
    public void testComputeAverage_numbers() {
        String comment = "Testing file with numbers";
        List<String> list = new ArrayList<String>();
        list.add("This file is to test files with numbers inside.");
        list.add("Generate random sequence from 123456:");
        list.add("123465, 123546, 123564, 123645, 123654....");
        assertEquals(comment, 8, asl.computeAverage(list), 0);
    }
    
    @Test
    public void testComputeAverage_table() {
        String comment = "Testing file with a table";
        List<String> table = new ArrayList<String>();
        table.add("This file contains a table:");
        table.add("----------------------------------------------------------------------");
        table.add("|project manager    | setting goals and tracking the whole progress. |");
        table.add("---------------------------------------------------------------------|");
        table.add("|Development Lead   | writes the Java code for the Java application. |");
        table.add("---------------------------------------------------------------------|");
        table.add("|Documentation Lead | manages the various documents.                 |");
        table.add("---------------------------------------------------------------------|");
        table.add("|QA Manager         | prepare test cases and write test code.        |");
        table.add("----------------------------------------------------------------------");
        asl.setSentenceDelimiters(":.");
        assertEquals(comment, 7, asl.computeAverage(table), 0);
    }    

    @Test
    public void testComputeAverageSentenceLength_EmptyFile() {
        String comment = "Testing empty file";
        asl.setFile(new File(fileDir + "emptyFile.txt"));
        assertEquals(comment, 0, asl.computeAverageSentenceLength(), 0);
    }
    
    @Test
    public void testComputeAverageSentenceLength_NoDelimiters() {
        String comment = "Testing file with no delimiters";
        asl.setFile(new File(fileDir + "noDelimiters.txt"));
        assertEquals(comment, 13, asl.computeAverageSentenceLength(), 0);
    }
    
    @Test
    public void testComputeAverageSentenceLength_LongEssay() {
        String comment = "Testing with long student essay";
        asl.setFile(new File(fileDir + "SampleEssay.txt"));
        assertEquals(comment, 15, asl.computeAverageSentenceLength(), 0);
    }
}
