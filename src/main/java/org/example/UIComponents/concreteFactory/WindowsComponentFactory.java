package org.example.UIComponents.concreteFactory;

import org.example.UIComponents.concreteProducts.WindowsButton;
import org.example.UIComponents.concreteProducts.WindowsCheckbox;
import org.example.UIComponents.factoryInterface.ComponentsInterface;
import org.example.UIComponents.productInterfaces.Button;
import org.example.UIComponents.productInterfaces.CheckBox;

public class WindowsComponentFactory implements ComponentsInterface {
    public Button getButton(){
        return new WindowsButton();
    }
    public CheckBox getCheckbox(){
        return new WindowsCheckbox();
    }
}
