package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Qualifier;


@Route("openai")
public class OpenaiView extends VerticalLayout {
    private final ChatModel chatModel;

    public OpenaiView(@Qualifier("openAiChatModel") ChatModel chatModel) {
        this.chatModel = chatModel;
        var input = new TextField("Input prompt here");
        var submit = new Button("Submit");
        var response = new Paragraph();
        submit.addClickListener(e -> {
            response.setText(this.chatModel.call(input.getValue()));
        });
        add(input,submit,response);
    }
}
