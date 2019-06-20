import loginService from '../../services/loginService'

const state = {
  sessionID: ''
}

const getters = {
  sessionID: state => {
    return state.sessionID
  }
}

const mutations = {
  setSessionID (state, response) {
    state.sessionID = response.id
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
  }
}

export default {
  namespaced: true,
  actions,
  state,
  getters,
  mutations
}
