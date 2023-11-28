package edu.gonzaga;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlayerView implements PropertyChangeListener {
    private Player currentPlayer;

    public PlayerView(Player player) {
        player.addPropertyChangeListener(this);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String isCurrPlayer = evt.getPropertyName();
        if ("currentPlayer".equals(isCurrPlayer)) {
            boolean value = (Boolean) evt.getNewValue();
            if (value) {
                Player player = (Player) evt.getSource();
                currentPlayer = player;
            }
        }
    }
}
