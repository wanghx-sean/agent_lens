package com.agentlens.api;

import com.agentlens.core.llm.LlmService;
import org.springframework.web.bind.annotation.*;

/**
 * LLM 对话接口。
 *
 * 提供与 Agent 对话的 REST API，前端通过此接口发送消息并获取回复。
 */
@RestController
@RequestMapping("/api/llm")
public class LlmController {

    private final LlmService llmService;

    public LlmController(LlmService llmService) {
        this.llmService = llmService;
    }

    @PostMapping("/chat")
    public String chat(@RequestBody ChatRequest request) {
        return llmService.chat(request.message());
    }

    public record ChatRequest(String message) {}
}
