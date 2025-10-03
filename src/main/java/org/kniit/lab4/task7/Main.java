package main.java.org.kniit.lab4.task7;

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
    private int[] frequency = new int[33]; //частота букв в словаре (в кадой ячейке хранит частоту букв, а индрес - это позиция буквы в alpabet)

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;
        this.dictionarySize = words.length;
        Arrays.fill(frequency, 0);
        Arrays.sort(this.words, Comparator.comparingInt(String::length));
        this.maxWordLength = words[this.dictionarySize - 1].length();
        this.minWordLength = words[0].length();
        for (int i = 0; i < this.dictionarySize; i++) {
            if (words[i].equals(words[i].substring(words[i].length() - 1, 0))) {
                palindrom++;
            }
            for (int j = 0; j < words[i].length(); j++) {
                frequency[words[i].charAt(j) - 'а']++;
            }
        }
    }

    // получить случайное слово из словаря
    public String getRandomWord() {
        return words[(int) (Math.random() * words.length)];
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
        List<String> list = new ArrayList<>();
        List<Character> alph = new ArrayList<>();
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            list.add(word);
        }
        scanner.close();
        for (char i = 'а'; i <= 'я'; i++) {
            alph.add(i);
        }
        DictionaryStatistic dict = new DictionaryStatistic(String[] list.toArray(), Character[] alph.toArray());
    }
}
