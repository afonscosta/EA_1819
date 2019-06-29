<template>
  <div>
    <img :src="img"/>
  </div>
</template>
<script>
import { mapActions, mapState } from 'vuex'

export default {
  name: 'LazyImage',
  props: {
    image: {
      require: false,
      type: String
    }
  },
  data: () => ({
    img: null
  }),
  watch: {
    image: {
      immediate: true,
      handler (val, oldVal) {
        if (val.startsWith('data:image/jpg;base64,')) {
          this.img = val
        } else {
          this.getImage(val).then((img) => {
            this.img = img
          })
        }
      }
    }
  },
  computed: {
    ...mapState({
      images: state => state.properties.images
    })
  },
  methods: {
    ...mapActions('properties', [
      'getImage'
    ])
  }
}
</script>

<style scoped>
img {
  left: 10%;
  position: relative;
  float: left;
  width: 200px !important;
  height: 200px !important;
  object-fit: scale-down;
}

@media (max-width: 576px) {
  img {
    width: 100%;
    left: 20%;
    height: auto;
  }
}
</style>
