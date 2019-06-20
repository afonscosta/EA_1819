import loginService from '../../services/loginService'

// const state = {
//   users: []
// }

// const getters = {
//   users: state => {
//     return state.users
//   }
// }

// const mutations = {
//   setUsers (state, users) {
//     state.users = users
//   },
//   addUser (state, user) {
//     state.users.push(user)
//   },
//   updateUser (state, user) {
//     state.users = state.users.filter(u => u.id !== user.id)
//     state.users.push(user)
//   },
//   deleteUser (state, userID) {
//     state.users = state.users.filter(u => u.id !== userID)
//   }
// }

const actions = {
  login ({ commit }, payload) {
    return new Promise((resolve, reject) => {
      loginService.login(payload).then(response => {
        // fazer algo com a response
      }).then(() => {
        resolve('login com sucesso')
      }, error => {
        reject(error)
      })
    })
  }
}

export default {
  namespaced: true,
  actions
//   state,
//   getters,
//   mutations
}
