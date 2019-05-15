import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/views/Home.vue'
import Search from '@/views/Search.vue'
import Comparison from '@/views/Comparison.vue'
import Sell from '@/views/Sell.vue'
import Register from '@/views/Register.vue'
import Login from '@/views/Login.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/search',
      name: 'search',
      component: Search
    },
    {
      path: '/comparison',
      name: 'comparison',
      component: Comparison
    },
    {
      path: '/sell',
      name: 'sell',
      component: Sell
    },
    {
      path: '/register',
      name: 'register',
      component: Register
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    }
  ]
})
