import { createI18n } from 'vue-i18n'
import en from './locales/en.js'
import zh from './locales/zh.js'

const i18n = createI18n({
  locale: 'zh',        // 默认中文
  fallbackLocale: 'en', // 找不到 key 时回退英文
  messages: { en, zh }
})

export default i18n
