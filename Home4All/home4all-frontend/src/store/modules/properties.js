import propertiesService from '../../services/propertiesService'

const state = {
  properties: []
}

const getters = {
  properties: state => {
    return state.properties
  }
}

const mutations = {
  setPropeties (state, properties) {
    state.properties = properties
  },
  addProperty (state, property) {
    state.properties.push(property)
  },
  updateProperty (state, property) {
    state.properties = state.properties.filter(u => u.id !== property.id)
    state.properties.push(property)
  },
  deleteProperty (state, propertyID) {
    state.properties = state.properties.filter(u => u.id !== propertyID)
  }
}

const actions = {
  getProperties ({ commit }) {
    propertiesService.fetchProperties().then(properties => {
      commit('setPropeties', properties)
    })
  },
  addProperty ({ commit }, property) {
    console.log('add property enviado para o backend')
    propertiesService.postProperty(property).then(newProperty => {
      commit('addProperty', newProperty)
    })
  },
  updateProperty ({ commit }, property) {
    console.log('update property enviado para o backend', property)
    propertiesService.postProperty(property).then(() => {
      commit('updateProperty', property)
    })
  },
  deleteProperty ({ commit }, propertyID) {
    propertiesService.deleteProperty(propertyID)
    commit('deleteProperty', propertyID)
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
