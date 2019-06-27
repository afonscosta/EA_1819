<template>
  <b-card>
    <b-row align-v="start">
      <b-col class="images-col">
        <div v-for="(image, key) in images" :key="key">
          <img v-bind:src="image"/>
        </div>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
export default {
  name: 'Images',
  props: {
    images: {
      type: Array
    }
  }
}
</script>

<style scoped>
img {
  position: relative;
  float: left;
  width: 200px;
  height: 200px;
  object-fit:scale-down;
}

@media (max-width: 576px) {
  img {
    position: relative;
    float: left;
    width: 100%;
    height: auto;
    object-fit:scale-down;
  }
}

.images-col {
  max-height: 400px;
  overflow-y: auto;
}
</style>
