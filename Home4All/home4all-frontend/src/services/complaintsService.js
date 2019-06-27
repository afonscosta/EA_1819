import home4all from '@/services/home4all'
import store from '../store/modules/login'

export default {
  fetchComplaints () {
    return home4all.get(`complaints`, {}, {
      Cookie: `JSESSIONID=${store.state.sessionID}`
    }).then(response => response.data)
  },
  blockUser (id) {
    return home4all.delete(`users/${id}`, {}, {
      Cookie: `JSESSIONID=${store.state.sessionID}`
    })
  },
  blockProperty (id) {
    return home4all.delete(`properties/${id}`, {
      id: id
    }, {
      Cookie: `JSESSIONID=${store.state.sessionID}`
    })
  }
}
