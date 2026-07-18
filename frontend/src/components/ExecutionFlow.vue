<template>
  <div class="execution-flow">
    <!-- @claude [think] Execution 流程占位，后续显示 Agent 执行步骤 -->
    <div class="flow-step" v-for="(step, i) in steps" :key="i"
         :class="{ active: step.active, done: step.done }">
      <div class="flow-step-dot"></div>
      <div class="flow-step-info">
        <span class="flow-step-name">{{ step.name }}</span>
        <span class="flow-step-status">{{ step.status }}</span>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const steps = ref([
  { name: 'User Input', status: 'waiting', active: false, done: false },
  { name: 'Prompt', status: 'waiting', active: false, done: false },
  { name: 'Context', status: 'waiting', active: false, done: false },
  { name: 'LLM', status: 'waiting', active: false, done: false },
  { name: 'Answer', status: 'waiting', active: false, done: false },
])
</script>

<style scoped>
.execution-flow {
  display: flex;
  align-items: center;
  gap: 0;
  height: 100%;
  padding: 4px 0;
}
.flow-step {
  display: flex;
  align-items: center;
  gap: 6px;
  padding: 4px 12px 4px 0;
  position: relative;
  font-size: 12px;
}
.flow-step:not(:last-child)::after {
  content: '→';
  color: #6c7086;
  margin-left: 12px;
}
.flow-step-dot {
  width: 8px;
  height: 8px;
  border-radius: 50%;
  background: #45475a;
  flex-shrink: 0;
}
.flow-step.done .flow-step-dot {
  background: #a6e3a1;
}
.flow-step.active .flow-step-dot {
  background: #cba6f7;
  box-shadow: 0 0 6px #cba6f7;
}
.flow-step-info {
  display: flex;
  gap: 6px;
  align-items: center;
}
.flow-step-name {
  color: #a6adc8;
}
.flow-step-status {
  color: #6c7086;
  font-size: 11px;
}
.flow-step.active .flow-step-name {
  color: #cdd6f4;
  font-weight: 600;
}
</style>
