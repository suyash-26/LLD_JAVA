package org.example.UIComponents.concreteProducts;

import org.example.UIComponents.productInterfaces.CheckBox;

public class WindowsCheckbox implements CheckBox {
    public void onSelect(){
        System.out.println("this is windows checkbox");
    }

}
