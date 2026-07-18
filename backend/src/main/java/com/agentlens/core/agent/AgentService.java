package com.agentlens.core.agent;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Agent 实例管理——追踪所有 Agent 的状态。
 *
 * 支持多 Agent 注册、状态更新和查询。
 * 对应前端 Agent Monitor 和 Agent Center 的状态展示。
 */
@Service
public class AgentService {

    private final Map<String, AgentInstance> agents = new LinkedHashMap<>();

    public AgentInstance register(String name) {
        // @claude [todo] 创建新的 Agent 实例，状态为 WAITING
        return null; // TODO
    }

    public AgentInstance updateStatus(String id, String status) {
        // @claude [todo] 更新 Agent 状态并记录耗时
        return null; // TODO
    }

    public List<AgentInstance> getAllAgents() {
        return new ArrayList<>(agents.values());
    }

    public Optional<AgentInstance> getAgent(String id) {
        return Optional.ofNullable(agents.get(id));
    }
}
