package com.agentlens.core.prompt;

import com.agentlens.core.tool.Constants;
import org.springframework.stereotype.Repository;

import java.util.*;

//提示词模板存储
@Repository
public class PromptRepository {
    //存储模板<UUID,模板对象>
    private final Map<String, PromptTemplate> templates = new HashMap<>();
    //记录提示词版本历史<模板版本号,历史版本列表>
    private final Map<String, List<String>> history = new HashMap<>();

    /**
     * 创建模板
     *
     * @claude [todo] 生成 UUID 作为 id，存入 templates，初始化 history
     */
    public PromptTemplate create(PromptTemplate template) {
        String templateUuid = UUID.randomUUID().toString();
        template.setId(templateUuid);
        templates.put(templateUuid, template);
        addHistory(templateUuid, template.getVersion());
        return template; // TODO
    }

    /*
     * 模板历史更新
     * */
    private void addHistory(String templateId, int templateVersion) {
        String templateVersionStr = Constants.PROMPT_VERSION_FOMATE + templateVersion;
        List<String> historyTemplates = history.get(templateId);
        if (historyTemplates == null) {
            historyTemplates = new ArrayList<>();
        }
        historyTemplates.add(templateVersionStr);
        history.put(templateId, historyTemplates);
    }

    /**
     * 更新模板
     *
     * @claude [todo] 检查 id 是否存在，存在则覆盖，不存在则抛异常
     */
    public PromptTemplate update(PromptTemplate template) {
        if (template == null || template.getId() == null) {
            //抛出运行时异常，不静态抛出
            throw new IllegalArgumentException("this template is null");
        }
        PromptTemplate originTemplate = templates.get(template.getId());
        if (originTemplate == null) {
            throw new IllegalArgumentException("this originTemplate is null");
        }
        templates.put(template.getId(), template);
        addHistory(template.getId(), template.getVersion());
        return template;
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
