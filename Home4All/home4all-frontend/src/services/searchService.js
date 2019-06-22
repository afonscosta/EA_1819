import home4all from '@/services/home4all'

export default {
  fetchProperties (payload) {
    return home4all.get(`search/`, {
      params: {
        payload
      }
    }).then(response => response.data)
  }
}
