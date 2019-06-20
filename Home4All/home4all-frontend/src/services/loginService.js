import home4all from '@/services/home4all'

export default {
  login (payload) {
    return home4all.post(`login`, {
      email: payload.email,
      password: payload.password
    }).then(response => response.data)
  }
}
