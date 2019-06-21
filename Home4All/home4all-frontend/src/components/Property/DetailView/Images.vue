<template>
  <b-card>
    <b-row align-v="start">
      <b-col class="images-col">
        <div v-for="(image, key) in images" :key="key">
          <img v-bind:src="'data:image/jpeg;base64,'+image"/>
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

<style scope>
img {
  position: relative;
  float: left;
  width:100px;
  height:100px;
  object-fit:scale-down;
}

.images-col {
  max-height: 560px;
  overflow-y: scroll;
}
</style>
