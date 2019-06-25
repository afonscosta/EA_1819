import home4all from '@/services/home4all'
import store from '../store/modules/login'

export default {
  fetchStatistics (payload) {
    console.log('PAYLOAD TESTE')
    console.log(payload)
    return home4all.get(`statistics`, {
      params: {
        payload
      }
    }, {
      Cookie: `JSESSIONID=${store.state.sessionID}`
    }).then(response => response.data)
  }
}
