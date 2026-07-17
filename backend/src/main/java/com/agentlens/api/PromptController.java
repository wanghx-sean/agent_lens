package com.agentlens.api;

import com.agentlens.core.prompt.PromptService;
import com.agentlens.core.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Prompt 模板管理接口。
 *
 * 提供 Prompt 模板的增删改查 REST API。
 */
@RestController
@RequestMapping("/api/prompts")
public class PromptController {

    private final PromptService promptService;

    public PromptController(PromptService promptService) {
        this.promptService = promptService;
    }

    @GetMapping
    public List<PromptTemplate> list() {
        return promptService.findAll();
    }

    @GetMapping("/{id}")
    public PromptTemplate getById(@PathVariable String id) {
        // @claude [hint] 如果没找到，应该返回 404
        return null; // TODO
    }

    @PostMapping
    public PromptTemplate create(@RequestBody PromptTemplate template) {
        return promptService.create(template);
    }

    @PutMapping("/{id}")
    public PromptTemplate update(@PathVariable String id, @RequestBody PromptTemplate template) {
        return promptService.update(id, template);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        promptService.delete(id);
    }
}
