import propertiesService from '../../services/propertiesService'

const state = {
  properties: [], // All properties being used
  props_compare: [], // Properties to compare
  property: {} // View details
}

const getters = {
  properties: state => {
    return state.properties
  },
  props_compare: state => {
    return state.props_compare
  },
  property: state => {
    return state.property
  }
}

const mutations = {
  setProperties (state, properties) {
    state.properties = properties
  },
  addProperty (state, property) {
    state.properties.push(property)
    state.property = property
  },
  updateProperty (state, property) {
    state.properties = state.properties.filter(u => u.id !== property.id)
    state.properties.push(property)
  },
  deleteProperty (state, propertyID) {
    state.properties = state.properties.filter(u => u.id !== propertyID)
  },
  // Compare
  addPropCompare (state, property) {
    state.props_compare.push(property)
  },
  removeProCompare (state, propertyID) {
    state.props_compare = state.props_compare.filter(u => u.id !== propertyID)
  },
  // Details
  setProperty (state, property) {
    state.property = property
  }
}

const actions = {
  setProperties ({ commit }, properties) {
    commit('setProperties', properties)
  },
  getProperties ({ commit }) {
    propertiesService.fetchProperties().then(properties => {
      commit('setProperties', properties)
    })
  },
  addProperty ({ commit }, property) {
    console.log('add property enviado para o backend')
    propertiesService.postProperty(property).then(newProperty => {
      console.log('newProperty', newProperty)
      commit('addProperty', newProperty)
      commit('addPropCompare', newProperty)
      commit('addPropCompare', newProperty)
      commit('addPropCompare', newProperty)
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
  },
  // Compare
  addPropCompare ({ commit }, property) {
    console.log('property added to compare')
    commit('addPropCompare', property)
  },
  removePropCompare ({ commit }, propertyID) {
    commit('removePropCompare', propertyID)
  },
  // Details
  setProperty ({ commit }, property) {
    console.log('setting property to view details', property)
    commit('setProperty', property)
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
