package bomberOne.model.input;


public class PlayerBehaviour {

    private Boolean toggleUpPressed = Boolean.FALSE;
    private Boolean toggleDownPressed = Boolean.FALSE;
    private Boolean toggleLeftPressed = Boolean.FALSE;
    private Boolean toggleRightPressed = Boolean.FALSE;
    private Boolean toggleActionPressed = Boolean.FALSE;

    public boolean isToggleUpPressed() {
        return toggleUpPressed;
    }

    public void setToggleUpPressed(boolean toggleUpPressed) {
        if (!toggleUpPressed || !this.toggleDownPressed && !this.toggleLeftPressed && !this.toggleRightPressed
                && !this.toggleUpPressed) {
            this.toggleUpPressed = toggleUpPressed;
        }
    }

    public boolean isToggleDownPressed() {
        return toggleDownPressed;
    }

    public void setToggleDownPressed(boolean toggleDownPressed) {
        if (!toggleDownPressed || !this.toggleDownPressed && !this.toggleLeftPressed && !this.toggleRightPressed
                && !this.toggleUpPressed) {
            this.toggleDownPressed = toggleDownPressed;
        }
    }

    public boolean isToggleLeftPressed() {
        return toggleLeftPressed;
    }

    public void setToggleLeftPressed(boolean toggleLeftPressed) {
        if (!toggleLeftPressed || !this.toggleDownPressed && !this.toggleLeftPressed && !this.toggleRightPressed
                && !this.toggleUpPressed) {
            this.toggleLeftPressed = toggleLeftPressed;
        }
    }

    public boolean isToggleRightPressed() {
        return toggleRightPressed;
    }

    public void setToggleRightPressed(boolean toggleRightPressed) {
        if (!toggleRightPressed || !this.toggleDownPressed && !this.toggleLeftPressed && !this.toggleRightPressed
                && !this.toggleUpPressed) {
            this.toggleRightPressed = toggleRightPressed;
        }
    }

    public boolean isToggleActionPressed() {
        return toggleActionPressed;
    }

    public void setToggleActionPressed(boolean toggleActionPressed) {
        this.toggleActionPressed = toggleActionPressed;
    }


}
