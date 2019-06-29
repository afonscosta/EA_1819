module.exports = {
  devServer: {
    port: 8081,
    // autoOpenBrowser: true,
    // assetsSubDirectory: 'static',
    // assetsPublicPath: '/',
    proxy: {
      '^/Home4All': {
        target: 'http://10.254.233.137:8080',
        ws: true,
        changeOrigin: true
      }
    }
  }
}
