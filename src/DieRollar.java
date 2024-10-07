import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

public class DieRollar {
    static ArrayList<Integer> rollDices() {
        ArrayList<Integer> localRolls = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            localRolls.add(random.nextInt(6) + 1);
        }
        return  localRolls;
    }

    static boolean checkWin(ArrayList<Integer> rolls) {
        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();

        // Create our hashmap of occurrences
        for (Integer roll : rolls) {
            if (table.containsKey(roll)) {
                table.put(roll, table.get(roll)+1);
            } else {
                table.put(roll, 1);
            }
        }
        System.out.println(table);
        // Check if we got a triple, there can only be one set
        for (int key : table.keySet()) {
            if (table.get(key) == 3) {
                return true;
            }
        }

        return false;

    }

    // Helper func for generateTable
    static String makeSpaces(int amount) {
        String spaces = "";
        for (int i = 0; i < amount; i++) {
            spaces += " ";
        }

        return spaces;
    }

    static void generateTable(ArrayList<ArrayList<Integer>> rolls ) {
        int spaces = 5;
        System.out.println("Roll" + makeSpaces(spaces) + "Die1" + makeSpaces(spaces) + "Die2" + makeSpaces(spaces) + "Die3" + makeSpaces(spaces) + "Sum");
        System.out.println("---------------------------------------");
        int i = 1;
        for (ArrayList<Integer> roll : rolls) {
            System.out.print();
            for (Integer rollNum : roll) {
                System.out.print(rollNum + makeSpaces(spaces));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> rolls = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> roll1 = rollDices();
        rolls.add(rollDices());
        System.out.println(roll1);
        boolean result = checkWin(roll1);
        generateTable(rolls);
    }
}
