package com.agentlens.core.prompt;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PromptRepository {
    //存储模板<UUID,模板对象>
    private final Map<String, PromptTemplate> templates = new HashMap<>();
    //记录提示词版本历史<模板版本号,历史版本列表>
    private final Map<String, List<String>> history = new HashMap<>();

    /**
     * 创建模板
     * @claude [todo] 生成 UUID 作为 id，存入 templates，初始化 history
     */
    public PromptTemplate create(PromptTemplate template) {
        String templateUuid = UUID.randomUUID().toString();
        template.setId(templateUuid);
        templates.put(templateUuid,template);
        List<String> historytemplates = history.get(templateUuid);
        if(historytemplates==null){
            historytemplates = new ArrayList<>();
        }
        historytemplates.add(templateUuid);
        history.put(templateUuid,new ArrayList<>());
        return template; // TODO
    }

    /**
     * 更新模板
     * @claude [todo] 检查 id 是否存在，存在则覆盖，不存在则抛异常
     */
    public PromptTemplate update(PromptTemplate template) {
        return null; // TODO
    }

    public Optional<PromptTemplate> findById(String id) {
        return Optional.ofNullable(templates.get(id));
    }

    public List<PromptTemplate> findAll() {
        return new ArrayList<>(templates.values());
    }

    public void delete(String id) {
        templates.remove(id);
        history.remove(id);
    }
}
