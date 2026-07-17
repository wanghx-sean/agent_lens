# Context 模块

## 职责

跟踪和管理模型当前读取的内容——让用户明确知道"AI 到底看了哪些内容"。

## 核心概念

```java
ContextItem {
    String id;
    String name;            // 文件名 / 标题
    String type;            // FILE, DOC, API, MCP
    String content;         // 内容
    int estimatedTokens;    // 估算 Token 数
    boolean pinned;         // 是否固定（不被自动淘汰）
}
```

## 设计思路

- **全透明** — 用户可以看到模型当前看到的所有内容
- **手动控制** — 支持添加、删除、排序、Pin
- **Token 估算** — 每一项标注预估 Token 占用
- **自动摘要** — 过长内容自动摘要，节省上下文窗口

## 后续规划

- [ ] 文件拖拽添加
- [ ] 自动摘要实现
- [ ] Token 精确计算
- [ ] 排序与 Pin 功能
