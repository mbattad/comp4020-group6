package actions;

import java.util.Scanner;

import jp.vstone.RobotLib.CRobotMem;
import jp.vstone.RobotLib.CPlayWave;
import jp.vstone.sotatalk.TextToSpeechSota;

public class ControlSota {

    public static void main(String [] args) {
        CRobotMem mem = new CRobotMem();
        Scanner scanner = new Scanner(System.in);

        if(!mem.Connect()) {
           System.out.println("Error connecting to robot's memory");
        }

        System.out.println("User's name: ");
        String username = scanner.nextLine();

        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String command = input.split(" ")[0];

            switch(command) {
                case "hi":
                    // Sota says "hi" to the user
                    System.out.println("Greeting user "+username);
                    CPlayWave.PlayWave(TextToSpeechSota.getTTS("ハイ"+username));
                    break;
                case "bye":
                    // Sota says "bye" to the user
                    System.out.println("Exiting");
                    CPlayWave.PlayWave(TextToSpeechSota.getTTS("バイ"));
                    break;
                default:
                    break;
            }
        }

        scanner.close();
    }
}