import home4all from '@/services/home4all'
import store from '../store/modules/login'

export default {
  login (payload) {
    return home4all.post(`login`, {
      email: payload.email,
      password: payload.password
    }).then(response => response.data)
  },
  logout () {
    return home4all.post(`logout`, {}, {
      Cookie: `JSESSIONID=${store.state.sessionID}`
    }).then(response => response.data)
  }
}
