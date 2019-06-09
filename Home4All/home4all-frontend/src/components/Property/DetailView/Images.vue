<template>
  <b-card>
    <b-row align-v="start">
      <b-col class="images-col">
        <div v-for="(file, key) in files" :key="key">
          <img class="preview" v-bind:ref="'image'+parseInt( key )"/>
        </div>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
export default {
  name: 'Images',
  props: {
    files: {
      required: true,
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
