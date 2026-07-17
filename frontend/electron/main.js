import { app, BrowserWindow } from 'electron'

function createWindow() {
  const win = new BrowserWindow({
    width: 1400,
    height: 900,
    webPreferences: {
      nodeIntegration: true
    }
  })

  if (process.env.VITE_DEV_SERVER_URL) {
    win.loadURL(process.env.VITE_DEV_SERVER_URL)
  } else {
    win.loadFile('dist/index.html')
  }
}

app.whenReady().then(createWindow)

app.on('window-all- closed', () => {
  app.quit()
})
