<template>
  <div class="app-layout">
    <aside class="sidebar">
      <nav class="nav-menu">
        <router-link to="/" class="nav-item">Chat</router-link>
        <router-link to="/prompt" class="nav-item">Prompt</router-link>
        <router-link to="/context" class="nav-item">Context</router-link>
        <router-link to="/memory" class="nav-item">Memory</router-link>
        <router-link to="/token" class="nav-item">Token</router-link>
        <router-link to="/execution" class="nav-item">Execution</router-link>
      </nav>
    </aside>
    <main class="main-content">
      <router-view />
    </main>
  </div>
</template>

<script setup>
</script>

<style scoped>
.app-layout {
  display: flex;
  height: 100vh;
  background: #1a1a2e;
  color: #e0e0e0;
}
.sidebar {
  width: 200px;
  background: #16213e;
  padding: 16px;
  border-right: 1px solid #0f3460;
}
.nav-menu {
  display: flex;
  flex-direction: column;
  gap: 8px;
}
.nav-item {
  color: #a0a0b8;
  text-decoration: none;
  padding: 10px 16px;
  border-radius: 6px;
  transition: all 0.2s;
}
.nav-item:hover {
  background: #0f3460;
  color: #fff;
}
.nav-item.router-link-active {
  background: #e94560;
  color: #fff;
}
.main-content {
  flex: 1;
  padding: 24px;
  overflow-y: auto;
}
</style>
