package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.ai.chat.ChatClient;

@Route("")
public class Request extends VerticalLayout {
    public Request(ChatClient client) {
        var input = new TextField("Input prompt here");
        var submit = new Button("Submit");
        var response = new Paragraph();
        submit.addClickListener(e -> {
            response.setText(client.call(input.getValue()));
        });
        add(input,submit,response);
    }
}
