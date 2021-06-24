package ua.training;

/**
 * Model of the program.
 *
 * @version 1.0 24 June 2021
 * @author Yaroslav Avramenko
 */
public class Model {
    private String sentence;

    /**
     * Constructs a sentence from two halves and a separator.
     * @param secondHalfString A word that is second half of the sentence.
     * @return Constructed string.
     */
    public String constructSentence(String secondHalfString, char separator){
        return sentence += separator + secondHalfString;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
