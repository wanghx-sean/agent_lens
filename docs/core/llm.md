# LLM 模块

## 职责

LLM 模块是大模型集成层，负责所有与 LLM 的通信。

## 核心接口

```java
public interface LlmService {
    String chat(String message);                          // 同步对话
    void chatStream(String msg, StreamCallback cb);       // 流式对话
}
```

## 设计思路

- **接口隔离** — `LlmService` 抽象所有模型调用，业务代码不依赖具体模型
- **策略模式** — 可切换不同实现：Test / OpenAI / Claude / 本地模型
- **流式支持** — `StreamCallback` 回调方式，避免前端长连接阻塞

## 当前实现

- `LlmTestService` — 固定回复，用于验证前后端通信链路

## 后续规划

- [ ] 接入真实 LLM（Spring AI / LangChain4j）
- [ ] 模型配置动态切换
- [ ] 多模型并行调用
- [ ] Token 用量统计
