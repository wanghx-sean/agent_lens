package com.agentlens.core.llm;

/**
 * LLM 集成层——大模型调用的核心接口。
 *
 * 所有模型的调用都通过此接口抽象，
 * 后续可接入 OpenAI / Claude / 本地模型等不同实现。
 */
public interface LlmService {

    /**
     * 发送消息并获取回复（同步）
     */
    String chat(String message);

    /**
     * 发送消息并获取流式回复
     */
    void chatStream(String message, StreamCallback callback);

    interface StreamCallback {
        void onToken(String token);
        void onComplete(String fullResponse);
        void onError(Throwable error);
    }
}
