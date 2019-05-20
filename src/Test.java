import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        Scanner in = new Scanner(System.in);
        int score = 0;

        for(int i = 0; i < 4; i++) {
            String question = br.readLine();
            System.out.println(question);
            String[] answers = new String[4];
            for(int j = 0; j < 4; j++) {
                answers[j] = br.readLine();
            }

            Random rgen = new Random();
            for (int j = 0; j < answers.length; j++) {
                int randPos = rgen.nextInt(answers.length);
                String tmp = answers[j];
                answers[j] = answers[randPos];
                answers[randPos] = tmp;
            }

            for(int j = 0; j < answers.length; j++) {
                System.out.println(j + ": "  + answers[j].substring(1));
            }

            boolean accepted = false;
            int userAnswer = 0;
            while(!accepted) {
                System.out.println("Please enter 0, 1, 2, or 3.");
                userAnswer = in.nextInt();
                if (userAnswer <= 3 && userAnswer >= 0) {
                    accepted = true;
                }
            }
            if(answers[userAnswer].charAt(0) == '1') {
                score++;
                System.out.println("correct!");
            } else{
                System.out.println("incorrect.");
            }
            System.out.println();
        }
        System.out.println("Your total score was " + score + " out of 4");
    }
}