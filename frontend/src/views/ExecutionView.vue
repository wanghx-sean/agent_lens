<template>
  <div class="panel">
    <h2>Execution</h2>
    <p class="placeholder">可视化 Agent 执行流程——每个步骤的执行过程、输入输出。</p>
    <div class="flow">
      <div class="step completed">
        <div class="step-dot"></div>
        <div class="step-info">
          <div class="step-name">User Input</div>
          <div class="step-status">等待输入</div>
        </div>
      </div>
      <div class="step pending">
        <div class="step-dot"></div>
        <div class="step-info">
          <div class="step-name">Prompt</div>
          <div class="step-status">等待执行</div>
        </div>
      </div>
      <div class="step pending">
        <div class="step-dot"></div>
        <div class="step-info">
          <div class="step-name">LLM</div>
          <div class="step-status">等待执行</div>
        </div>
      </div>
      <div class="step pending">
        <div class="step-dot"></div>
        <div class="step-info">
          <div class="step-name">Answer</div>
          <div class="step-status">等待执行</div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.panel { height: 100%; }
.placeholder { color: #888; margin: 12px 0 24px; font-size: 14px; }
.flow { display: flex; flex-direction: column; gap: 0; }
.step {
  display: flex; align-items: flex-start; gap: 12px;
  padding: 16px 0; position: relative;
}
.step:not(:last-child)::after {
  content: ''; position: absolute; left: 8px; top: 36px;
  width: 2px; height: 24px; background: #0f3460;
}
.step-dot {
  width: 18px; height: 18px; border-radius: 50%;
  background: #0f3460; flex-shrink: 0; margin-top: 2px;
}
.step.completed .step-dot { background: #4caf50; }
.step.active .step-dot { background: #e94560; box-shadow: 0 0 8px #e94560; }
.step-info { flex: 1; }
.step-name { font-weight: 600; font-size: 14px; }
.step-status { font-size: 12px; color: #666; margin-top: 4px; }
</style>
