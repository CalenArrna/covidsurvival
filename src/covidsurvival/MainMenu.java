package covidsurvival;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static covidsurvival.GameRunner.gameWindow;

public class MainMenu extends JPanel implements ActionListener {
    public static final Font mainMenuFont = new Font("Arial", Font.PLAIN, 18);

    static Sound sound = new Sound();
    JButton newGame = new JButton("New game");
    JButton resume = new JButton("Resume game");
    JButton settings = new JButton("How to play");
    JButton exit = new JButton("exit");
    JButton mainMenu = new JButton("main menu");
    CardLayout layout = new CardLayout();
    JPanel panel = new JPanel();
    JPanel game = new JPanel();
    JPanel menu = new JPanel();
    public boolean isRun = false;

    public MainMenu() {
        panel.setLayout(layout);
        addButtons();
        sound.playBGMSound(Sound.openSound(Sound.bgm));
    }

    private void addButtons() {
        newGame.addActionListener(this);
        newGame.setBackground(Color.BLACK);
        newGame.setForeground(Color.WHITE);

        resume.addActionListener(this);
        if (!isRun) {
            resume.setBackground(Color.BLACK);
            resume.setForeground(Color.GRAY);
        } else {
            resume.setBackground(Color.BLACK);
            resume.setForeground(Color.WHITE);
        }

        settings.addActionListener(this);
        settings.setBackground(Color.BLACK);
        settings.setForeground(Color.WHITE);

        exit.addActionListener(this);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);

        mainMenu.addActionListener(this);
        mainMenu.setBackground(Color.BLACK);
        mainMenu.setForeground(Color.WHITE);

        menu.add(resume).setFont(mainMenuFont);
        menu.add(newGame).setFont(mainMenuFont);
        menu.add(settings).setFont(mainMenuFont);
        menu.add(exit).setFont(mainMenuFont);
        menu.setBackground(Color.BLACK);

        game.add(mainMenu);

        panel.add(menu, "Menu");
        panel.add(game, "Game");

        add(panel);
        layout.show(panel, "Menu");
    }


    @Override
    public void actionPerformed(ActionEvent event) {

        Object source = event.getSource();

        if (source == exit) {
            System.exit(0);
        } else if (source == newGame) {
            GameRunner.setGameWindow(new GameWindow());
            this.setVisible(false);
            isRun = true;
            sound.stopLoop();
        } else if (source == resume) {
            gameWindow.startTimer();
            gameWindow.setVisible(true);
            this.setVisible(false);
            sound.stopLoop();
        } else if (source == settings) {
            layout.show(settings, "Menu");
        } else if (source == mainMenu) {
            layout.show(panel, "Menu");
        }
    }
}