<template>
  <div>
    <div v-if="imgs.length <= numImgPreview">
      <div v-for="img in imgs" :key="img">
        <img v-bind:src="img"/>
      </div>
    </div>
    <div v-if="imgs.length > numImgPreview">
      <b-row>
        <b-col>
          <div v-for="i in numImgPreview" :key="i">
            <img v-bind:src="imgs[i-1]"/>
          </div>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-button @click="showLightbox()" variant="primary">Ver mais</b-button>
        </b-col>
      </b-row>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ImagesPreview',
  props: {
    imgs: {
      required: true,
      type: Array
    },
    numImgPreview: {
      required: false,
      default: 4,
      type: Number
    }
  },
  methods: {
    showLightbox () {
      this.$emit('showLightbox', this.imgs)
    },
    getImgUrl (img) {
      return require('../assets/' + img)
    }
  }
}
</script>

<style scoped>
</style>
