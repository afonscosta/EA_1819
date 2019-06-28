import loginService from '../../services/loginService'
import usersService from '../../services/usersService'

const state = {
  sessionID: '',
  user: null,
  isAdmin: false,
  image: null
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
  },
  image: state => {
    return state.image
  }
}

const mutations = {
  setSessionID (state, response) {
    state.sessionID = response.id
    localStorage.setItem('sessionID', response.id)
    state.user = response.user
    state.isAdmin = response.isAdmin
    state.image = response.user.image
  },
  setPlainSessionID (state, sessionID) {
    state.sessionID = sessionID
  },
  setUser (state, response) {
    state.user = response
    state.image = response.image
  },
  logout (state) {
    state.user = null
    state.sessionID = ''
    state.isAdmin = false
    localStorage.clear()
  }
}

const actions = {
  setPlainSessionID ({ commit }, sessionID) {
    commit('setPlainSessionID', sessionID)
  },
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
      loginService.logout().then(() => {
        commit('logout')
      }).then(() => {
        resolve('logout')
      }, error => {
        reject(error)
      })
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
