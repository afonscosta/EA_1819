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
    console.log('add user enviado para o backend', user)
    usersService.postUser(user).then(user => {
      commit('addUser', user)
    })
  },
  updateUser ({ commit }, user) {
    console.log('update user enviado para o backend', user)
    usersService.putUser(user).then(() => {
      commit('updateUser', user)
    })
  },
  deleteUser ({ commit }, userID) {
    usersService.deleteUser(userID)
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
