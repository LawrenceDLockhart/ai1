package com.example.application.views;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route("")
public class GeminiView extends VerticalLayout {

    private VerticalLayout chatHistory;

    public GeminiView() {
        chatHistory = new VerticalLayout();
        chatHistory.setWidth("100%");

        TextArea userPrompt = new TextArea("Your Prompt");
        userPrompt.setWidth("100%");

        Button sendButton = new Button("Send");
        sendButton.addClickListener(event -> {
            String prompt = userPrompt.getValue();
            if (!prompt.trim().isEmpty()) {
                addMessageToChat("You", prompt);
                String response = getResponseFromAI(prompt); // Replace this with the actual call to your AI service
                addMessageToChat("AI", response);
                userPrompt.clear();
            }
        });

        HorizontalLayout inputLayout = new HorizontalLayout(userPrompt, sendButton);
        inputLayout.setWidth("100%");
        inputLayout.expand(userPrompt);

        add(chatHistory, inputLayout);
    }

    private void addMessageToChat(String sender, String message) {
        HorizontalLayout messageLayout = new HorizontalLayout();
        messageLayout.addClassName("message-layout");

        Span senderSpan = new Span(sender + ": ");
        senderSpan.addClassName("sender-span");

        Span messageSpan = new Span(message);
        messageSpan.addClassName("message-span");

        messageLayout.add(senderSpan, messageSpan);
        chatHistory.add(messageLayout);
    }

    private String getResponseFromAI(String prompt) {
        // Placeholder for the actual call to your AI service.
        return "This is a response to: " + prompt;
    }
}
