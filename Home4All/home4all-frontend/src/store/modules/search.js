import searchService from '../../services/searchService'

const state = {
  properties: [],
  searchParams: {}
}

const getters = {
  properties: state => {
    return state.properties
  },
  searchParams: state => {
    return state.searchParams
  }
}

const mutations = {
  setProperties (state, properties) {
    state.properties = properties
  },
  setSearchParams (state, payload) {
    state.searchParams = payload
  }
}

const actions = {
  doSearch ({ commit }, payload) {
    console.log('payload do search', payload)
    searchService.fetchProperties(payload).then(properties => {
      console.log('properties received after search', properties)
      commit('setSearchParams', payload)
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
