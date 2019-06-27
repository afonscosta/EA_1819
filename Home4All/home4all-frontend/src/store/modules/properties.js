import propertiesService from '../../services/propertiesService'
import searchService from '../../services/searchService'

const state = {
  properties: [], // All properties being used
  props_compare: [], // Properties to compare
  property: {}, // View details
  propertyEdit: {}, // Edit details
  searchParams: {},
  userProperties: [] // Info for myProperties page
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
  },
  propertyEdit: state => {
    return state.propertyEdit
  },
  num_props_compare: state => {
    return state.props_compare.length
  },
  searchParams: state => {
    return state.searchParams
  },
  userProperties: state => {
    return state.userProperties
  }
}

const mutations = {
  setUserProperties (state, properties) {
    state.userProperties = properties
  },
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
  removePropCompare (state, propertyID) {
    state.props_compare = state.props_compare.filter(u => u.id !== propertyID)
  },
  // Details
  setProperty (state, property) {
    state.property = property
  },
  // Edit
  setPropertyEdit (state, property) {
    state.propertyEdit = property
  },
  setSearchParams (state, payload) {
    state.searchParams = payload
  }
}

const actions = {
  getUserProperties ({ commit }) {
    propertiesService.getUserProperties().then(properties => {
      console.log('USER PROPERTIES', properties)
      commit('setUserProperties', properties)
    })
  },
  setProperties ({ commit }, properties) {
    commit('setProperties', properties)
  },
  getProperties ({ commit }) {
    propertiesService.fetchProperties().then(properties => {
      commit('setProperties', properties)
    })
  },
  getProperty ({ commit }, propertyID) {
    return new Promise((resolve, reject) => {
      propertiesService.fetchProperty(propertyID)
        .then(property => {
          commit('setProperty', property)
        })
        .then(() => {
          resolve()
        })
        .catch((error) => {
          reject(error)
        })
    })
  },
  addProperty ({ commit }, property) {
    console.log('add property enviado para o backend')
    propertiesService.postProperty(property).then(newProperty => {
      console.log('newProperty', newProperty)
      commit('addProperty', newProperty)
    })
  },
  updateProperty ({ commit }, property) {
    console.log('update property enviado para o backend', property)
    propertiesService.postProperty(property).then(() => {
      commit('updateProperty', property)
      commit('setProperty', property)
      commit('setPropertyEdit', {})
    })
  },
  deleteProperty ({ commit }, propertyID) {
    propertiesService.deleteProperty(propertyID)
    commit('deleteProperty', propertyID)
    commit('setProperty', {})
    commit('removePropCompare', propertyID)
  },
  // Compare
  addPropCompare ({ commit }, property) {
    console.log('property added to compare')
    commit('addPropCompare', property)
  },
  removePropCompare ({ commit }, propertyID) {
    console.log('property removed from compare')
    commit('removePropCompare', propertyID)
  },
  // Details
  setProperty ({ commit }, property) {
    console.log('setting property to view details', property)
    commit('setProperty', property)
  },
  // Details
  setPropertyEdit ({ commit }, property) {
    console.log('setting property to edit details', property)
    commit('setPropertyEdit', JSON.parse(JSON.stringify(property)))
  },
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
