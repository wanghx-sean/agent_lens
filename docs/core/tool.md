# Tool 模块

## 职责

Tool Calling（函数调用）——让 Agent 能调用外部工具，扩展能力边界。

## 核心接口

```java
public interface AgentTool {
    String getName();              // 工具名称
    String getDescription();       // 工具描述（给 LLM 看）
    String getParameterSchema();   // 入参 JSON Schema
    String execute(String args);   // 执行
}
```

## 设计思路

- **接口统一** — 所有工具实现 `AgentTool` 接口
- **注册中心** — `ToolRegistry` 管理所有可用工具
- **LLM 选择** — LLM 根据描述和 Schema 决定是否调用以及传什么参数
- **可扩展** — 新增工具只需注册到 Registry

## 后续规划

- [ ] 内置工具：文件读写
- [ ] 内置工具：代码搜索
- [ ] 内置工具：命令行执行
- [ ] Function Calling 与 LLM 联动
