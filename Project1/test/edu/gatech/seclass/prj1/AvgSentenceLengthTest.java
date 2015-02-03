package edu.gatech.seclass.prj1;

import static org.junit.Assert.assertEquals;

import java.io.File;

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
    public void testComputeAverageSentenceLength4() {
        String comment = "Testing empty file";
        asl.setFile(new File(fileDir + "emptyFile.txt"));
        assertEquals(comment, 0, asl.computeAverageSentenceLength(), 0);
    }
    @Test
    public void testComputeAverageSentenceLength5() {
        String comment = "Testing file with no delimiters";
        asl.setFile(new File(fileDir + "noDelimiters.txt"));
        assertEquals(comment, 13, asl.computeAverageSentenceLength(), 0);
    }
}
