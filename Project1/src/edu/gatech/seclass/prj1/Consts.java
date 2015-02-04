package edu.gatech.seclass.prj1;

/**
 * Constants of general utility
 */
public final class Consts 
{
	/* Default input parameters  */
	public static final int MIN_WORD_LENGTH = 3;
	public static final String SENTENCE_DELIMITERS = ".?!";
	
	/* Error Messages  */
	public static final String ERR_MISSING_DELIMITERS = "Missing delimiters";
	public static final String ERR_MIN_LENGTH_SHOULD_BE_GREATER_THAN_0 = "min_length should be greater than 0";
	public static final String ERR_INVALID_MIN_LENGTH = "Invalid min_length: ";
	public static final String ERR_MISSING_MIN_LENGTH = "Missing min_length";
	public static final String ERR_FILE_DOES_NOT_EXIST = "Specified file does not exist";
	public static final String ERR_FILE_NAME_MISSING = "Missing filename";
    
    /* Error Messages using format string */
    public static final String OUT_AVERAGE_NUMBER = "Average number of words per sentence in the file %s: %d\n";
    public static final String ERR_COULD_NOT_START_CALCULATION = "Could not start calculation: %s\n";
}
