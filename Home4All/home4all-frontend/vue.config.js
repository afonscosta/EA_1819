module.exports = {
  devServer: {
    port: 8081,
    // autoOpenBrowser: true,
    // assetsSubDirectory: 'static',
    // assetsPublicPath: '/',
    proxy: {
      '^/Home4All': {
        target: 'http://127.0.0.1:8080',
        ws: true,
        changeOrigin: true
      }
    }
  }
}
