package bomberOne.model.input;

public class Player {

    private static boolean toggleUpPressed;
    private static boolean toggleDownPressed;
    private static boolean toggleLeftPressed;
    private static boolean toggleRightPressed;
    
    public static boolean isToggleUpPressed() {
        return toggleUpPressed;
    }

    public static void setToggleUpPressed(boolean toggleUpPressed) {
        if(!toggleUpPressed || !Player.toggleDownPressed && !Player.toggleLeftPressed && !Player.toggleRightPressed && !Player.toggleUpPressed) {
            Player.toggleUpPressed = toggleUpPressed;
        }
    }

    public static boolean isToggleDownPressed() {
        return toggleDownPressed;
    }

    public static void setToggleDownPressed(boolean toggleDownPressed) {
        if(!toggleDownPressed || !Player.toggleDownPressed && !Player.toggleLeftPressed && !Player.toggleRightPressed && !Player.toggleUpPressed) {
            Player.toggleDownPressed = toggleDownPressed;
        }
    }

    public static boolean isToggleLeftPressed() {
        return toggleLeftPressed;
    }

    public static void setToggleLeftPressed(boolean toggleLeftPressed) {
        if(!toggleLeftPressed || !Player.toggleDownPressed && !Player.toggleLeftPressed && !Player.toggleRightPressed && !Player.toggleUpPressed) {
            Player.toggleLeftPressed = toggleLeftPressed;
        }
    }

    public static boolean isToggleRightPressed() {
        return toggleRightPressed;
    }

    public static void setToggleRightPressed(boolean toggleRightPressed) {
        if(!toggleRightPressed ||!Player.toggleDownPressed && !Player.toggleLeftPressed && !Player.toggleRightPressed && !Player.toggleUpPressed) {
            Player.toggleRightPressed = toggleRightPressed;
        }
    }
    
    public Player() {
//        this.toggleDownPressed = false;
//        this.toggleLeftPressed = false;
//        this.toggleUpPressed = false;
//        this.toggleRightPressed = false;
    }
    
    
    
}
