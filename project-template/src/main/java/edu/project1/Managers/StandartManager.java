package edu.project1.Managers;

import edu.project1.GameEnum.GameState;
import edu.project1.GameEnum.GuessEnum;
import edu.project1.HangmanWords.HangmanWords;
import edu.project1.HangmanWords.StandartHangmanWord;
import edu.project1.Representers.Representer;
import edu.project1.Representers.StandartRepresenter;


public class StandartManager implements GameManager{
    private HangmanWords hWord;
    private final Representer repr;
    private final int maxCountMiss;
    private int curCountMiss = 0;
    public StandartManager(){
        repr = new StandartRepresenter();
        maxCountMiss = 5;
    }
    public StandartManager(int countStep, Representer repr){
        maxCountMiss = countStep;
        this.repr = repr;
    }
    @Override
    public void setWord(String word) {
        if (word.length() > 12)
            throw new TooLongWord();
        if (word.length() < 4)
            throw new TooSmallWord();
        curCountMiss = 0;
        hWord = new StandartHangmanWord(word);
    }
    @Override
    public void setWord(HangmanWords word) {
        if (word.getLength() > 12)
            throw new TooLongWord();
        if (word.getLength() < 4)
            throw new TooSmallWord();
        curCountMiss = 0;
        hWord = word;
    }
    @Override
    public GameState guessLetter(Character a) {
        if (curCountMiss == maxCountMiss)
            return GameState.LOSE;
        if (hWord.isGuessed())
            return GameState.WIN;

        repr.guessMessage();

        GuessEnum curState = hWord.guess(a);
        switch (curState){
            case HIT -> repr.hitMessage();
            case MISS -> {
                curCountMiss += 1;
                repr.missMessage(curCountMiss, maxCountMiss);
            }
        }
        repr.printReprWord(hWord.getRepresentWord());

        if (curCountMiss == maxCountMiss) {
            repr.loseMessage();
            return GameState.LOSE;
        }

        if (hWord.isGuessed()) {
            repr.winMessage();
            return GameState.WIN;
        }
        return GameState.GAME;
    }

}
