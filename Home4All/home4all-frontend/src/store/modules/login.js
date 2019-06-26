import loginService from '../../services/loginService'
import usersService from '../../services/usersService'

const state = {
  sessionID: '',
  user: null,
  isAdmin: false
}

const getters = {
  sessionID: state => {
    return state.sessionID
  },
  user: state => {
    return state.user
  },
  isAdmin: state => {
    return state.isAdmin
  }
}

const mutations = {
  setSessionID (state, response) {
    state.sessionID = response.id
    state.user = response.user
    state.user.isAdmin = response.isAdmin
  },
  setUser (state, response) {
    state.user = response
  },
  logout (state) {
    state.user = null
    state.sessionID = ''
  }
}

const actions = {
  login ({ commit }, payload) {
    return new Promise((resolve, reject) => {
      loginService.login(payload).then(response => {
        commit('setSessionID', response)
      }).then(() => {
        resolve(state.sessionID)
      }, error => {
        reject(error.response)
      })
    })
  },
  logout ({ commit }) {
    return new Promise((resolve, reject) => {
      commit('logout')
      resolve('logout')
    })
  },
  getUser ({ commit }) {
    usersService.fetchUser().then(user => {
      console.log(user)
      commit('setUser', user)
    })
  }
}

export default {
  namespaced: true,
  actions,
  state,
  getters,
  mutations
}
