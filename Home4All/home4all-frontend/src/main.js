import Vue from 'vue'
import App from '@/App.vue'
import router from '@/router'
import store from '@/store'

// Bootstrap
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

// Vue-google-maps
import * as VueGoogleMaps from 'vue2-google-maps'

// VueLightBox
import Lightbox from 'vue-easy-lightbox'

// Slider
import VueSlider from 'vue-slider-component'
import 'vue-slider-component/theme/default.css'

// FontAwesome
import { library } from '@fortawesome/fontawesome-svg-core'
import { faSearch, faPlus, faMinus, faTrashAlt } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

library.add(faSearch)
library.add(faPlus)
library.add(faMinus)
library.add(faTrashAlt)

Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.component('VueSlider', VueSlider)
Vue.use(BootstrapVue)
Vue.use(Lightbox)
Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyDtZzBGMqTFWjndSRR-kEzpwBMdHodA5Ac',
    language: 'pt-PT',
    libraries: 'places' // necessary for places input
  }
})

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
