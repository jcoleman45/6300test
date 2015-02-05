package edu.gatech.seclass.prj1;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.security.Permission;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AvgSentenceLengthTest 
{

    private AvgSentenceLength asl;
    private String fileDir;
    
    @SuppressWarnings("serial")
	protected static class ExitException extends SecurityException 
    {
        public final int status;
        public ExitException(int status) 
        {
            super("There is no escape!");
            this.status = status;
        }
    }
    
    private static class NoExitSecurityManager extends SecurityManager 
    {
        @Override
        public void checkPermission(Permission perm) 
        {
            // allow anything.
        }
        
        @Override
        public void checkPermission(Permission perm, Object context) 
        {
            // allow anything.
        }
        
        @Override
        public void checkExit(int status) 
        {
            super.checkExit(status);
            throw new ExitException(status);
        }
    }

    @Before
    public void setUp() throws Exception 
    {
        asl = new AvgSentenceLength();
        fileDir = "test" + File.separator + "inputfiles" + File.separator;        
        System.setSecurityManager(new NoExitSecurityManager());
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
    
    //Test - empty File
    @Test
    public void testComputeAverageSentenceLength_emptyFile()
    {
        String comment = "Testing empty file";
        asl.setFile(new File(fileDir + "emptyFile.txt"));
        assertEquals(comment, 0, asl.computeAverageSentenceLength(), 0);
    }
    
    //Test - file with no delimiters at all
    @Test
    public void testComputeAverageSentenceLength_noDelimiters() 
    {
        String comment = "Testing file with no delimiters";
        asl.setFile(new File(fileDir + "noDelimiters.txt"));
        assertEquals(comment, 13, asl.computeAverageSentenceLength(), 0);
    }
    
    //Test - Missing File Name
	@Test
    public void testMissingFileName() throws Exception
    {	
    	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outContent));        
        
        int exitStatus = 0;
    	try
    	{    		
    		String[] args = new String[1];
    		Main.main(args);
    	}
    	catch (ExitException e)
    	{
    		exitStatus = e.status;
    	}
    	
        assertEquals(1, exitStatus);
        assertEquals(true, outContent.toString().contains(Constants.ERR_FILE_NAME_MISSING));
    }
    
    //Test - multiple spaces separated text
    @Test
    public void testComputeAverage_MultipleSpace()
    {
        String comment = "Testing multiple spaces separated file";
        List<String> list = Arrays.asList("Testing     multiple spaces  text.","Will   it      work?");
        assertEquals(comment, 3, asl.computeAverage(list), 0);
    }
}
