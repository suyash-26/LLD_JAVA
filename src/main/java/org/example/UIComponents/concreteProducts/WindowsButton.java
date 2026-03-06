package org.example.UIComponents.concreteProducts;

import org.example.UIComponents.productInterfaces.Button;

public class WindowsButton implements Button {
    public void onClick(){
        System.out.println("This is windows button");
    }
}
