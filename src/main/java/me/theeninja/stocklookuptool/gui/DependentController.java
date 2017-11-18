package me.theeninja.stocklookuptool.gui;

public interface DependentController<T> extends SingleViewController<T> {
    void clearDisplay();
    void updateDisplay(T pane);
}
