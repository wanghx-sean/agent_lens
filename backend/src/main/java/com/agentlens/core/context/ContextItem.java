package com.agentlens.core.context;

/**
 * Context 中的单个内容项。
 *
 * 表示模型当前读取的一个特定内容单元，例如一个文件、一段文档或一个 API 引用。
 */
public class ContextItem {

    private String id;
    private String name;
    private String type; // FILE, DOC, API, MCP
    private String content;
    private int estimatedTokens;
    private boolean pinned;

    public ContextItem() {}

    public ContextItem(String name, String type, String content) {
        this.id = java.util.UUID.randomUUID().toString();
        this.name = name;
        this.type = type;
        this.content = content;
        this.estimatedTokens = content.length() / 4;
        this.pinned = false;
    }

    // getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public int getEstimatedTokens() { return estimatedTokens; }
    public void setEstimatedTokens(int estimatedTokens) { this.estimatedTokens = estimatedTokens; }
    public boolean isPinned() { return pinned; }
    public void setPinned(boolean pinned) { this.pinned = pinned; }
}
