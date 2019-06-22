<template>
  <b-card>
    <b-row align-v="start">
      <b-col class="images-col">
        <div v-for="(image, key) in images" :key="key">
          <img @click="removeFile(key)" v-bind:src="image"/>
        </div>
      </b-col>
    </b-row>
    <b-row class="mt-4">
      <b-col>
        <b-form-file
          multiple
          v-model="filesUpload"
          :state="Boolean(files)"
          @input="getImagePreviews"
        ></b-form-file>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
export default {
  name: 'LoadImages',
  props: {
    images: {
      required: false,
      type: Array
    }
  },
  data: () => ({
    filesUpload: [],
    files: []
  }),
  created () {
    if (this.filesData) {
      this.files = this.filesData
    }
  },
  methods: {
    removeFile (idx) {
      this.$emit('removeImage', idx)
      this.filesUpload.splice(idx, 1)
    },
    getImagePreviews () {
      var files = []
      if (this.filesUpload.length > 0) {
        files.push(...this.filesUpload)
        this.filesUpload = []
      }
      for (let i = 0; i < files.length; i++) {
        if (/\.(jpe?g|png|gif)$/i.test(files[i].name)) {
          let reader = new FileReader()
          reader.onload = function (e) {
            this.$emit('addImage', e.target.result)
          }.bind(this)
          reader.onerror = function (error) {
            alert(error)
          }
          reader.readAsDataURL(files[i])
        }
      }
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
