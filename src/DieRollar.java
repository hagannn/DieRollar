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

    static int getSum(ArrayList<Integer> rolls) {
        int sum = 0;
        for (Integer i : rolls) {
            sum += i;
        }
        return sum;
    }

    static void generateTable(ArrayList<ArrayList<Integer>> rolls ) {
        int sum = 0;
        int spaces = 7;
        System.out.println("Roll" + makeSpaces(4) + "Die1" + makeSpaces(4) + "Die2" + makeSpaces(4) + "Die3" + makeSpaces(4) + "Sum");
        System.out.println("---------------------------------------");
        int i = 1;
        for (ArrayList<Integer> roll : rolls) {
            System.out.print(i + makeSpaces(spaces));
            for (Integer rollNum : roll) {
                System.out.print(rollNum + makeSpaces(spaces));
            }
            System.out.print(getSum(roll));
            System.out.println();
            i += 1;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> rolls = new ArrayList<ArrayList<Integer>>();

        boolean playing = true;

        while (playing) {
            ArrayList<Integer> roll = rollDices();
            rolls.add(roll);

            playing = !checkWin(roll);
        }
        generateTable(rolls);
    }
}
