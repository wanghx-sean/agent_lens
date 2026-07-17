# AgentLens

可视化 Agent 内部运作的桌面工具。

> **重新定义 Agent 的交互方式** —— 将「聊天」升级为「Agent IDE」。
>
> 让 Agent 内部不可见的 Prompt、Memory、Context、Tools 变得**可见、可管理、可复用**。

## 动机

目前绝大多数 AI Agent 采用聊天窗口作为主要交互方式。但实际上，大模型真正工作的输入远不止聊天内容：

- **System Prompt** — 用户无法直接管理
- **Memory** — 不可编辑，不可查看
- **Context** — 不透明，不知道模型看了什么
- **Tool 调用** — 不可见，不知道 Agent 做了什么

AgentLens 的目标不是提升模型能力，而是**提升人与 Agent 的协作效率**。

## 架构概览

```
┌──────────────────────┐     REST / WebSocket     ┌──────────────────────┐
│   Vue + Electron     │  ←────────────────────→   │   Java Spring Boot   │
│   (桌面 UI)           │                           │   (Agent 核心引擎)    │
│                      │                           │                      │
│   Prompt 面板        │                           │   LLM 集成           │
│   Context 面板       │                           │   Prompt 管理         │
│   Memory 面板        │                           │   Context 管理        │
│   Chat 面板          │                           │   Memory 管理         │
│   Token 面板         │                           │   Tool Calling       │
│   Execution 面板     │                           │   Workflow 编排       │
│   Timeline           │                           │   Token 计量         │
└──────────────────────┘                           └──────────────────────┘
```

## 技术栈

| 层 | 技术 |
|---|---|
| **前端** | Vue 3 + Electron + Vite |
| **后端** | Java 17+ / Spring Boot 3 |
| **LLM 集成** | Spring AI 或 LangChain4j |
| **通信** | REST API + WebSocket |
| **构建** | Maven (后端) / npm (前端) |

## 核心模块

| 模块 | 说明 |
|---|---|
| **LLM** | 大模型集成层，支持多模型接入 |
| **Prompt** | 模板化 Prompt 管理（角色 + 目标 + 约束），版本控制 |
| **Context** | 上下文窗口管理，显示模型当前读取的内容 |
| **Memory** | 会话记忆 + 长期记忆（向量化存储） |
| **Tool** | 工具调用（Function Calling），扩展 Agent 能力 |
| **Workflow** | 多步骤工作流编排（Plan → Execute → Review） |

## 开发阶段

| 阶段 | 内容 | 目标 |
|---|---|---|
| **一** | 项目骨架 + Hello LLM | 打通前后端通信，验证 LLM 调用链路 |
| **二** | Prompt 管理 | 模板化 Prompt，支持变量注入和版本管理 |
| **三** | Memory / Context 系统 | 短期记忆 + 长期记忆，Context 窗口可视化 |
| **四** | Tool Calling | 让 Agent 能调用外部工具 |
| **五** | Workflow 编排 | 多步骤自动化流程 |
| **六** | UI 面板完善 | 各面板可视化交互，Timeline / Token 监控 |

## 快速开始

> 待完善 —— 项目处于骨架搭建阶段。

```bash
# 后端
cd backend
mvn spring-boot:run

# 前端
cd frontend
npm install
npm run dev
```

## License

MIT
