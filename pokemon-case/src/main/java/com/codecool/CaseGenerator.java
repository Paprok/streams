package com.codecool;



import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CaseGenerator {

    public static void main(String[] args) {
        CaseGenerator gen = new CaseGenerator();
        gen.changeToPokemon("karol trzaska").forEach(System.out::println);
    }

    public Stream<Character> changeToPokemon(String word) {
        char[] letters = word.toCharArray();
        return IntStream.range(0, letters.length)
                .mapToObj(index -> pokeMapper(index, letters));
    }

    public static Character pokeMapper(int index, char[] letters){
        if(index%2 == 0){
            return Character.toUpperCase(letters[index]);
        }
        else{
            return Character.toLowerCase(letters[index]);
        }
    }
}
