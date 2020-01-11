package flashcards;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    final static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        getCards();
    }

    // First, ask the player to enter the desired number of cards.
    // Then, ask to input the term and the definition of every card.
    private static void getCards() {
        System.out.println("Input the number of cards: ");
        int cards = sc.nextInt();
        sc.nextLine(); // clear \n
        String terms = "";
        String definitions = "";
        Map<String, String> myMap = new LinkedHashMap<>();


        for (int i = 0; i < cards; i++) {
            System.out.println("The card #" + (i + 1) + ": ");

            terms = readln();

            if(myMap.containsKey(terms)){
                System.out.println("The card \"" + terms +"\" already exists. Try again:");
                terms = readln();
            }

            System.out.println("The definition of the card #" + (i + 1) + ": ");
            definitions = readln();


            if(myMap.containsValue(definitions)){
                System.out.println("The definition \"" + definitions + "\" already exists. Try again:");
                definitions = readln();
            }

            myMap.put(terms, definitions);
        }

        play(myMap);

    }

    // Question the player about all the new words they have entered.
    // The program should give the term and ask for a definition.
    private static void play(Map<String, String> tempMap) {
        int len = tempMap.size();
        Object[] terms = tempMap.keySet().toArray();
        Object[] definitions = tempMap.values().toArray();
        String answer;
        String correct = "Correct answer.";
        String wrong = "Wrong answer. The correct one is \"";

        for (int i = 0; i < len; i++) {
            System.out.println("Print the definition of \"" + terms[i] + "\": ");
            answer = sc.nextLine();

           if(answer.equals(definitions[i])){
               System.out.println(correct);
           }else if(tempMap.containsValue(answer)){
               System.out.println("Wrong answer. The correct one is \"" + definitions[i] + "\", you've just written the definition of \""+ getKeyFromValue(tempMap, answer) + "\".");
           }else{
               System.out.println(wrong + definitions[i] + "\".");
           }
        }
    }

    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

    public static String readln(){
        String tmp = sc.nextLine();
        return tmp;
    }


}
