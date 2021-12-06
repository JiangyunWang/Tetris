/**
 * This class represents a Key listener. It is configurable by the controller that instantiates
 * it.
 */
public class KeyListener implements ActionListener {
    Map<String, Runnable> keyActions;

    /**
     * Empty default constructor.
     */
    public KeyListener() {
        /**
         * Empty default constructor
         */
    }

    /**
     * Set the map for key events.
     */
    public void setKeyAction(String key, Runnable run) {
        keyActions.put(key,run);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (keyActions.containsKey(e.getActionCommand())) {
            keyActions.get(e.getActionCommand()).run();
        }
    }
}