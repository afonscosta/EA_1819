import home4all from '@/services/home4all'
import store from '../store/modules/login'

export default {
  fetchProperties (payload) {
    return home4all.get(`search/`, {
      params: {
        payload
      }
    }, {
      Cookie: `JSESSIONID=${store.state.sessionID}`
    }).then(response => response.data)
  }
}
