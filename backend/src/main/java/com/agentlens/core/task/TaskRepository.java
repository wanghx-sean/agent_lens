package com.agentlens.core.task;

import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * 任务存储——Agent 任务的内存存储。
 *
 * 提供任务的增删改查操作。
 */
@Repository
public class TaskRepository {

    private final Map<String, AgentTask> tasks = new LinkedHashMap<>();

    public AgentTask save(AgentTask task) {
        if (task.getId() == null) {
            task.setId(UUID.randomUUID().toString());
        }
        task.setUpdatedAt(System.currentTimeMillis());
        tasks.put(task.getId(), task);
        return task;
    }

    public Optional<AgentTask> findById(String id) {
        return Optional.ofNullable(tasks.get(id));
    }

    public List<AgentTask> findAll() {
        return new ArrayList<>(tasks.values());
    }

    public List<AgentTask> findByStatus(String status) {
        return tasks.values().stream()
                .filter(t -> t.getStatus().equals(status))
                .toList();
    }

    public void delete(String id) {
        tasks.remove(id);
    }
}
