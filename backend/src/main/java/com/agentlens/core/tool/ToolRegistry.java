package com.agentlens.core.tool;

import java.util.*;

/**
 * 工具注册中心——管理所有可用工具。
 */
public class ToolRegistry {

    private final Map<String, AgentTool> tools = new LinkedHashMap<>();

    public void register(AgentTool tool) {
        tools.put(tool.getName(), tool);
    }

    public Optional<AgentTool> getTool(String name) {
        return Optional.ofNullable(tools.get(name));
    }

    public List<AgentTool> getAllTools() {
        return List.copyOf(tools.values());
    }
}
