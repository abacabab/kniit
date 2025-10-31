package org.kniit.lab6.task10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("misc/dictionary.txt"));
        List<String> words = new ArrayList<String>();
        int ind = 0;
        while (ind < 100) {
            if (sc.nextLine().length() > 4) {
                words.add(sc.nextLine());
                ind++;
            }
        }
        Random rand = new Random();
        String word =  words.get(rand.nextInt(words.size()));
        int attempts = 6;
        List<Character> curState = new ArrayList<Character>(word.length());
        for (int i = 0; i < word.length(); i++) {
            curState.add('_');
        }
        Set<Character> guessed = new HashSet<>();
        while (attempts != 0){
            System.out.print("Загаданное слово: ");
            curState.forEach(c -> System.out.print(c + " "));
            System.out.println();
            System.out.print("Введите букву: ");
            Scanner sc2 = new Scanner(System.in);
            char letter = sc2.next().charAt(0);
            if (guessed.contains(letter)) {
                System.out.println("Данная буква уже вводилась.");
                continue;
            }
            guessed.add(letter);
            if (word.contains(String.format("%c", letter))){
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter){
                        curState.set(i, letter);
                    }
                }
                if (!curState.contains('_')){
                    break;
                }
            }
            else{
                System.out.printf("Неверно! Осталось попыток: %d%n", --attempts);
            }
        }

        System.out.println(attempts == 0 ? "Вы проиграли" : "Победа!");
        System.out.printf("Слово: %s", word);
    }
}
