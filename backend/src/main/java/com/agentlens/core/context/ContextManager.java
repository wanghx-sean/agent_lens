package com.agentlens.core.context;

import java.util.*;

/**
 * Context 管理——跟踪当前模型读取的内容。
 *
 * 包括文件、文档、API 引用等，并计算总 Token 占用。
 */
public class ContextManager {

    private final List<ContextItem> items = new ArrayList<>();
    private int totalTokens;

    public void add(ContextItem item) {
        items.add(item);
        recalculateTokens();
    }

    public void remove(String id) {
        items.removeIf(item -> item.getId().equals(id));
        recalculateTokens();
    }

    public void pin(String id) {
        items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .ifPresent(item -> item.setPinned(true));
    }

    public List<ContextItem> getItems() {
        return List.copyOf(items);
    }

    public int getTotalTokens() {
        return totalTokens;
    }

    private void recalculateTokens() {
        totalTokens = items.stream()
                .mapToInt(ContextItem::getEstimatedTokens)
                .sum();
    }
}
