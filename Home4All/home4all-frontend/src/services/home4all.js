import axios from 'axios'
import Cookies from 'js-cookie'

export default axios.create({
  withCredentials: true,
  baseURL: '/Home4All',
  timeout: 7000,
  headers: {
    'Content-Type': 'multipart/form-data',
    'X-CSRFToken': Cookies.get('csrftoken'),
    'Access-Control-Allow-Origin': '*'
  }
})
