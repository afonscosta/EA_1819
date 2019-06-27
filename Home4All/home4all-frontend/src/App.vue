<template>
  <div id="app">
    <Navbar></Navbar>
    <router-view/>
    <Footer/>
  </div>
</template>

<script>
import Navbar from '@/components/Navbar'
import Footer from '@/components/Footer'

export default {
  components: {
    Navbar,
    Footer
  },
  created () {
    var sessionID = localStorage.getItem('sessionID')
    if (sessionID) {
      this.$store.dispatch('login/setPlainSessionID', sessionID)
      this.$router.push('/')
    } else {
      this.$router.push({ name: 'home' })
    }
  }
}
</script>

<style>
html,
body {
 height: 100%;
 width: 100%;
}

#app {
  min-height: 100%;
  display: grid;
  grid-template-rows: auto 1fr auto;
  grid-template-columns: 100%;
}

#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}
#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
