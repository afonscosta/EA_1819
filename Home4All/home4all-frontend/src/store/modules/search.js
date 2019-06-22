import searchService from '../../services/searchService'

const state = {
  properties: []
}

const getters = {
  properties: state => {
    return state.properties
  }
}

const mutations = {
  setProperties (state, properties) {
    state.properties = properties
  }
}

const actions = {
  doSearch ({ commit }, payload) {
    console.log('payload do search', payload)
    searchService.fetchProperties(payload).then(properties => {
      console.log('properties received after search', properties)
      commit('setProperties', properties)
    })
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
