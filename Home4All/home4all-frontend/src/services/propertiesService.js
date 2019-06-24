import home4all from '@/services/home4all'

export default {
  fetchProperties () {
    return home4all.get(`properties`).then(response => response.data)
  },
  fetchProperty (propertyID) {
    return home4all.get(`properties/${propertyID}`).then(response => response.data)
  },
  postProperty (payload) {
    return home4all.post(`properties`, payload).then(response => response.data)
  },
  deleteProperty (propertyID) {
    return home4all.delete(`properties/${propertyID}`).then(response => response.data)
  }
}
