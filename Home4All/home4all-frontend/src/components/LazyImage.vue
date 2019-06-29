<template>
    <div>
        <b-img :src="images.image"></b-img>
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
  computed: {
    ...mapState({
      images: state => state.properties.images
    })
  },
  mounted () {
    this.getImage(this.image).then((image) => { this.img = image })
  },
  methods: {
    ...mapActions('properties', [
      'getImage'
    ])
  }
}
</script>
