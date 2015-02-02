package edu.gatech.seclass.prj1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Calculates average number of words per sentence.
 */
public class AvgSentenceLength {
    
    private File file;
    private String sentenceDelimiters;
    private int minWordLength;

    /**
     * Construct a new average sentence length calculator using some default values for its properties:
     * <ul>
     *     <li>sentenceDelimiters = &quot;.?!&quot;</li>
     *     <li>minWordLength = 3</li>
     * </ul>* 
     */
    public AvgSentenceLength() {
        sentenceDelimiters = ".?!";
        minWordLength = 3;
        file = null;
    }

    /**
     * Compute the average number of words per sentence.
     * @return average sentence length, or -1 if there was a problem opening or reading the file
     */
    public long computeAverageSentenceLength() {
        try {
            List<String> lines = readLines(file);
            String text = joinLines(lines, " ");
            String[] sentences = text.split("[" + sentenceDelimiters + "]");
            long totalWords = 0;
            long sentenceCount = sentences.length;
            for (String sentence : sentences) {
                String[] words = sentence.trim().split(" ");
                for (String word : words) {
                    if(word.length() >= minWordLength) {
                        totalWords++;
                    }
                }
            }
            return totalWords / sentenceCount;
            
        } catch (IOException e) {
            return -1;
        }
    }

    /**
     * Set the file to be read from. 
     * @param file file with content to be analyzed
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Set the sentence separators to be used
     * @param sentenceDelimiters sentence delimiters
     */
    public void setSentenceDelimiters(String sentenceDelimiters) {
        this.sentenceDelimiters = sentenceDelimiters;
    }

    /**
     * Set the minimum word length. 
     * @param minWordLength set the minimum word length
     */
    public void setMinWordLength(int minWordLength) {
        this.minWordLength = minWordLength;
    }

    /**
     * Reads the content of the given file into a list of Strings. 
     * @param file file to read from
     * @return all lines of the file or an empty list if the file is empty
     * @throws IOException if the file cannot be opened or read from
     */
    private List<String> readLines(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<>();
        String line = reader.readLine();
        while(line != null) {
            lines.add(line);
            line = reader.readLine();
        }
        return lines;
    }

    /**
     * Join all strings in the given list using the specified delimiter. 
     * @param lines list of strings
     * @return all strings joined by the delimiter
     */
    private String joinLines(List<String> lines, String delimiter) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            builder.append(lines.get(i));
            if(i != lines.size() - 1) {
                builder.append(delimiter);
            }
        }
        return builder.toString();
    }

}
