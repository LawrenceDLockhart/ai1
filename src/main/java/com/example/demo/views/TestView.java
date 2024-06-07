package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;

@Route("test")
public class TestView extends VerticalLayout {

    public TestView(VertexAiGeminiChatModel chatModel) {

        var input = new TextField("Input prompt here");
        var submit = new Button("Submit");
        var response = new Paragraph();
        submit.addClickListener(e -> {
            response.setText(chatModel.call(input.getValue()));
        });
        add(input,submit,response);
    }
}