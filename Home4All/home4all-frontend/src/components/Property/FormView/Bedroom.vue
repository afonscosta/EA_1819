<template>
  <div>
    <b-modal
      ref="show-images-modal"
      hide-footer title="Imagens do quarto"
      size="xl"
    >
      <div v-if="showImagesIdx !== null" class="images-modal">
        <div v-for="(file, key) in files" :key="key">
          <img class="preview" v-bind:ref="'image'+parseInt( key )"/>
        </div>
      </div>
    </b-modal>

    <b-card
      v-if="type === 'bedrooms'"
      border-variant="secondary"
      header="Quartos disponíveis"
      header-border-variant="secondary"
    >
      <b-card v-if="bedrooms.length > 0">
        <b-row
          align-v="end"
          v-for="(b, idx) in bedrooms"
          :key="idx"
        >
          <b-col>
            <b-button variant="primary" @click="showImages(idx)">Imagens</b-button>
          </b-col>
          <b-col>
            <label>Tipo: {{ b.type }}</label>
          </b-col>
          <b-col v-if="b.type === 'multiple'">
            <label>Nº de pessoas: {{ b.peopleAmount }}</label>
          </b-col>
          <b-col>
            <label>Área: {{ b.area }}</label>
          </b-col>
          <b-col cols="3">
            <b-row>
              <b-col cols="12">
                <b-form-checkbox
                  id="furnishedView"
                  v-model="b.furnished"
                  name="checkbox-6"
                  disabled
                >Mobilado</b-form-checkbox>
              </b-col>
              <b-col cols="12">
                <b-form-checkbox
                  id="privateBathroomView"
                  v-model="b.privateBathroom"
                  name="checkbox-7"
                  disabled
                >Casa de banho privativa</b-form-checkbox>
              </b-col>
            </b-row>
          </b-col>
          <b-col>
            <label>Disponibilidade:</label>
            <label>{{ b.availability }}</label>
          </b-col>
          <b-col>
            <label>Mensalidade: {{ b.rentPrice }} €</label>
          </b-col>
          <b-col>
            <b-button @click="$emit('deleteBedroom', idx)" variant="danger">Eliminar</b-button>
          </b-col>
        </b-row>
      </b-card>

      <b-button v-if="hidden && bedrooms.length !== 0" variant="primary" @click="hidden = false">Mais</b-button>
      <b-form-group
        v-if="!hidden || bedrooms.length === 0"
        id="bedrooms-form-group"
      >
        <b-row align-v="end">
          <b-col>
            <LoadImages class="load-images-bedroom" @updateImages="updateBedroomImages"/>
          </b-col>
        </b-row>
        <b-row align-v="end">
          <b-col>
            <b-form-group id="type" label="Tipo:" label-for="input-11">
              <b-form-select
                v-model="bedroom.type"
                :options="optionsType"
                @change="updateBedroomType"
              ></b-form-select>
            </b-form-group>
          </b-col>
          <b-col v-if="bedroom.type === 'multiple'">
            <b-form-group id="type" label="Nº de pessoas:" label-for="input-11">
              <b-input
                v-model="bedroom.peopleAmount"
                type="number"
                width="auto"
                @change="updateBedroomPeopleAmount"
              ></b-input>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group id="area" label="Área:" label-for="input-11">
              <b-input
                v-model="bedroom.area"
                type="number"
                width="auto"
                @change="updateBedroomArea"
              ></b-input>
            </b-form-group>
          </b-col>
          <b-col cols="3">
            <b-row>
              <b-col cols="12">
                <b-form-checkbox
                  id="furnished"
                  v-model="bedroom.furnished"
                  name="checkbox-4"
                  @change="updateBedroomFurnished"
                >Mobilado</b-form-checkbox>
              </b-col>
              <b-col cols="12">
                <b-form-checkbox
                  id="privateBathroom"
                  v-model="bedroom.privateBathroom"
                  name="checkbox-5"
                  @change="updateBedroomPrivateBathroom"
                >Casa de banho privativa</b-form-checkbox>
              </b-col>
            </b-row>
          </b-col>
          <b-col>
            <b-form-group id="availability" label="Disponibilidade:" label-for="input-11">
              <b-input
                v-model="bedroom.availability"
                type="date"
                @change="updateBedroomAvailability"
              ></b-input>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group id="rentPrice" label="Mensalidade:" label-for="input-11">
              <b-input
                v-model="bedroom.rentPrice"
                type="number"
                @change="updateBedroomRentPrice"
              ></b-input>
            </b-form-group>
          </b-col>
        </b-row>
        <b-row align-h="center">
          <b-col align-self="center">
            <b-button @click="addBedroom">Adicionar</b-button>
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
  </div>
</template>

<script>
import LoadImages from '@/components/Property/FormView/LoadImages'

export default {
  name: 'Bedroom',
  components: {
    LoadImages
  },
  props: {
    type: {
      required: true,
      type: String
    },
    bedrooms: {
      required: false,
      type: Array
    }
  },
  data: () => ({
    hidden: false,
    showImagesIdx: null,
    files: [],
    bedroom: {
      type: null,
      area: 0,
      furnished: false,
      privateBathroom: false,
      availability: '',
      rentPrice: 0,
      images: [],
      peopleAmount: 0
    },
    optionsType: [
      { value: null, text: 'Selecione um tipo de quarto' },
      { value: 'single', text: 'Individual' },
      { value: 'double', text: 'Duplo' },
      { value: 'multiple', text: 'Múltiplo' }
    ]
  }),
  methods: {
    showImages (idx) {
      this.showImagesIdx = idx
      this.getImagePreviews()
      this.$refs['show-images-modal'].show()
    },
    updateBedroomType (checked) {
      this.$emit('updateBedroomType', checked)
    },
    updateBedroomPeopleAmount (checked) {
      this.$emit('updateBedroomPeopleAmount', checked)
    },
    updateBedroomArea (value) {
      this.$emit('updateBedroomArea', value)
    },
    updateBedroomFurnished (value) {
      this.$emit('updateBedroomFurnished', value)
    },
    updateBedroomPrivateBathroom (value) {
      this.$emit('updateBedroomPrivateBathroom', value)
    },
    updateBedroomAvailability (value) {
      this.$emit('updateBedroomAvailability', value)
    },
    updateBedroomRentPrice (value) {
      this.$emit('updateBedroomRentPrice', value)
    },
    updateBedroomImages (value) {
      this.$emit('updateBedroomImages', value)
    },
    addBedroom () {
      this.hidden = true
      this.$emit('addBedroom')
    },
    getImagePreviews () {
      this.files = this.bedrooms[this.showImagesIdx].images
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
#bedrooms-form-group {
  margin: 0px !important;
}

#type,
#area,
#furnished,
#privateBathroom,
#availability,
#rentPrice {
  margin: 0px !important;
}

.load-images-bedroom img {
  width:50px !important;
  height:50px !important;
}

.images-modal img {
  width:250px !important;
  height:250px !important;
}
</style>
