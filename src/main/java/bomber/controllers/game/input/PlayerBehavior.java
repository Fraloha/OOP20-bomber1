package bomber.controllers.game.input;

public final class PlayerBehavior {

    private Boolean toggleUpPressed = Boolean.FALSE;
    private Boolean toggleDownPressed = Boolean.FALSE;
    private Boolean toggleLeftPressed = Boolean.FALSE;
    private Boolean toggleRightPressed = Boolean.FALSE;
    private Boolean toggleActionPressed = Boolean.FALSE;

    public boolean isToggleUpPressed() {
        return toggleUpPressed;
    }

    public void setToggleUpPressed(final boolean toggleUpPressed) {
        if (!toggleUpPressed || !this.toggleDownPressed && !this.toggleLeftPressed && !this.toggleRightPressed
                && !this.toggleUpPressed) {
            this.toggleUpPressed = toggleUpPressed;
        }
    }

    public boolean isToggleDownPressed() {
        return toggleDownPressed;
    }

    public void setToggleDownPressed(final boolean toggleDownPressed) {
        if (!toggleDownPressed || !this.toggleDownPressed && !this.toggleLeftPressed && !this.toggleRightPressed
                && !this.toggleUpPressed) {
            this.toggleDownPressed = toggleDownPressed;
        }
    }

    public boolean isToggleLeftPressed() {
        return toggleLeftPressed;
    }

    public void setToggleLeftPressed(final boolean toggleLeftPressed) {
        if (!toggleLeftPressed || !this.toggleDownPressed && !this.toggleLeftPressed && !this.toggleRightPressed
                && !this.toggleUpPressed) {
            this.toggleLeftPressed = toggleLeftPressed;
        }
    }

    public boolean isToggleRightPressed() {
        return toggleRightPressed;
    }

    public void setToggleRightPressed(final boolean toggleRightPressed) {
        if (!toggleRightPressed || !this.toggleDownPressed && !this.toggleLeftPressed && !this.toggleRightPressed
                && !this.toggleUpPressed) {
            this.toggleRightPressed = toggleRightPressed;
        }
    }

    public boolean isToggleActionPressed() {
        return toggleActionPressed;
    }

    public void setToggleActionPressed(final boolean toggleActionPressed) {
        this.toggleActionPressed = toggleActionPressed;
    }

}
