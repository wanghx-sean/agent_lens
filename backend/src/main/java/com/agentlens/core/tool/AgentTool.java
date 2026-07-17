package com.agentlens.core.tool;

/**
 * 工具（Tool Calling）——Agent 可以调用的外部能力。
 *
 * 每种工具实现此接口，注册到 ToolRegistry 中，
 * Agent 在运行时根据需求自动选择并调用。
 */
public interface AgentTool {

    /**
     * 工具名称，用于 LLM Function Calling 识别
     */
    String getName();

    /**
     * 工具描述，LLM 根据描述决定是否使用此工具
     */
    String getDescription();

    /**
     * JSON Schema 格式的入参定义
     */
    String getParameterSchema();

    /**
     * 执行工具
     * @param args JSON 格式的参数
     * @return 执行结果
     */
    String execute(String args);
}
