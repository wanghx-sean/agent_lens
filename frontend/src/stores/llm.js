import { defineStore } from 'pinia'
import axios from 'axios'

const api = axios.create({ baseURL: '/api' })

export const useLlmStore = defineStore('llm', {
  state: () => ({
    messages: [],
    loading: false,
    backendConnected: false
  }),

  actions: {
    async sendMessage(text) {
      this.loading = true
      this.messages.push({ role: 'user', content: text })
      try {
        const res = await api.post('/llm/chat', { message: text })
        this.messages.push({ role: 'assistant', content: res.data })
      } catch (err) {
        this.messages.push({ role: 'assistant', content: `[Error] ${err.message}` })
      } finally {
        this.loading = false
      }
    },

    async checkHealth() {
      try {
        const res = await api.get('/health')
        this.backendConnected = res.data.status === 'UP'
      } catch {
        this.backendConnected = false
      }
    }
  }
})
