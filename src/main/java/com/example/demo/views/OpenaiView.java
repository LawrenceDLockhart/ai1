package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class OpenaiView extends VerticalLayout {
    public OpenaiView() {
        var input = new TextField("Input prompt here");
        var submit = new Button("Submit");
        var response = new Paragraph();
        submit.addClickListener(e -> {
            System.out.println("Hello");
        });
        add(input,submit,response);
    }
}
