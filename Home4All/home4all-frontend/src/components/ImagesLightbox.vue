<template>
  <div>
    <VueEasyLightbox
      :visible="visible"
      :imgs="images"
      :index="index"
      @hide="handleHide"
    ></VueEasyLightbox>

    <!-- Component name: 'vue-easy-lightbox' -->
    <!--
      <vue-easy-lightbox
        :visible="visible"
        :imgs="imgs"
        :index="index"
        @hide="handleHide"
      ></vue-easy-lightbox>
     -->
  </div>
</template>

<script>
import VueEasyLightbox from 'vue-easy-lightbox'

export default {
  components: {
    VueEasyLightbox
  },
  props: {
    imgs: {
      required: true,
      type: Array
    }
  },
  data: () => ({
    visible: true,
    index: 0 // default
  }),
  computed: {
    images () {
      return this.imgs.map((i) => {
        return btoa(i)
      })
    }
  },
  methods: {
    handleHide () {
      this.visible = false
      this.$emit('lightboxHidden')
    }
  }
}
</script>

<style scope>
.img-wrapper img {
  height: auto;
  width: auto;
}
</style>
