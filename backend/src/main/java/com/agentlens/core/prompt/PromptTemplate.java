package com.agentlens.core.prompt;

/**
 * Prompt 管理——模板化 Prompt 的定义。
 * <p>
 * 每个 Prompt 由角色、目标、风格、约束等组成，
 * 支持变量注入和版本管理。
 */
public class PromptTemplate {

    private String id;
    private String name;
    private String role;
    private String goal;
    private String style;
    private String outputFormat;
    private String constraints;
    private int version;

    public PromptTemplate() {
    }

    public PromptTemplate(String name, String role, String goal) {
        this.name = name;
        this.role = role;
        this.goal = goal;
    }

    /**
     * 渲染最终 Prompt，将变量注入模板
     */
    public String render(String... variables) {
        // TODO: 变量注入逻辑
        return String.format("""
                        角色：%s
                        目标：%s
                        风格：%s
                        约束：%s
                        输出格式：%s
                        """, role, goal, style != null ? style : "",
                constraints != null ? constraints : "",
                outputFormat != null ? outputFormat : "");
    }

    // getters & setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getConstraints() {
        return constraints;
    }

    public void setConstraints(String constraints) {
        this.constraints = constraints;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
