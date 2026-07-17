# Prompt 模块

## 职责

管理 Agent 的 Prompt 模板——用户的角色设定、输出风格、约束规则等。

## 核心概念

```java
PromptTemplate {
    String role;          // 角色（Java 工程师、产品经理...）
    String goal;          // 目标（当前任务说明）
    String style;         // 风格（正式、简洁、教学...）
    String outputFormat;  // 输出格式（Markdown、JSON...）
    String constraints;   // 约束（禁止表格、不超过500字...）
    int version;          // 版本号
}
```

## 设计思路

- **模板化** — Prompt 拆解为多个字段，用户可独立编辑
- **变量注入** — `render(...)` 方法支持动态插入变量
- **版本管理** — 每次修改生成新版本，支持 Diff 和回滚
- **快照对比** — 版本间可对比差异

## 后续规划

- [ ] Prompt Diff 可视化
- [ ] 模板保存/加载（JSON 或 YAML）
- [ ] 多版本分支管理
- [ ] 历史 Timeline
- [ ] Prompt 自动优化（检测重复指令）
