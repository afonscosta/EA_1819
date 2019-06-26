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
  },
  removeUserComplaints (state, id) {
    state.complaints = state.complaints.filter(c => c.owner !== id)
  },
  removePropertyComplaint (state, id) {
    state.complaints = state.complaints.filter(c => c.id !== id)
  }
}

const actions = {
  getComplaints ({ commit }) {
    complaintsService.fetchComplaints().then(complaints => {
      commit('setComplaints', complaints)
    })
  },
  blockUser ({ commit }, id) {
    complaintsService.blockUser(id).then(() => {
      commit('removeUserComplaints', id)
    })
  },
  blockProperty ({ commit }, id) {
    complaintsService.blockProperty(id).then(() => {
      commit('removePropertyComplaint', id)
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
