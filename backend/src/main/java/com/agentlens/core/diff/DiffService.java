package com.agentlens.core.diff;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Diff 管理——Agent 代码变更的审核服务。
 *
 * 存储 Agent 修改文件的记录，支持审核（接受/拒绝）。
 * 对应前端 Change Review 面板。
 */
@Service
public class DiffService {

    private final Map<String, DiffEntry> entries = new LinkedHashMap<>();

    public DiffEntry recordChange(String filePath, String before, String after) {
        // @claude [todo] 记录一次 Agent 代码变更，状态 PENDING
        return null; // TODO
    }

    public DiffEntry approve(String id) {
        // @claude [todo] 接受变更，状态 → ACCEPTED
        return null; // TODO
    }

    public DiffEntry reject(String id) {
        // @claude [todo] 拒绝变更，状态 → REJECTED
        return null; // TODO
    }

    public List<DiffEntry> getPendingChanges() {
        return entries.values().stream()
                .filter(e -> "PENDING".equals(e.getStatus()))
                .toList();
    }

    public List<DiffEntry> getAllChanges() {
        return new ArrayList<>(entries.values());
    }
}
