package bomberone.views;

public interface DialogBox {
    
    /* Methods. */
    /**
     * This method display a simple alert box that asks the user if is sure to close the window.
     * @param title The title of the alert box.
     * @param message The message of the alert box.
     * @param confirmExitButtonText The text of the button that confirms the close operation.
     * @param cancelButtonText The text of the cancel button that cancels the close operation.
     * @return
     */
    boolean display(final String title, final String message, final String confirmExitButtonText,
            final String cancelButtonText);
}
