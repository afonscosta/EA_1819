<template>
  <b-card>
    <b-row align-v="start">
      <b-col class="images-col">
        <div v-for="(file, key) in files" :key="key">
          <img @click="removeFile(key)" class="preview" v-bind:ref="'image'+parseInt( key )"/>
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
    filesData: {
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
      this.files = this.files.filter(function (f, index) {
        if (index === idx) {
          return false
        }
        return true
      })
      this.getImagePreviews()
    },

    /*
      Submits files to the server
    */
    submitFiles () {
      /*
        Initialize the form data
      */
      let formData = new FormData()

      /*
        Iteate over any file sent over appending the files
        to the form data.
      */
      for (var i = 0; i < this.files.length; i++) {
        let file = this.files[i]

        formData.append('files[' + i + ']', file)
      }

      /*
        Make the request to the POST /select-files URL
      */
      /*
      axios.post( '/file-multiple-preview',
        formData,
        {
          headers: {
              'Content-Type': 'multipart/form-data'
          }
        }
      ).then(function(){
        console.log('SUCCESS!!');
      })
      .catch(function(){
        console.log('FAILURE!!');
      });
      */
    },

    /*
      Gets the preview image for the file.
    */
    getImagePreviews () {
      if (this.filesUpload.length > 0) {
        this.files.push(...this.filesUpload)
        this.filesUpload = []
      }
      this.$emit('updateImages', this.files)
      /*
        Iterate over all of the files and generate an image preview for each one.
      */
      for (let i = 0; i < this.files.length; i++) {
        /*
          Ensure the file is an image file
        */
        if (/\.(jpe?g|png|gif)$/i.test(this.files[i].name)) {
          /*
            Create a new FileReader object
          */
          let reader = new FileReader()

          /*
            Add an event listener for when the file has been loaded
            to update the src on the file preview.
          */
          reader.addEventListener('load', function () {
            this.$refs['image' + parseInt(i)][0].src = reader.result
          }.bind(this), false)

          /*
            Read the data for the file in through the reader. When it has
            been loaded, we listen to the event propagated and set the image
            src to what was loaded from the reader.
          */
          reader.readAsDataURL(this.files[i])
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
