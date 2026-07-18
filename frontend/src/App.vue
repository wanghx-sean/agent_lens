<template>
  <!-- @claude [think] IDEA风格：工具按钮在左右两侧，点击后停靠展开 -->
  <div class="app-layout">
    <!-- 菜单栏 -->
    <header class="app-menubar">
      <div class="menubar-left">
        <span class="app-logo">AgentLens</span>
      </div>
      <div class="menubar-center">
        <span class="menubar-item">{{ $t('menu_file') }}</span>
        <span class="menubar-item">{{ $t('menu_edit') }}</span>
        <span class="menubar-item">{{ $t('menu_view') }}</span>
        <span class="menubar-item">{{ $t('menu_agent') }}</span>
        <span class="menubar-item">{{ $t('menu_tools') }}</span>
        <span class="menubar-item">{{ $t('menu_help') }}</span>
      </div>
      <div class="menubar-right">
        <select class="lang-switch" v-model="$i18n.locale">
          <option value="zh">中文</option>
          <option value="en">English</option>
        </select>
        <span class="connection-dot" :class="{ connected: false }"></span>
      </div>
    </header>

    <!-- 主体区域 + 侧边停靠 -->
    <div class="app-body">
      <!-- 左侧：Project Explorer（固定） -->
      <aside class="panel-left">
        <div class="panel-header">
          <span class="panel-title">{{ $t('project_title') }}</span>
        </div>
        <ProjectExplorer />
      </aside>

      <!-- 中间：代码工作区 -->
      <main class="panel-center">
        <div class="workspace-placeholder">
          <div class="placeholder-icon">📝</div>
          <div class="placeholder-text">{{ $t('workspace_empty') }}</div>
        </div>
      </main>

      <!-- 右侧：停靠工具窗口（Tab 切换） -->
      <div class="dock-right" v-if="dockPanels.length > 0">
        <!-- Tab 栏 -->
        <div class="dock-tabs">
          <button class="dock-tab" v-for="panel in dockPanels" :key="panel.key"
                  :class="{ active: activeDock === panel.key }"
                  @click="activeDock = panel.key">
            <span class="dock-tab-icon">{{ getPanelIcon(panel.key) }}</span>
            <span class="dock-tab-title">{{ getPanelTitle(panel.key) }}</span>
            <span class="dock-tab-close" @click.stop="closeDock(panel.key)">✕</span>
          </button>
        </div>
        <!-- 当前激活的面板 -->
        <div class="dock-panel">
          <AgentCenterView v-if="activeDock === 'agent'" />
          <ContextManagerView v-else-if="activeDock === 'context'" />
          <ChangeReviewView v-else-if="activeDock === 'review'" />
          <AgentMonitorView v-else-if="activeDock === 'monitor'" />
          <KnowledgeCenterView v-else-if="activeDock === 'knowledge'" />
          <TaskBoardView v-else-if="activeDock === 'tasks'" />
        </div>
      </div>

      <!-- 右侧工具按钮条 -->
      <div class="tool-strip">
        <button class="strip-btn" :class="{ active: isOpen('agent') }"
                @click="toggleDock('agent')" title="Agent Center">🤖</button>
        <button class="strip-btn" :class="{ active: isOpen('context') }"
                @click="toggleDock('context')" title="Context">📋</button>
        <button class="strip-btn" :class="{ active: isOpen('review') }"
                @click="toggleDock('review')" title="Review">🔍</button>
        <button class="strip-btn" :class="{ active: isOpen('monitor') }"
                @click="toggleDock('monitor')" title="Monitor">📊</button>
        <button class="strip-btn" :class="{ active: isOpen('knowledge') }"
                @click="toggleDock('knowledge')" title="Knowledge">📚</button>
        <button class="strip-btn" :class="{ active: isOpen('tasks') }"
                @click="toggleDock('tasks')" title="Tasks">📌</button>
      </div>
    </div>

    <!-- 底部 -->
    <footer class="app-bottom">
      <div class="bottom-tabs">
        <span class="bottom-tab active">{{ $t('bottom_terminal') }}</span>
        <span class="bottom-tab">{{ $t('bottom_task_log') }}</span>
        <span class="bottom-tab">{{ $t('bottom_git') }}</span>
      </div>
      <div class="bottom-content">
        <ExecutionFlow />
      </div>
      <div class="bottom-status">
        <span class="status-item">{{ $t('status_tokens', { count: 0 }) }}</span>
        <span class="status-item">{{ $t('status_model', { name: 'Test' }) }}</span>
        <span class="status-item status-conn">{{ $t('status_disconnected') }}</span>
      </div>
    </footer>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import { useI18n } from 'vue-i18n'
