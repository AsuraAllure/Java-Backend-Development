package edu.project1.Dictionary;

import java.util.HashMap;
import java.util.Map;

public class StandartDictionary implements Dictionary{
    // Словарь, где в соответствие слову ставится логическое значение
    // true - слово использовалось, false - не использовалось.
    private final Map<String, Boolean> dictionary;
    public StandartDictionary(){
        this.dictionary = new HashMap<>() {{
            put("pizza", false);
            put("cake", false);
            put("pineapple", false);
        }};
    }

    protected StandartDictionary(Map<String, Boolean> dict){
        this.dictionary = dict;
    }

    @Override
    public String getWord() throws EmptyDicionary {
        for(var key: dictionary.entrySet())
            if (!key.getValue()){
                dictionary.put(key.getKey(), true);
                return key.getKey();
            }
        throw new EmptyDicionary();
    }

    @Override
    public void refresh() {
        dictionary.replaceAll((k, v) -> false);
    }
}
