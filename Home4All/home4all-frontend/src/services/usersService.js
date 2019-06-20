import home4all from '@/services/home4all'
import store from '../store/modules/login'

export default {
  fetchUsers () {
    return home4all.get(`users`).then(response => response.data)
  },
  postUser (payload) {
    return home4all.post(`users`, payload).then(response => response.data)
  },
  deleteUser (userId) {
    return home4all.delete(`users/${userId}`).then(response => response.data)
  },
  teste () {
    return home4all.get(`users`, {
      Cookie: `JSESSIONID=${store.state.sessionID}`
    }).then(response => response.data)
  }
}
