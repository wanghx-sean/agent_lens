package com.agentlens.core.task;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 任务业务逻辑层。
 *
 * 管理 Agent 任务的创建、状态流转和查询。
 */
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public AgentTask createTask(String name, String description) {
        // @claude [todo] 创建任务，状态初始为 TODO
        return null; // TODO
    }

    public AgentTask updateStatus(String id, String status) {
        // @claude [todo] 更新任务状态（TODO → RUNNING → DONE）
        return null; // TODO
    }

    public List<AgentTask> findAll() {
        return taskRepository.findAll();
    }

    public Optional<AgentTask> findById(String id) {
        return taskRepository.findById(id);
    }

    public List<AgentTask> findByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    public void delete(String id) {
        taskRepository.delete(id);
    }
}
