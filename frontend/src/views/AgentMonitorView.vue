<template>
  <div class="monitor-center">
    <div class="center-header">
      <h2 class="center-title">📊 {{ $t('persp_monitor') }}</h2>
    </div>
    <div class="monitor-grid">
      <div class="agent-card" v-for="a in agents" :key="a.name">
        <div class="agent-card-header">
          <span class="agent-dot-lg" :class="a.state"></span>
          <span class="agent-card-name">{{ a.name }}</span>
          <span class="agent-card-state">{{ $t('state_' + a.state) }}</span>
        </div>
        <div class="agent-card-body">
          <div class="agent-metric"><span>Task:</span> {{ a.task }}</div>
          <div class="agent-metric"><span>Duration:</span> {{ a.duration }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const agents = ref([
  { name: 'Planner Agent', state: 'running', task: '分析代码结构', duration: '1.2s' },
  { name: 'Coding Agent', state: 'waiting', task: '等待', duration: '-' },
  { name: 'Test Agent', state: 'completed', task: '运行测试', duration: '3.5s' },
])
</script>

<style scoped>
.monitor-center {
  padding: 24px;
  height: 100%;
  overflow-y: auto;
  background: #1e1e2e;
  flex: 1;
}
.center-header { margin-bottom: 16px; }
.center-title { font-size: 18px; font-weight: 600; color: #cdd6f4; }
.monitor-grid { display: flex; flex-direction: column; gap: 12px; }
.agent-card {
  background: #181825;
  border: 1px solid #313244;
  border-radius: 8px;
  padding: 16px;
}
.agent-card-header {
  display: flex; align-items: center; gap: 8px; margin-bottom: 10px;
}
.agent-dot-lg {
  width: 10px; height: 10px; border-radius: 50%; flex-shrink: 0;
}
.agent-dot-lg.running { background: #a6e3a1; box-shadow: 0 0 6px #a6e3a1; }
.agent-dot-lg.waiting { background: #6c7086; }
.agent-dot-lg.completed { background: #89b4fa; }
.agent-dot-lg.error { background: #f38ba8; }
.agent-card-name { font-weight: 600; font-size: 14px; color: #cdd6f4; }
.agent-card-state { margin-left: auto; font-size: 12px; color: #a6adc8; }
.agent-card-body { display: flex; flex-direction: column; gap: 4px; }
.agent-metric { font-size: 12px; color: #a6adc8; }
.agent-metric span { color: #6c7086; }
</style>
