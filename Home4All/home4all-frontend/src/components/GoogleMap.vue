<template>
  <div>
    <gmap-map
      :center="center"
      :zoom="12"
      style="width:100%;  height: 400px;"
    >
      <gmap-marker
        :key="index"
        v-for="(m, index) in markers"
        :position="m.position"
        @click="center=m.position"
      ></gmap-marker>
    </gmap-map>
  </div>
</template>

<script>
export default {
  name: 'GoogleMap',
  props: {
    marker: {
      type: Object
    }
  },
  computed: {
    markers () {
      if (this.marker) {
        return [{ position: this.marker }]
      } else {
        return []
      }
    },
    center () {
      if (this.marker) {
        return this.marker
      } else {
        return { lat: 45.508, lng: -73.587 }
      }
    }
  }
}
</script>
