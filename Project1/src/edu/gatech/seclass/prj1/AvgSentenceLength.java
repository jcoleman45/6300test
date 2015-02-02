package edu.gatech.seclass.prj1;

import java.io.File;

/**
 * Null implementation.
 */
public class AvgSentenceLength {
    private File file;
    private String sentenceDelimiters;
    private int minWordLength;

    public double computeAverageSentenceLength() {
        return 0;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setSentenceDelimiters(String sentenceDelimiters) {
        this.sentenceDelimiters = sentenceDelimiters;
    }

    public String getSentenceDelimiters() {
        return sentenceDelimiters;
    }

    public void setMinWordLength(int minWordLength) {
        this.minWordLength = minWordLength;
    }

    public int getMinWordLength() {
        return minWordLength;
    }
}
