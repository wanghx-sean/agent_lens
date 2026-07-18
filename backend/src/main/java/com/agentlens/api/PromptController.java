package com.agentlens.api;

import com.agentlens.core.prompt.PromptService;
import com.agentlens.core.prompt.PromptTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * Prompt 模板管理接口。
 * <p>
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
        Optional<PromptTemplate> templateOptional = promptService.findById(id);
        if (templateOptional.isPresent()) {
            return templateOptional.get();
        } else {
            //无法找到返回404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
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
