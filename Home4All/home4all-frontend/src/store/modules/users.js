import usersService from '../../services/usersService'

const state = {
  users: []
}

const getters = {
  users: state => {
    return state.users
  }
}

const mutations = {
  setUsers (state, users) {
    state.users = users
  },
  addUser (state, user) {
    state.users.push(user)
  },
  updateUser (state, user) {
    state.users = state.users.filter(u => u.id !== user.id)
    state.users.push(user)
  },
  deleteUser (state, userID) {
    state.users = state.users.filter(u => u.id !== userID)
  }
}

const actions = {
  addUser ({ commit }, user) {
    return new Promise((resolve, reject) => {
      usersService.postUser(user).then(user => {
        console.log('add user enviado para o backend', user)
        commit('addUser', user)
      }).then(() => {
        resolve(user)
      }, error => {
        reject(error)
      })
    })
  },
  updateUser ({ commit }, user) {
    return new Promise((resolve, reject) => {
      usersService.pushUser(user).then(() => {
        commit('updateUser', user)
      }).then(() => {
        resolve(user)
      }, error => {
        reject(error)
      })
    })
  },
  deleteUser ({ commit }, userID) {
    usersService.deleteUser()
    commit('deleteUser', userID)
  },
  teste ({ commit }) {
    usersService.teste()
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
