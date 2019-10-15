package com.leszek.demo.vadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;


import java.util.ArrayList;

import java.util.List;
import java.util.Random;

@Route("tictactoe")
@PWA(name = "TICTACTOE", shortName = "TTT")
public class TicTacToe extends VerticalLayout {

    Button b1 = new Button("-");
    Button b2 = new Button("-");
    Button b3 = new Button("-");
    Button b4 = new Button("-");
    Button b5 = new Button("-");
    Button b6 = new Button("-");
    Button b7 = new Button("-");
    Button b8 = new Button("-");
    Button b9 = new Button("-");


    private boolean youWin;
    private boolean youLost;
    private List<Button> buttons;

    private boolean myMove = true;


    HorizontalLayout layout1 = new HorizontalLayout();
    HorizontalLayout layout2 = new HorizontalLayout();
    HorizontalLayout layout3 = new HorizontalLayout();
    HorizontalLayout layout4 = new HorizontalLayout();
    HorizontalLayout layout5 = new HorizontalLayout();


    public TicTacToe()  {
        buttons = new ArrayList<>();
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);
        buttons.add(b5);
        buttons.add(b6);
        buttons.add(b7);
        buttons.add(b8);
        buttons.add(b9);


        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setSizeFull();

        H1 header = new H1("TIC TAC TOE");
        header.getElement().getThemeList().add("dark");
        header.setWidth("100%");
        Label label = new Label("Do you want to start a new game?");
        Button startButton = new Button("Yes");
        startButton.addClickListener(event -> {
            remove(label, startButton);
            drawGameChart();
            playerMove();

        });
        b1.addClickListener(clickEvent -> {
            buttons.remove(b1);
            layout1.removeAll();
            if (myMove) {
                layout1.add(new Button("X"), b2, b3);
                b1.setText("X");
                try {
                    aIMove();
                } catch (Exception x) {
                    x.getMessage();
                }
            } else {
                layout1.add(new Button("O"), b2, b3);
                b1.setText("O");
                playerMove();
            }

        });

        b2.addClickListener(clickEvent -> {
            buttons.remove(b2);
            layout1.removeAll();
            if (myMove) {
                layout1.add(b1, new Button("X"), b3);
                b2.setText("X");
                try {
                    aIMove();
                } catch (Exception x) {
                    x.getMessage();
                }
            } else {
                layout1.add(b1, new Button("O"), b3);
                b2.setText("O");
                playerMove();
            }

        });

        b3.addClickListener(clickEvent -> {
            buttons.remove(b3);
            layout1.removeAll();
            if (myMove) {
                layout1.add(b1, b2, new Button("X"));
                b3.setText("X");
                try {
                    aIMove();
                } catch (Exception x) {
                    x.getMessage();
                }
            } else {
                layout1.add(b1, b2, new Button("O"));
                b3.setText("O");
                playerMove();
            }

        });

        b4.addClickListener(clickEvent -> {
            buttons.remove(b4);
            layout2.removeAll();
            if (myMove) {
                layout2.add(new Button("X"), b5, b6);
                b4.setText("X");
                try {
                    aIMove();
                } catch (Exception x) {
                    x.getMessage();
                }
            } else {
                layout2.add(new Button("O"), b5, b6);
                b4.setText("O");
                playerMove();
            }

        });

        b5.addClickListener(clickEvent -> {
            buttons.remove(b5);
            layout2.removeAll();
            if (myMove) {
                layout2.add(b4, new Button("X"), b6);
                b5.setText("X");
                try {
                    aIMove();
                } catch (Exception x) {
                    x.getMessage();
                }
            } else {
                layout2.add(b4, new Button("O"), b6);
                b5.setText("O");
                playerMove();
            }

        });

        b6.addClickListener(clickEvent -> {
            buttons.remove(b6);
            layout2.removeAll();
            if (myMove) {
                layout2.add(b4, b5, new Button("X"));
                b6.setText("X");
                try {
                    aIMove();
                } catch (Exception x) {
                    x.getMessage();
                }
            } else {
                layout2.add(b4, b5, new Button("O"));
                b6.setText("O");
                playerMove();
            }


        });

        b7.addClickListener(clickEvent -> {
            buttons.remove(b7);
            layout3.removeAll();
            if (myMove) {
                layout3.add(new Button("X"), b8, b9);
                b7.setText("X");
                try {
                    aIMove();
                } catch (Exception x) {
                    x.getMessage();
                }
            } else {
                layout3.add(new Button("O"), b8, b9);
                b7.setText("O");
                playerMove();
            }

        });

        b8.addClickListener(clickEvent -> {
            buttons.remove(b8);
            layout3.removeAll();
            if (myMove) {
                layout3.add(b7, new Button("X"), b9);
                b8.setText("X");
                try {
                    aIMove();
                } catch (Exception x) {
                    x.getMessage();
                }
            } else {
                layout3.add(b7, new Button("O"), b9);
                b8.setText("O");
                playerMove();
            }

        });

