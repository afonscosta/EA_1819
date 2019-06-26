import Vue from 'vue'
import Vuex from 'vuex'
import users from './modules/users'
import properties from './modules/properties'
import search from './modules/search'
import login from './modules/login'
import statistics from './modules/statistics'
import complaints from './modules/complaints'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    users,
    properties,
    search,
    login,
    statistics,
    complaints
  }
})
