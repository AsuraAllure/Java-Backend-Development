package edu.project1.Managers;

import edu.project1.GameEnum.GameState;
import edu.project1.HangmanWords.HangmanWords;

public interface GameManager {
     void setWord(String word) throws TooLongWord, TooSmallWord;
     void setWord(HangmanWords word) throws TooLongWord, TooSmallWord;
     GameState guessLetter(Character a);
}
