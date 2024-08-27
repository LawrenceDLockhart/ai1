package com.example.application.views;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;

@Route("test2")
public class TestView2 extends VerticalLayout {

    private final VerticalLayout chatMessages = new VerticalLayout();
    private final TextField input = new TextField("Input prompt here");
    private final Button submit = new Button("Submit");
    private final Button clearChat = new Button("Clear Chat");

    public TestView2(VertexAiGeminiChatModel chatModel) {
        chatMessages.setPadding(false);
        chatMessages.setSpacing(false);

        // Wrap chatMessages inside a Scroller for scrollable history
        Scroller chatHistoryScroller = new Scroller(chatMessages);
        chatHistoryScroller.setHeight("400px");
        chatHistoryScroller.setScrollDirection(Scroller.ScrollDirection.VERTICAL);

        // Input and submit button styling
        input.setWidthFull();
        submit.addClassName("submit-button");
        clearChat.addClassName("clear-button");

        submit.addClickListener(e -> {
            String userInput = input.getValue();
            String aiResponse = chatModel.call(userInput);
            chatMessages.add(new Html("<div class='chat-bubble user'>You: " + userInput + "</div>"));
            chatMessages.add(new Html("<div class='chat-bubble ai'>AI: " + aiResponse + "</div>"));
            input.clear();

        });

        clearChat.addClickListener(e -> chatMessages.removeAll());

        add(chatHistoryScroller, input, submit, clearChat);
        addClassName("gemini-view");
    }
}
