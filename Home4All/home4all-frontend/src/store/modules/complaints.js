import complaintsService from '../../services/complaintsService'

const state = {
  complaints: ''
}

const getters = {
  complaints: state => {
    return state.complaints
  }
}

const mutations = {
  setComplaints (state, response) {
    state.complaints = response
  }
}

const actions = {
  getComplaints ({ commit }) {
    complaintsService.fetchComplaints().then(complaints => {
      commit('setComplaints', complaints)
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
