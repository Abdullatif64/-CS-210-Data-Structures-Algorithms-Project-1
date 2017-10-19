package Implementation;

import java.util.Scanner;

/**
 * Created by abdll on 10/18/2017.
 */

public class Test {

    public static void main(String[] args) {
        SRAList a = new SRAList();
        int id;
        String namest;
        double finals;
        double mid;
        Scanner userInput = new Scanner(System.in);
        int numberOfNodes = userInput.nextInt();
        int toRemove;
        for (int i = 0; i < numberOfNodes; i++) {
            id = userInput.nextInt();
            namest = userInput.next();
            mid = userInput.nextDouble();
            finals = userInput.nextDouble();
            a.add(new Node(id, namest, finals, mid));
        }
        toRemove = userInput.nextInt();
        while (toRemove != -1) {

            a.remove(a.search(toRemove));
            toRemove = userInput.nextInt();
        }

        System.out.println(a.toString());

        System.out.println(a.MedianMidTerm());
        System.out.println(a.toString());

        System.out.println(a.MedianFinal());
        System.out.println(a.toString());
        System.out.println(a.ComputeAboveAvg());
        System.out.println(a.ComputeAboveAvg());

    }

}
