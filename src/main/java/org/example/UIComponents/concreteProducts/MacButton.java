package org.example.UIComponents.concreteProducts;

import org.example.UIComponents.productInterfaces.Button;

public class MacButton implements Button {
    public void onClick(){
        System.out.println("this is mac button");
    }
}
