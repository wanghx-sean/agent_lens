package com.agentlens.core.prompt;

import com.agentlens.core.tool.Constants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Prompt 模板业务逻辑层。
 * <p>
 * 负责 Prompt 模板的创建、更新、查询和删除，
 * 封装了版本管理等业务规则。
 */
@Service
public class PromptService {

    private final PromptRepository promptRepository;

    public PromptService(PromptRepository promptRepository) {
        this.promptRepository = promptRepository;
    }

    /**
     * 创建 Prompt 模板
     *
     * @claude [todo] 初始化 version = 1，调用 repository.create()
     */
    public PromptTemplate create(PromptTemplate template) {
        //Jackson 用的是无参构造器反序列化导致版本默认为0,重新设置为1
        template.setVersion(Constants.PROMPT_VERSION_START);
        promptRepository.create(template);
        return template;
    }

    /**
     * 更新 Prompt 模板
     *
     * @claude [todo] 自动递增 version，调用 repository.update()
     */
    public PromptTemplate update(String id, PromptTemplate template) {
        Optional<PromptTemplate> templateOptional = promptRepository.findById(id);
        if (templateOptional.isPresent()) {
            PromptTemplate templateToUpdate = templateOptional.get();
            template.setId(id);
            template.setVersion(templateToUpdate.getVersion() + 1);
            promptRepository.update(template);
            return template;
        } else {
            throw new IllegalArgumentException("Template not found: " + id);
        }
    }

    /**
     * 查询所有模板
     */
    public List<PromptTemplate> findAll() {
        return promptRepository.findAll();
    }

    /**
     * 根据 ID 查询
     */
    public Optional<PromptTemplate> findById(String id) {
        return promptRepository.findById(id);
    }

    /**
     * 删除模板
     */
    public void delete(String id) {
        promptRepository.delete(id);
    }
}
