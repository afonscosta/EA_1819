<template>
  <div>
    <b-modal
      ref="show-images-modal"
      hide-footer title="Imagens do quarto"
      size="xl"
      scrollable
    >
      <div v-if="showImagesIdx !== null" class="images-modal">
        <div v-for="(image, key) in bedrooms[showImagesIdx].images" :key="key">
          <img class="preview" v-bind:src="image"/>
        </div>
      </div>
    </b-modal>

    <b-card
      v-if="type === 'bedrooms'"
      border-variant="secondary"
      header="Quartos disponíveis"
      header-border-variant="secondary"
      no-body
    >
      <b-card class="bedroom-card" v-for="(b, idx) in bedrooms" :key="idx">
        <b-row align-v="center">
          <b-col cols="12" align="center" lg="2">
            <b-button class="image-button middle-button" variant="primary" @click="showImages(idx)">Imagens</b-button>
          </b-col>
          <b-col cols="12" lg="2">
            <label><strong>Tipo:</strong> {{ parseType(b.type) }}</label>
          </b-col>
          <b-col cols="12" lg="2" v-if="b.type === 'multiple'">
            <label><strong>Nº de pessoas:</strong> {{ b.peopleAmount }}</label>
          </b-col>
          <b-col cols="12" lg="1">
            <label><strong>Área:</strong> {{ b.area }} m²</label>
          </b-col>
          <b-col cols="12" lg="2">
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
          <b-col cols="12" lg="2">
            <label><strong>Disponibilidade:</strong></label>
            <label>{{ b.availability }}</label>
          </b-col>
          <b-col cols="12" lg="2">
            <label><strong>Mensalidade:</strong>  {{ b.rentPrice }} €/mês</label>
          </b-col>
          <b-col cols="12" lg="1" align="center">
            <b-button class="middle-button" @click="$emit('deleteBedroom', idx)" variant="danger">
              <font-awesome-icon icon="trash-alt" />
            </b-button>
          </b-col>
        </b-row>
      </b-card>

      <b-row>
        <b-col align="right">
          <b-button class="plus-button" v-if="hidden && bedrooms.length !== 0" variant="primary" @click="hidden = false">
            <font-awesome-icon icon="plus" />
          </b-button>
        </b-col>
      </b-row>

      <div class="form-bedroom">
        <b-form-group
          v-if="!hidden || bedrooms.length === 0"
          id="bedrooms-form-group"
        >
          <b-row align-v="end">
            <b-col>
              <LoadImages class="load-images-bedroom"
                :images="bedroom.images"
                @addImage="addBedroomImage"
                @removeImage="removeBedroomImage"
                @updateImages="updateBedroomImages"/>
            </b-col>
          </b-row>
          <b-row class="mt-3 mb-3" align-v="end">
            <b-col cols="12" lg="3">
              <b-form-group id="type" label="Tipo:" label-for="input-11">
                <b-form-select
                  v-model="bedroom.type"
                  :options="optionsType"
                  @change="updateBedroomType"
                ></b-form-select>
              </b-form-group>
            </b-col>
            <b-col cols="12" lg="2" v-if="bedroom.type === 'multiple'">
              <b-form-group id="type" label="Nº de pessoas:" label-for="input-11">
                <b-input
                  v-model.number="bedroom.peopleAmount"
                  type="number"
                  width="auto"
                  @change="updateBedroomPeopleAmount"
                ></b-input>
              </b-form-group>
            </b-col>
            <b-col cols="12" lg="2">
              <b-form-group id="area" label="Área:" label-for="input-11">
                <b-input
                  v-model.number="bedroom.area"
                  type="number"
                  width="auto"
                  @change="updateBedroomArea"
                ></b-input>
              </b-form-group>
            </b-col>
            <b-col cols="12" lg="2">
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
            <b-col cols="12" lg="3">
              <b-form-group id="availability" label="Disponibilidade:" label-for="input-11">
                <b-input
                  v-model="bedroom.availability"
                  type="date"
                  @change="updateBedroomAvailability"
                ></b-input>
              </b-form-group>
            </b-col>
            <b-col cols="12" lg="2">
              <b-form-group id="rentPrice" label="Mensalidade (€/mês):" label-for="input-11">
                <b-input
                  v-model.number="bedroom.rentPrice"
                  type="number"
                  @change="updateBedroomRentPrice"
                ></b-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row align-h="center">
            <b-col align="right">
              <b-button variant="primary" @click="addBedroom">Adicionar</b-button>
            </b-col>
          </b-row>
        </b-form-group>
      </div>
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
      area: '0',
      furnished: false,
      privateBathroom: false,
      availability: '',
      rentPrice: '0',
      images: [],
      peopleAmount: '0'
    },
    optionsType: [
      { value: null, text: 'Selecione um tipo de quarto' },
      { value: 'single', text: 'Individual' },
      { value: 'double', text: 'Duplo' },
      { value: 'multiple', text: 'Múltiplo' }
    ]
  }),
  created () {
    if (this.bedrooms.length > 0) {
      this.hidden = true
    }
  },
  methods: {
    showImages (idx) {
      this.showImagesIdx = idx
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
      this.bedroom.images = value
      this.$emit('updateBedroomImages', value)
    },
    addBedroomImage (value) {
      this.bedroom.images.push(value)
      this.$emit('addBedroomImage', value)
    },
    removeBedroomImage (value) {
      this.bedroom.images.splice(value, 1)
      this.$emit('removeBedroomImage', value)
    },
    addBedroom () {
      this.hidden = true
      this.$emit('addBedroom')
      this.bedroom = {
        type: null,
        area: 0,
        furnished: false,
        privateBathroom: false,
        availability: '',
        rentPrice: 0,
        images: [],
        peopleAmount: 0
      }
    },
    parseType (type) {
      if (type === 'single') {
        return 'Individual'
      } else if (type === 'double') {
        return 'Casal'
      } else if (type === 'multiple') {
        return 'Múltiplo'
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

.image-button {
  margin-bottom: 1rem;
}

.middle-button {
  width: 90%;
}

.card-list-bedroom {
  margin-bottom: 1rem;
}

.bedroom-card {
  border: 3px solid rgba(0, 0, 0, 0.125) !important;
  margin-top: 1rem;
  margin-bottom: 1rem;
  margin-left: 1.5rem;
  margin-right: 1rem;
}

.plus-button {
  width: 40px;
  margin-bottom: 1rem;
  margin-right: 1rem;
}

.form-bedroom {
  margin: 1rem;
}
</style>
