package gui.levels;

import biuoop.GUI;
import gui.animation.AnimationRunner;
import gui.game.Counter;


import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        GUI gui = new GUI("Animation", 800, 600);
        List<LevelInformation> levels = new ArrayList<>();
        levels.add(new DirectHit());
        levels.add(new WideEasy());
       levels.add(new Green3());
        levels.add(new FinalFour());
        GameFlow gameF = new GameFlow(new AnimationRunner(gui), gui.getKeyboardSensor(), gui, new Counter(0));
        gameF.runLevels(levels);
    }
}
