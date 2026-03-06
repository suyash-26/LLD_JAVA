package org.example.UIComponents.concreteProducts;

import org.example.UIComponents.productInterfaces.CheckBox;

public class MacCheckbox implements CheckBox {
    public void onSelect(){
        System.out.println("This is max checkbox");
    }
}
