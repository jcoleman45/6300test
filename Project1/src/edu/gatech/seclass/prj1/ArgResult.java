package edu.gatech.seclass.prj1;

/**
 * Represents the result of processing the command-line arguments.
 */
public class ArgResult
{

	private final String errorMessage;
	private final Status status;
	private final AvgSentenceLength avgSentenceLength;

	/**
	 * Instantiate a result with the given error message and status. The {@code AvgSentenceLength} field is set
	 * to null.
	 *
	 * @param errorMessage error message
	 */
	public ArgResult(String errorMessage, Status status)
	{
		this.avgSentenceLength = null;
		this.errorMessage = errorMessage;
		this.status = status;
	}

	/**
	 * Instantiate a result with the given {@code AvgSentenceLength} instance and a RUN status.
	 * The error message is set to null.
	 */
	public ArgResult(AvgSentenceLength avgSentenceLength)
	{
		this.avgSentenceLength = avgSentenceLength;
		this.errorMessage = null;
		this.status = Status.RUN;
	}

	/**
	 * Return the application status.
	 *
	 * @return desired status
	 */
	public Status getStatus()
	{
		return status;
	}

	/**
	 * Returns the stored error error message
	 *
	 * @return error message, might be {@code null}
	 */
	public String getErrorMessage()
	{
		return errorMessage;
	}

	/**
	 * Return the configured {@code AvgSentenceLength} instance.
	 *
	 * @return instance of the {@code AvgSentenceLength} class configured with command-line arguments
	 */
	public AvgSentenceLength getAvgSentenceLength()
	{
		return avgSentenceLength;
	}
}
