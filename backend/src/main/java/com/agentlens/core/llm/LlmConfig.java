package com.agentlens.core.llm;

/**
 * LLM 配置——模型选择、API Key、参数等。
 *
 * 结构待定，接入真实模型时完善。
 */
public class LlmConfig {

    private String model;
    private String apiKey;
    private String apiUrl;
    private double temperature;
    private int maxTokens;

    public LlmConfig() {
        this.model = "test";
        this.temperature = 0.7;
        this.maxTokens = 2048;
    }

    // getters & setters
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getApiKey() { return apiKey; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }
    public String getApiUrl() { return apiUrl; }
    public void setApiUrl(String apiUrl) { this.apiUrl = apiUrl; }
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
    public int getMaxTokens() { return maxTokens; }
    public void setMaxTokens(int maxTokens) { this.maxTokens = maxTokens; }
}
