import home4all from '@/services/home4all'
import store from '../store/modules/login'

export default {
  fetchUser () {
    return home4all.get(`users`, {}, {
      Cookie: `JSESSIONID=${store.state.sessionID}`
    }).then(response => response.data)
  },
  putUser (payload) {
    return home4all.put(`users`, payload, {
      Cookie: `JSESSIONID=${store.state.sessionID}`
    }).then(response => response.data)
  },
  postUser (payload) {
    return home4all.post(`users`, payload).then(response => response.data)
  },
  deleteUser () {
    return home4all.delete(`users`, {}, {
      Cookie: `JSESSIONID=${store.state.sessionID}`
    }).then(response => response.data)
  }
}
