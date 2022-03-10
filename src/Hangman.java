import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import svu.csc213.Dialog;
import acm.graphics.GRect;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Hangman extends GraphicsProgram {
    private Man man;
    private WordBank word;
    private String randomWord;
    public GRect dash;
    private JButton guess;
    public String letter;
    private GLabel letters;
    private int wrong;

    //Letter Array
    private char[] chars;
    private GLabel[] charsLbl;


    @Override
    public void init(){
        man = new Man();
        word = new WordBank();
        guess = new JButton("guess");
        add(man);
        man.manBody();
        man.hanger();
        man.manGone();
        newGame();
        generate();
        makeDash();

        add(guess, 75, 100);




        addActionListeners();
    }
    private int tracker;
    private void generate(){
        randomWord = word.words[word.getRandomNumber()-1];
        System.out.println(randomWord);

        chars =  new char[randomWord.length()];

        charsLbl = new GLabel[chars.length];



        for (int i = 0; i < chars.length; i++) {
            chars[i] = randomWord.charAt(i);

            charsLbl[i] = new GLabel("" + chars[i]);
            add(charsLbl[i],50 * i +20, 350 );

            charsLbl[i].setVisible(false);

        }




        System.out.println(chars);




    }
    private void newGame(){
        word.roll();


    }


    void makeDash(){


        for (int j = 0; j < randomWord.length(); j++) {
            dash = new GRect(getWidth()*.05 , 1);
            add(dash, 50 * j +10, 350);

        }

    }


    //guessing thing
    private void guessingSystem(){
        letter = Dialog.getString("Enter A Letter");
        check();
    }

    @Override
    public void actionPerformed(ActionEvent ae){

        switch (ae.getActionCommand()){
            case "guess":
                guessingSystem();
                break;

        }
    }


    public void check(){
        if(randomWord.contains(letter)){
            for (int i = 0; i < randomWord.length(); i++) {
                if (randomWord.charAt(i) == letter.charAt(0)){
                    charsLbl[i].setVisible(true);
                    tracker += 1;


                }
            }



            if (tracker == randomWord.length()){
                Dialog.showMessage("You Won!!");
            }
        } else {

            if(!randomWord.contains(letter)){
                wrong += 1;}

            if(wrong == 1){
                man.head.setVisible(true);
            }else if(wrong == 2){
                man.body.setVisible(true);
            }else if(wrong == 3){
                man.armL.setVisible(true);
            }else if(wrong == 4){
                man.armR.setVisible(true);
            }else if(wrong == 5) {
                man.legR.setVisible(true);
            }else if(wrong == 6){
                man.legL.setVisible(true);
            }

       }


    }





    public static void main(String[] args) {
        new Hangman().start();


    }

    public void setTracker(int tracker) {
        this.tracker = tracker;
    }
}