        b9.addClickListener(clickEvent -> {
            buttons.remove(b9);
            layout3.removeAll();
            if (myMove) {
                layout3.add(b7, b8, new Button("X"));
                b9.setText("X");
                try {
                    aIMove();
                } catch (Exception x) {
                    x.getMessage();
                }
            } else {
                layout3.add(b7, b8, new Button("O"));
                b9.setText("O");
                playerMove();
            }
        });
        layout5.setWidth("100%");
        layout5.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        layout5.getElement().getThemeList().add("dark");
        Label footer = new Label("2019 by L.P.");
        layout5.add(footer);
        add(header, label, startButton);
        addAndExpand(layout4);
        add(layout5);
    }

    public void drawGameChart() {

        layout1.add(b1, b2, b3);
        layout2.add(b4, b5, b6);
        layout3.add(b7, b8, b9);
        add(layout1, layout2, layout3);
        addAndExpand(layout4);
        add(layout5);
    }

    public void playerMove() {

        checkResult();
        myMove = true;
    }

    public void aIMove()  {

        checkResult();
        myMove = false;
        Random random = new Random();
        Button randomButton = buttons.get(random.nextInt(buttons.size()));
        randomButton.click();
        }

    public void checkResult() {

        if ((b1.getElement().getText().equals("X") && b2.getElement().getText().equals("X") && b3.getElement().getText().equals("X"))) {
            youWin = true;
        } else if ((b4.getElement().getText().equals("X") && b5.getElement().getText().equals("X") && b6.getElement().getText().equals("X"))) {
            youWin = true;
        } else if ((b7.getElement().getText().equals("X") && b8.getElement().getText().equals("X") && b9.getElement().getText().equals("X"))) {
            youWin = true;
        } else if ((b1.getElement().getText().equals("X") && b4.getElement().getText().equals("X") && b7.getElement().getText().equals("X"))) {
            youWin = true;
        } else if ((b2.getElement().getText().equals("X") && b5.getElement().getText().equals("X") && b8.getElement().getText().equals("X"))) {
            youWin = true;
        } else if ((b3.getElement().getText().equals("X") && b6.getElement().getText().equals("X") && b9.getElement().getText().equals("X"))) {
            youWin = true;
        } else if ((b1.getElement().getText().equals("X") && b5.getElement().getText().equals("X") && b9.getElement().getText().equals("X"))) {
            youWin = true;
        } else if ((b3.getElement().getText().equals("X") && b5.getElement().getText().equals("X") && b7.getElement().getText().equals("X"))) {
            youWin = true;
        } else if ((b1.getElement().getText().equals("O") && b2.getElement().getText().equals("O") && b3.getElement().getText().equals("O"))) {
            youLost = true;
        } else if ((b4.getElement().getText().equals("O") && b5.getElement().getText().equals("O") && b6.getElement().getText().equals("O"))) {
            youLost = true;
        } else if ((b7.getElement().getText().equals("O") && b8.getElement().getText().equals("O") && b9.getElement().getText().equals("O"))) {
            youLost = true;
        } else if ((b1.getElement().getText().equals("O") && b4.getElement().getText().equals("O") && b7.getElement().getText().equals("O"))) {
            youLost = true;
        } else if ((b2.getElement().getText().equals("O") && b5.getElement().getText().equals("O") && b8.getElement().getText().equals("O"))) {
            youLost = true;
        } else if ((b3.getElement().getText().equals("O") && b6.getElement().getText().equals("O") && b9.getElement().getText().equals("O"))) {
            youLost = true;
        } else if ((b1.getElement().getText().equals("O") && b5.getElement().getText().equals("O") && b9.getElement().getText().equals("O"))) {
            youLost = true;
        } else if ((b3.getElement().getText().equals("O") && b5.getElement().getText().equals("O") && b7.getElement().getText().equals("O"))) {
            youLost = true;
        }

        if (youLost || youWin) {
            gameOver();
        }

        if(buttons.size() == 0) {
            draw();
        }

    }

    public void gameOver() {
        remove(layout3, layout2, layout1, layout4, layout5);
        Label label1 = new Label("YOU WON!!!");
        Label label2 = new Label("YOU'VE LOST!!!");
        if (youWin) {
            add(label1);
        } else {
            add(label2);
        }

        Label question = new Label("Do you want to play again?");
        Button yesAnswer = new Button("Yes");
        Button noAnswer = new Button("No");
       yesAnswer.addClickListener(click -> {
        });
        add(question, yesAnswer, noAnswer);
        addAndExpand(layout4);
        add(layout5);
    }

    public void draw() {
        removeAll();
        Label label1 = new Label("DRAW!!!");
        add(label1);

        Label question = new Label("Do you want to play again?");
        Button yesAnswer = new Button("Yes");
        Button noAnswer = new Button("No");
        yesAnswer.addClickListener(click -> {
        });
        add(question, yesAnswer, noAnswer);
        addAndExpand(layout4);
        add(layout5);
    }
}
