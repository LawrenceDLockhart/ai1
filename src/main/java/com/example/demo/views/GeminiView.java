package com.example.demo.views;

import com.google.cloud.vertexai.VertexAI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatOptions;

@Route("gemini")
public class GeminiView extends VerticalLayout {
    private final String projectId = "ai1fortutorial";
    private final String location = "us-central1";

    public GeminiView() {

        VertexAI vertexApi = new VertexAI(projectId, location);
        VertexAiGeminiChatModel chatModel = new VertexAiGeminiChatModel(vertexApi,
                VertexAiGeminiChatOptions.builder()
                        .withModel(VertexAiGeminiChatModel.ChatModel.GEMINI_PRO_1_5_PRO)
                        .withTemperature(0.4F)
                        .build());

        var gprompt = new TextField("Enter Your Prompt Here");
        var button = new Button("Submit");
        var output = new Paragraph();

        button.addClickListener(e -> {
            String promptText = gprompt.getValue();
            if (promptText != null && !promptText.trim().isEmpty()) {
                ChatResponse response = chatModel.call(new Prompt(promptText));
                Generation generation = response.getResults().get(0);
                String cleanOutput = generation.getOutput().getContent();
                output.setText(cleanOutput);
            } else {
                output.setText("Prompt cannot be empty. Please enter a valid prompt.");
            }
        });

        add(gprompt, button, output);
    }
}
