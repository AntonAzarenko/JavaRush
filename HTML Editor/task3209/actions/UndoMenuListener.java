package com.javarush.task.task32.task3209.actions;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;

public class UndoMenuListener {
    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;

    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }

    public void menuSelected(MenuEvent menuEvent){
        undoMenuItem.setEnabled(canUndo());
        undoMenuItem.setEnabled(canRedo());
    }

    public boolean canUndo(){
        return false;
    }

    public boolean canRedo(){
        return false;
    }
}
