package org.kniit.lab4.task7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


class DictionaryStatistic {
    private String[] words;
    private int dictionarySize; // Количество слов
    private int palindrom = 0; // Количество слов полиндромов
    private int maxWordLength; // маскимальная длина слова в словаре
    private int minWordLength; // минимальная длина слова в словаре
    private char[] alphabet; // буквы алфавита
    private int[] frequency = new int[32]; //частота букв в словаре (в кадой ячейке хранит частоту букв, а индрес - это позиция буквы в alpabet)

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;
        this.dictionarySize = words.length;
        Arrays.fill(frequency, 0);
        Arrays.sort(this.words, Comparator.comparingInt(String::length));
        this.maxWordLength = words[this.dictionarySize - 1].length();
        this.minWordLength = words[0].length();
        for (int i = 0; i < this.dictionarySize; i++) {
            String word_rev = "";
            for (int j = words[i].length() - 1; j >= 0; j--){
                word_rev +=  words[i].charAt(j);
            }
            if (words[i].equals(word_rev)) {
                palindrom++;
            }
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) <= 'я' && words[i].charAt(j) >= 'а') {
                    frequency[words[i].charAt(j) - 'а']++;
                }
            }
        }
    }

    // получить случайное слово из словаря
    public String getRandomWord() {
        return words[(int) (Math.random() * words.length)];
    }

    public int getPalindrom() {
        return this.palindrom;
    }

    public int getMaxWordLength() {
        return this.maxWordLength;
    }
    public int getMinWordLength() {
        return this.minWordLength;
    }

    public void printSymbolsStat() {
        for (int i = 0; i < this.frequency.length; i++) {
            System.out.println(alphabet[i] + " - " +  frequency[i]);
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("misc/dictionary.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String> dictionary = new ArrayList<>();
        char[] alph = new char[32];
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            dictionary.add(word);
        }
        scanner.close();
        for (char i = 'а'; i <= 'я'; i++) {
            alph[i - 'а'] = i;
        }
        DictionaryStatistic dict = new DictionaryStatistic(Arrays.copyOf(dictionary.toArray(), dictionary.toArray().length, String[].class), alph);
        dict.printSymbolsStat();
        System.out.println(dict.getRandomWord());
        System.out.println(dict.getPalindrom());
        System.out.println(dict.getMaxWordLength());
    }
}
