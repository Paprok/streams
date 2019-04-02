package com.codecool;


import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringFiltr
{


    public List<String> filtrate(List<Predicate<String>> rules, List<String> words){
        return words.stream().filter(passAllRules(rules)).collect(Collectors.toList());
    }

    private Predicate<String> passAllRules(List<Predicate<String>> rules){
        return rules.stream().reduce(Predicate::and).orElse(x -> true);
    }

    public List<String> filtrate(List<Predicate<String>> rules, List<String> words, Double threshold){
        return words.stream().filter(word -> passThreshold(word, rules, threshold)).collect(Collectors.toList());
    }

    boolean passThreshold(String word, List<Predicate<String>> rules, Double threshold){
        int passing = rules.stream().map(predicate -> predicate.test(word))
                .mapToInt(isPassing -> isPassing ? 1 : 0)
                .reduce(0, Integer::sum);
        return (double)passing/rules.size() >= threshold;
    }

}
