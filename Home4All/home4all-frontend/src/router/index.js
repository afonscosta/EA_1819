import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/views/Home.vue'
import Search from '@/views/Search.vue'

// Property
import PropertyAdd from '@/views/Property/PropertyAdd.vue'
import PropertyEdit from '@/views/Property/PropertyEdit.vue'
import PropertyView from '@/views/Property/PropertyView.vue'
import Comparison from '@/views/Property/Comparison.vue'

import Register from '@/views/Register.vue'
import Login from '@/views/Login.vue'
import UserInfo from '@/views/UserInfo.vue'
import Complaints from '@/views/Complaints.vue'

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
      path: '/property/comparison',
      name: 'comparison',
      component: Comparison
    },
    {
      path: '/property/add',
      name: 'propertyAdd',
      component: PropertyAdd
    },
    {
      path: '/property/edit',
      name: 'propertyEdit',
      component: PropertyEdit
    },
    {
      path: '/property/view',
      name: 'propertyView',
      component: PropertyView
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
    },
    {
      path: '/profile',
      name: 'profile',
      component: UserInfo
    },
    {
      path: '/complaints',
      name: 'complaints',
      component: Complaints
    }
  ]
})
