package com.codebind;

import javax.swing.*;
import java.beans.BeanProperty;
import java.beans.ConstructorProperties;

public class MyButton extends JButton
{
    private static final String uiClassID = "ButtonUI";
    private Icon rolloverIcon = new ImageIcon("image/infinity1.png") ;

    public MyButton() {
        this((String)null, (new ImageIcon("image/infinity.png")));
    }

    public MyButton(Icon icon) {
        this((String)null, icon);
    }

    @ConstructorProperties({"text"})
    public MyButton(String text) {
        this(text, (Icon)null);
    }

    public MyButton(Action a) {
        this();
        this.setAction(a);
    }

    public MyButton(String text, Icon icon) {
        this.setModel(new DefaultButtonModel());
        this.init(text, icon);
    }

    public Icon getRolloverIcon() {
        return this.rolloverIcon;
    }

    @BeanProperty(
            visualUpdate = true,
            description = "The rollover icon for the button."
    )
    public void setRolloverIcon() {
        Icon oldValue = this.rolloverIcon;
        this.rolloverIcon = rolloverIcon;
        this.firePropertyChange("rolloverIcon", oldValue, rolloverIcon);
        if (this.accessibleContext != null) {
            this.accessibleContext.firePropertyChange("AccessibleVisibleData", oldValue, rolloverIcon);
        }

        this.setRolloverEnabled(true);
        if (rolloverIcon != oldValue) {
            this.repaint();
        }
    }
}
