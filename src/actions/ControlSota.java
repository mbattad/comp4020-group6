package actions;

import java.awt.Color;
import java.util.Scanner;

import jp.vstone.RobotLib.*;
import jp.vstone.camera.CRoboCamera;
import jp.vstone.sotatalk.MotionAsSotaWish;

public class ControlSota {

    public static void main(String [] args) {
        CRobotMem mem = new CRobotMem();
        CSotaMotion motion = new CSotaMotion(mem);
        MotionAsSotaWish freeMotion = new MotionAsSotaWish(motion);
        Scanner scanner = new Scanner(System.in);

        if(!mem.Connect()) {
           System.out.println("Error connecting to robot's memory");
        }

        motion.InitRobot_Sota();
        motion.ServoOn();

        CRoboCamera cam = new CRoboCamera("/dev/video0", motion);
        cam.StartFaceTraking();

        CRobotPose pose = CSotaMotion.getInitPose();
        pose.setLED_Sota(Color.BLUE, Color.BLUE, 0, Color.GREEN);
        motion.play(pose, 1000);
        motion.waitEndinterpAll();
        CPlayWave.PlayWave("../src/sound/cursor10.wav");

        boolean exit = false;
        System.out.println("Ready to accept commands!");
        do {
            String input = scanner.nextLine();
            String command = input.split(" ")[0];

            switch(command) {
                // Have Sota make the default pose
                case "d":
                    pose = CSotaMotion.getInitPose();
                    pose.setLED_Sota(Color.BLUE, Color.BLUE, 0, Color.GREEN);
                    motion.play(pose, 1000);
                    break;
                // Sota's pose when the user says something correct
                case "c":
                pose.SetPose(new Byte[] {1, 2, 3, 4, 5, 6, 7, 8},
                        new Short[] {0, 700, -250, -700, 250, 0, 0, 0});
                    pose.setLED_Sota(Color.GREEN, Color.GREEN, 0, Color.GREEN);
                    motion.play(pose, 1500);
                    CPlayWave.PlayWave("../src/sound/cursor10.wav");
                    break;
                // Sota's pose when the tuser says something incorrect
                case "i":
                    pose.SetPose(new Byte[] {1, 2, 3, 4, 5, 6, 7, 8},
                        new Short[]{0, -500, -900, 500, 900, 0, 0, 0});
                    pose.setLED_Sota(Color.RED, Color.RED, 0, Color.GREEN);
                    motion.play(pose, 1000);
                    break;
                case "dab":
                    pose.SetPose(new Byte[] {1, 2, 3, 4, 5, 6, 7, 8},
                        new Short[]{0, -500, -900, 500, -700, 250, 0, 0});
                    pose.setLED_Sota(Color.RED, Color.RED, 0, Color.GREEN);
                    motion.play(pose, 1500);
                    break;
                case "exit":
                    exit = true;
                    break; 
                default:
                    break;
            }
        } while(scanner.hasNextLine() && !exit);

        System.out.println("Exiting…");
        scanner.close();
        cam.StopFaceTraking();
        motion.ServoOff();
    }
}