import ProjectExplorer from './components/ProjectExplorer.vue'
import ExecutionFlow from './components/ExecutionFlow.vue'
import AgentCenterView from './views/AgentCenterView.vue'
import ContextManagerView from './views/ContextManagerView.vue'
import ChangeReviewView from './views/ChangeReviewView.vue'
import AgentMonitorView from './views/AgentMonitorView.vue'
import KnowledgeCenterView from './views/KnowledgeCenterView.vue'
import TaskBoardView from './views/TaskBoardView.vue'

const { t } = useI18n()
const dockPanels = ref([])
const activeDock = ref(null)

function getPanelTitle(key) {
  const map = {
    agent: t('persp_agent_center'),
    context: t('persp_context'),
    review: t('persp_review'),
    monitor: t('persp_monitor'),
    knowledge: t('persp_knowledge'),
    tasks: t('persp_tasks'),
  }
  return map[key] || key
}

function getPanelIcon(key) {
  const map = { agent: '🤖', context: '📋', review: '🔍', monitor: '📊', knowledge: '📚', tasks: '📌' }
  return map[key] || ''
}

function isOpen(key) {
  return dockPanels.value.some(p => p.key === key)
}

function toggleDock(key) {
  const idx = dockPanels.value.findIndex(p => p.key === key)
  if (idx >= 0) {
    dockPanels.value.splice(idx, 1)
    if (activeDock.value === key) {
      activeDock.value = dockPanels.value.length > 0 ? dockPanels.value[0].key : null
    }
  } else {
    dockPanels.value.push({ key })
    activeDock.value = key
  }
}

function closeDock(key) {
  dockPanels.value = dockPanels.value.filter(p => p.key !== key)
  if (activeDock.value === key) {
    activeDock.value = dockPanels.value.length > 0 ? dockPanels.value[0].key : null
  }
}
</script>

<style scoped>
.app-layout {
  display: flex;
  flex-direction: column;
  height: 100vh;
  background: #1e1e2e;
  color: #cdd6f4;
  font-size: 13px;
}

