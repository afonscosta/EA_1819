import Vue from 'vue'
import Vuex from 'vuex'
import users from './modules/users'
import properties from './modules/properties'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    users,
    properties
  }
})
