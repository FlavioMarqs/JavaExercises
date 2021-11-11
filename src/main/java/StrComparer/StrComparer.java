package StrComparer;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Locale;

public class StrComparer {

    public StrComparer()
    {
    }

    public boolean isWithin(String original, String comparison)
    {
        if(comparison.length() < original.length())
            return false;

        HashMap<String, Integer> originalOccurences = splitIntoOccurences(original);
        HashMap<String, Integer> comparisonOccurences = splitIntoOccurences(comparison);

        boolean success = true;

        if(comparisonOccurences.keySet().size() < originalOccurences.keySet().size())
            return false;

        for (var key : comparisonOccurences.keySet())
        {
            if(key != null)
                if(!originalOccurences.containsKey(key) || originalOccurences.get(key) < comparisonOccurences.get(key))
                {
                    success = false;
                    break;
                }
        }

        return success;
    }

    private HashMap<String, Integer> splitIntoOccurences(String phrase)
    {
        HashMap<String, Integer> letterOccurences = new HashMap<String, Integer>();
        char[] letters = phrase.toLowerCase(Locale.ROOT).toCharArray();

        for (char key : letters)
        {
            String letter = ""+key+"";
            Integer value;
            if(letterOccurences.containsKey(letter))
            {
                value = letterOccurences.get(letter)+1;
            }
            else
            {
                value = 0;
            }

            letterOccurences.put(letter, value+1);
        }

        return letterOccurences;
    }
}