/* ===== 菜单栏 ===== */
.app-menubar {
  display: flex;
  align-items: center;
  height: 30px;
  background: #181825;
  border-bottom: 1px solid #313244;
  padding: 0 8px;
  user-select: none;
  flex-shrink: 0;
}
.app-logo { font-weight: 700; color: #cba6f7; margin-right: 16px; font-size: 13px; }
.menubar-center { display: flex; gap: 4px; }
.menubar-item {
  padding: 4px 10px; border-radius: 4px; cursor: pointer;
  color: #a6adc8; font-size: 12px;
}
.menubar-item:hover { background: #313244; color: #cdd6f4; }
.menubar-right { margin-left: auto; display: flex; align-items: center; gap: 8px; }
.lang-switch {
  background: #313244; color: #cdd6f4; border: 1px solid #45475a;
  border-radius: 4px; padding: 2px 6px; font-size: 11px; cursor: pointer;
}
.connection-dot {
  display: inline-block; width: 8px; height: 8px; border-radius: 50%; background: #f38ba8;
}
.connection-dot.connected { background: #a6e3a1; }

/* ===== 主体 ===== */
.app-body { display: flex; flex: 1; min-height: 0; overflow: hidden; }

/* 左侧面板 */
.panel-left {
  width: 220px; background: #1e1e2e; border-right: 1px solid #313244;
  display: flex; flex-direction: column; flex-shrink: 0; overflow: hidden;
}
.panel-header {
  padding: 8px 12px; border-bottom: 1px solid #313244; flex-shrink: 0;
}
.panel-title {
  font-size: 11px; font-weight: 600; text-transform: uppercase;
  color: #a6adc8; letter-spacing: 0.5px;
}

/* 中央工作区 */
.panel-center { flex: 1; display: flex; min-width: 0; overflow: hidden; }
.workspace-placeholder {
  flex: 1; display: flex; flex-direction: column;
  align-items: center; justify-content: center; color: #6c7086;
}
.placeholder-icon { font-size: 48px; margin-bottom: 16px; opacity: 0.3; }
.placeholder-text { font-size: 14px; }

/* ===== 右侧停靠窗口（Tab 切换） ===== */
.dock-right {
  display: flex;
  flex-direction: column;
  border-left: 1px solid #313244;
  background: #1e1e2e;
  width: 460px;
  overflow: hidden;
}
.dock-tabs {
  display: flex;
  background: #11111b;
  border-bottom: 1px solid #313244;
  flex-shrink: 0;
  overflow-x: auto;
}
.dock-tab {
  display: flex;
  align-items: center;
  gap: 4px;
  padding: 6px 12px;
  font-size: 12px;
  color: #6c7086;
  background: transparent;
  border: none;
  border-right: 1px solid #313244;
  border-bottom: 2px solid transparent;
  cursor: pointer;
  white-space: nowrap;
  flex-shrink: 0;
}
.dock-tab:hover { color: #cdd6f4; background: #1e1e2e; }
.dock-tab.active {
  color: #cdd6f4;
  background: #1e1e2e;
  border-bottom-color: #cba6f7;
}
.dock-tab-icon { font-size: 12px; }
.dock-tab-title { font-size: 11px; }
.dock-tab-close {
  margin-left: 4px; font-size: 10px; color: #6c7086;
  padding: 0 2px; border-radius: 2px;
}
.dock-tab-close:hover { background: #f38ba8; color: #1e1e2e; }
.dock-panel { flex: 1; overflow-y: auto; min-height: 0; }
.dock-panel :deep(.agent-center),
.dock-panel :deep(.context-manager),
.dock-panel :deep(.review-center),
.dock-panel :deep(.monitor-center),
.dock-panel :deep(.knowledge-center),
.dock-panel :deep(.task-board) {
  padding: 12px;
}
.dock-panel :deep(.center-title) { font-size: 15px; }

/* ===== 右侧工具按钮条 ===== */
.tool-strip {
  display: flex;
  flex-direction: column;
  width: 36px;
  background: #181825;
  border-left: 1px solid #313244;
  padding: 4px 0;
  flex-shrink: 0;
}
.strip-btn {
  background: transparent; border: none; color: #6c7086;
  font-size: 16px; padding: 6px 0; cursor: pointer; text-align: center;
  border-left: 2px solid transparent;
}
.strip-btn:hover { color: #cdd6f4; background: #313244; }
.strip-btn.active { color: #cba6f7; border-left-color: #cba6f7; }

/* ===== 底部 ===== */
.app-bottom {
  height: 180px; background: #181825; border-top: 1px solid #313244;
  display: flex; flex-direction: column; flex-shrink: 0;
}
.bottom-tabs {
  display: flex; background: #11111b; border-bottom: 1px solid #313244; flex-shrink: 0;
}
.bottom-tab {
  padding: 6px 14px; font-size: 11px; color: #6c7086;
  cursor: pointer; border-right: 1px solid #313244;
}
.bottom-tab.active { color: #cdd6f4; background: #1e1e2e; }
.bottom-content { flex: 1; overflow-y: auto; padding: 8px; }
.bottom-status {
  display: flex; align-items: center; height: 24px;
  background: #11111b; border-top: 1px solid #313244;
  padding: 0 12px; gap: 16px; flex-shrink: 0;
}
.status-item { font-size: 11px; color: #6c7086; }
.status-conn { margin-left: auto; color: #f38ba8; }
</style>
