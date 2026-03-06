package org.example.UIComponents.concreteFactory;

import org.example.UIComponents.concreteProducts.MacButton;
import org.example.UIComponents.concreteProducts.MacCheckbox;
import org.example.UIComponents.factoryInterface.ComponentsInterface;
import org.example.UIComponents.productInterfaces.Button;
import org.example.UIComponents.productInterfaces.CheckBox;

public class MacComponentsFactory implements ComponentsInterface {
    public Button getButton(){
        return new MacButton();
    }
    public CheckBox getCheckbox(){
        return new MacCheckbox();
    }
}
