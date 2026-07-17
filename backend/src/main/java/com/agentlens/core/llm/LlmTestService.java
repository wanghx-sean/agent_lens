package com.agentlens.core.llm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * LLM 测试实现——返回固定回复，用于验证前后端通信。
 *
 * 后续接入真实模型后替换此实现。
 */
@Service
public class LlmTestService implements LlmService {

    private static final Logger log = LoggerFactory.getLogger(LlmTestService.class);

    @Override
    public String chat(String message) {
        log.info("LLM Test received: {}", message);
        return "[AgentLens Test] 已收到你的消息。LLM 集成链路验证通过！\n\n" +
               "你发送的是：\n" + message;
    }

    @Override
    public void chatStream(String message, StreamCallback callback) {
        String response = chat(message);
        for (char c : response.toCharArray()) {
            callback.onToken(String.valueOf(c));
        }
        callback.onComplete(response);
    }
}
