<template>
  <div class="project-explorer">
    <!-- @claude [think] 项目文件树占位，后续实现文件树组件 -->
    <div class="tree-node">
      <span class="tree-folder">📁 src</span>
    </div>
    <div class="tree-node">
      <span class="tree-folder">📁 docs</span>
    </div>
    <div class="tree-node">
      <span class="tree-folder">📁 tests</span>
    </div>
    <div class="tree-divider"></div>
    <div class="tree-node">
      <span class="tree-folder">📁 .agent</span>
    </div>
    <div class="tree-node tree-indent">
      <span class="tree-folder">📁 memory</span>
    </div>
    <div class="tree-node tree-indent">
      <span class="tree-folder">📁 context</span>
    </div>
    <div class="tree-node tree-indent">
      <span class="tree-file">📄 tasks</span>
    </div>
    <div class="tree-divider"></div>
    <div class="tree-node">
      <span class="tree-file">📄 README.md</span>
    </div>
  </div>
</template>

<style scoped>
.project-explorer {
  padding: 4px 0;
  overflow-y: auto;
  flex: 1;
}
.tree-node {
  padding: 3px 8px;
  cursor: pointer;
  font-size: 12px;
}
.tree-node:hover {
  background: #313244;
}
.tree-indent {
  padding-left: 24px;
}
.tree-divider {
  height: 1px;
  background: #313244;
  margin: 4px 8px;
}
.tree-folder {
  color: #fab387;
}
.tree-file {
  color: #a6adc8;
}
</style>
