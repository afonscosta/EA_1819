module.exports = {
  devServer: {
    port: 8081,
    // autoOpenBrowser: true,
    // assetsSubDirectory: 'static',
    // assetsPublicPath: '/',
    proxy: {
      '^/Home4All': {
        target: 'http://localhost:8080',
        ws: true,
        changeOrigin: true
      }
    }
  }
}
