import home4all from '@/services/home4all'
import store from '../store/modules/login'

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
    return home4all.delete(`properties/${propertyID}`, {}, {
      Cookie: `JSESSIONID=${store.state.sessionID}`
    }).then(response => response.data)
  },
  getUserProperties () {
    return home4all.get(`properties`, {}, {
      Cookie: `JSESSIONID=${store.state.sessionID}`
    }).then(response => response.data)
  }
}
