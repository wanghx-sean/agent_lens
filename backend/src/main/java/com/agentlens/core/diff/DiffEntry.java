package com.agentlens.core.diff;

/**
 * 代码变更记录——Agent 修改文件时的 Diff 条目。
 *
 * 记录每个文件的修改前/后内容，供 Change Review 使用。
 * 对应前端 Change Review 面板。
 */
public class DiffEntry {

    private String id;
    private String filePath;
    private String beforeContent;
    private String afterContent;
    private String status; // PENDING, ACCEPTED, REJECTED
    private String taskId;
    private long createdAt;

    public DiffEntry() {}

    public DiffEntry(String filePath, String beforeContent, String afterContent) {
        this.filePath = filePath;
        this.beforeContent = beforeContent;
        this.afterContent = afterContent;
        this.status = "PENDING";
        this.createdAt = System.currentTimeMillis();
    }

    // @claude [todo] 补充 getters/setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
    public String getBeforeContent() { return beforeContent; }
    public void setBeforeContent(String beforeContent) { this.beforeContent = beforeContent; }
    public String getAfterContent() { return afterContent; }
    public void setAfterContent(String afterContent) { this.afterContent = afterContent; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getTaskId() { return taskId; }
    public void setTaskId(String taskId) { this.taskId = taskId; }
    public long getCreatedAt() { return createdAt; }
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }
}
