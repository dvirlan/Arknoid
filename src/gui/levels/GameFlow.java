//208388140
package gui.levels;
/**
 * @author Dvir Landau
 * @version 1.00 20/06/2021
 */
import biuoop.GUI;
import biuoop.KeyboardSensor;
import gui.animation.AnimationRunner;
import gui.animation.EndGameOver;
import gui.animation.EndScreenWin;
import gui.animation.KeyPressStoppableAnimation;
import gui.game.Counter;
import gui.game.GameLevel;
import java.util.List;

/**
 * GameFlow Class.
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private GUI gui;
    private Counter score;

    /**
     * GameFlow Class.
     * @param ar - AnimationRunner
     * @param ks - KeyboardSensor
     * @param g - GUI
     * @param s - Counter
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI g, Counter s) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.gui = g;
        this.score = s;

    }

    /**
     * runLevels.
     * @param levels - List<LevelInformation>
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, this.gui, this.score);

            level.initialize();

            while (level.getBallsCounter().getValue() != 0 && level.getBlocksCounter().getValue() != 0) {
                level.run();
            }

            if (level.getBallsCounter().getValue() == 0) {
                // this.animationRunner.run(new EndGameOver(this.score, this.keyboardSensor));
                this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                        KeyboardSensor.SPACE_KEY, new EndGameOver(this.score, this.keyboardSensor)));
                gui.close();
            }

        }
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                KeyboardSensor.SPACE_KEY, new EndScreenWin(this.score, this.keyboardSensor)));
        gui.close();
    }
}
