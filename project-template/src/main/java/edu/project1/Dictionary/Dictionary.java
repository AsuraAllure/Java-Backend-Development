package edu.project1.Dictionary;

public interface Dictionary {
    public String getWord() throws EmptyDicionary;
    public void refresh();
}
