<template>
  <b-container>
    <b-row>
      <b-col>
        <gmap-map
          :center="center"
          :zoom="12"
          :style="'width:100%; height: ' + height + 'px;'"
          :options="{ disableDefaultUI: disableUI, draggable: drag }"
        >
          <gmap-marker
            :key="index"
            v-for="(m, index) in markers"
            :position="m.position"
            @click="center=m.position"
          ></gmap-marker>
        </gmap-map>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  name: 'GoogleMap',
  props: {
    marker: {
      type: Object
    },
    disableUI: {
      default: false,
      type: Boolean
    },
    drag: {
      default: true,
      type: Boolean
    },
    height: {
      default: 400,
      type: Number
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
