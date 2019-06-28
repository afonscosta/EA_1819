import home4all from '@/services/home4all'
import store from '../store/modules/login'

export default {
  fetchComplaints () {
    return home4all.get(`complaints`, {}, {
      Cookie: `JSESSIONID=${store.state.sessionID}`
    }).then(response => response.data)
  },
  blockUser (id) {
    console.log(id)
    return home4all.delete(`users/${id}`, {}, {
      Cookie: `JSESSIONID=${store.state.sessionID}`
    })
  },
  blockProperty (id) {
    return home4all.delete(`properties/${id}`, {}, {
      Cookie: `JSESSIONID=${store.state.sessionID}`
    })
  },
  doComplaint (payload) {
    return home4all.post(`properties`, {
      payload
    }, {
      Cookie: `JSESSIONID=${store.state.sessionID}`
    })
  }
}
