package e2;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import java.util.*;
import java.util.Map.Entry;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<JButton,Pair<Integer,Integer>> buttons = new HashMap<>();
    private final Logics logics;
    
    public GUI(int size, int mines) {
        this.logics = new LogicsImpl(size, mines);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*size, 100*size);
        
        JPanel panel = new JPanel(new GridLayout(size,size));
        this.getContentPane().add(BorderLayout.CENTER,panel);
        
        ActionListener onClick = (e)->{
            final JButton bt = (JButton)e.getSource();
            final Pair<Integer,Integer> pos = buttons.get(bt);
            if (this.logics.clickedCell(pos.getX(), pos.getY()) == e2.Type.MINE) {
                quitGame();
                JOptionPane.showMessageDialog(this, "You lost!!");
                
            } else {
                this.logics.cellClick(pos.getX(), pos.getY());
                bt.setEnabled(false);
                drawBoard();            	
            }
            
            if (this.logics.hasClearAllField()){
                quitGame();
                JOptionPane.showMessageDialog(this, "You won!!");
                System.exit(0);
            }
        };

        MouseInputListener onRightClick = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final JButton bt = (JButton)e.getSource();
                if (bt.isEnabled()){
                    final Pair<Integer,Integer> pos = buttons.get(bt);
                    logics.checkFlag(pos.getX(), pos.getY());
                }
                drawBoard(); 
            }
        };
                
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                final JButton jb = new JButton(" ");
                jb.addActionListener(onClick);
                jb.addMouseListener(onRightClick);
                this.buttons.put(jb,new Pair<>(i,j));
                panel.add(jb);
            }
        }
        this.drawBoard();
        this.setVisible(true);
    }
    
    private void quitGame() {
        this.drawBoard();
    	for (Entry<JButton,Pair<Integer,Integer>> entry: this.buttons.entrySet()) {
            if(this.logics.clickedCell(entry.getValue().getX(), entry.getValue().getY()) == e2.Type.MINE)
                entry.getKey().setText("*");
    	}
    }

    private void drawBoard() {
        for (Entry<JButton,Pair<Integer,Integer>> entry: this.buttons.entrySet()) {
            String string = this.logics.cellValue(entry.getValue().getX(), entry.getValue().getY());
            entry.getKey().setText(string);
    	}
    }
    
}
