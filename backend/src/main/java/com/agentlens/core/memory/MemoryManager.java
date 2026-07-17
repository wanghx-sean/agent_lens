package com.agentlens.core.memory;

import java.util.*;

/**
 * Memory 管理——Agent 的记忆系统。
 *
 * 包含：
 * - 短期记忆（当前会话）
 * - 长期记忆（跨会话持久化，向量存储）
 * - 用户偏好（角色设定、风格偏好等）
 */
public class MemoryManager {

    private final List<String> sessionMemory = new ArrayList<>();
    private final List<String> longTermMemory = new ArrayList<>();
    private final Map<String, String> preferences = new HashMap<>();

    /**
     * 添加一条短期记忆
     */
    public void addToSession(String memory) {
        sessionMemory.add(memory);
    }

    /**
     * 将短期记忆固化到长期记忆
     */
    public void consolidateToLongTerm(String memory) {
        longTermMemory.add(memory);
    }

    /**
     * 设置用户偏好
     */
    public void setPreference(String key, String value) {
        preferences.put(key, value);
    }

    /**
     * 获取当前会话上下文（短期 + 长期）
     */
    public String getContext() {
        var sb = new StringBuilder();
        if (!longTermMemory.isEmpty()) {
            sb.append("【长期记忆】\n");
            longTermMemory.forEach(m -> sb.append("- ").append(m).append("\n"));
        }
        if (!sessionMemory.isEmpty()) {
            sb.append("【会话记忆】\n");
            sessionMemory.forEach(m -> sb.append("- ").append(m).append("\n"));
        }
        return sb.toString();
    }

    // getters
    public List<String> getSessionMemory() { return List.copyOf(sessionMemory); }
    public List<String> getLongTermMemory() { return List.copyOf(longTermMemory); }
    public Map<String, String> getPreferences() { return Map.copyOf(preferences); }
}
