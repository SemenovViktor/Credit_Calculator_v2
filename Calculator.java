/**
 * Credit calculator v4
 */

import java.util.Scanner;

public class Calculator {
    private static String[] clientData;

    public static void main(String[] args) {
        System.out.println("Введите данные:");
        try (Scanner console = new Scanner(System.in)) {
            clientData = console.nextLine().split(" ");
        }

            if (clientData[3].equals("human")
                    && clientData.length == 4) {

                Consumer client = new Consumer();
                client.fillClientData(clientData);
                System.out.println(client.getOverPaid());
            }
            else if (clientData[3].equals("business")
                    && clientData.length == 4) {

                Consumer client = new Consumer();
                client.fillClientData(clientData);
                System.out.println(client.getOverPaid());
            }
            else {
                throw new IllegalArgumentException("Не правильно заполнены данные");

            }
    }
}