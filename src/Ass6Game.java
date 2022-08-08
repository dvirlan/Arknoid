// 208388140

import biuoop.GUI;
import biuoop.KeyboardSensor;
import gui.animation.AnimationRunner;
import gui.game.Counter;
import gui.levels.DirectHit;
import gui.levels.FinalFour;
import gui.levels.GameFlow;
import gui.levels.Green3;
import gui.levels.LevelInformation;
import gui.levels.WideEasy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dvir Landau
 * @version 1.00 13/06/2021
 */
public class Ass6Game {
    /**
     * Main.
     *
     * @param args - args
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner ar = new AnimationRunner(gui);
        KeyboardSensor ks = gui.getKeyboardSensor();
        GameFlow g = new GameFlow(ar, ks, gui, new Counter(0));
        List<LevelInformation> levelInfo = new ArrayList<>();
        // if there are no arguments.
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "1":
                    levelInfo.add(new DirectHit());
                    break;
                case "2":
                    levelInfo.add(new WideEasy());
                    break;
                case "3":
                    levelInfo.add(new Green3());
                    break;
                case "4":
                    levelInfo.add(new FinalFour());
                    break;
                default:
                    break;
            }
        }
        if (levelInfo.size() == 0) {
            levelInfo.add(new DirectHit());
            levelInfo.add(new WideEasy());
            levelInfo.add(new Green3());
            levelInfo.add(new FinalFour());
        }
        g.runLevels(levelInfo);
    }

}


