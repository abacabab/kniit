package org.kniit.lab5.task9;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        long timeMillis = System.currentTimeMillis();
        int score = 0;
        int cnt = 0;
        int letterCnt = 0;
        Scanner scanner = new Scanner(System.in);
        String[] words = getWords().toArray(new String[0]);
        while (System.currentTimeMillis() <= timeMillis + 60000){
            Random random = new Random();
            String curWord = words[random.nextInt(words.length)];
            System.out.println(curWord);
            String input_word =  scanner.nextLine();
            if (System.currentTimeMillis() <= timeMillis + 60000){
                if (input_word.equals(curWord)) {
                    score++;
                }
            }
            else{
                cnt--;
                letterCnt -= input_word.length();
            }
            cnt++;
            letterCnt += input_word.length();
        }
        System.out.println("Слов было: " + cnt + "\nПравильных слов: " + score + "\nБукв напечатано: " +  letterCnt + "\nСкорость (символов в секунду): " +  letterCnt / 60);

    }

    public static List<String> getWords() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("misc/dictionary.txt"));
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        scanner.close();
        return words;
    }
}
