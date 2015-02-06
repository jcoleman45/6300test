package edu.gatech.seclass.prj1;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AvgSentenceLengthTest 
{
    private AvgSentenceLength asl;
    private String fileDir;
    
    @Before
    public void setUp() throws Exception 
    {
        asl = new AvgSentenceLength();
        fileDir = "test" + File.separator + "inputfiles" + File.separator;        
    }
    
    @After
    public void tearDown() throws Exception 
    {
        asl = null;
        fileDir = null;        
        System.setSecurityManager(null); // or save and restore original
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
    public void testComputeAverageSentenceLength_EmptyFile()
    {
        String comment = "Testing empty file";
        asl.setFile(new File(fileDir + "emptyFile.txt"));
        assertEquals(comment, 0, asl.computeAverageSentenceLength(), 0);
    }
    
    @Test
    public void testComputeAverageSentenceLength_NoDelimiters() 
    {
        String comment = "Testing file with no delimiters";
        asl.setFile(new File(fileDir + "noDelimiters.txt"));
        assertEquals(comment, 13, asl.computeAverageSentenceLength(), 0);
    }
    
    @Test
    public void testComputeAverageSentenceLength_LongEssay()
    {
        String comment = "Testing with long student essay";
        asl.setFile(new File(fileDir + "SampleEssay.txt"));
        assertEquals(comment, 15, asl.computeAverageSentenceLength(), 0);
    }
    
//	@Test
//    public void testMissingFileName() throws Exception
//    {	
//    	TBC
//    }
    
    @Test
    public void testComputeAverage_MultipleSpace()
    {
        String comment = "Testing multiple spaces separated file";
        List<String> list = new ArrayList<String>();
        list.add("Testing     multiple spaces  text.");
        list.add("Will   it      work?");
        assertEquals(comment, 3, asl.computeAverage(list), 0);
    }
    
    @Test
    public void testComputeAverage_numbers()
    {
        String comment = "Testing file with numbers";
        List<String> list = new ArrayList<String>();
        list.add("This file is to test files with numbers inside.");
        list.add("Generate random sequence from 123456:");
        list.add("123465, 123546, 123564, 123645, 123654....");
        assertEquals(comment, 8, asl.computeAverage(list), 0);
    }
    
    @Test
    public void testComputeAverage_table()
    {
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
}
