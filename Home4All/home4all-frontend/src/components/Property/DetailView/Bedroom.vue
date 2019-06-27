<template>
  <div>
    <b-modal
      ref="show-images-modal"
      hide-footer title="Imagens do quarto"
      size="xl"
      scrollable
    >
      <div v-if="images.length > 0" class="images-modal">
        <div v-for="(image, key) in images" :key="key">
          <img v-bind:src="image"/>
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
      <b-card no-body class="bedroom-card" v-for="bedroom in bedrooms" :key="bedroom.id">
        <b-row class="mt-2 mb-2" align-v="center">
          <b-col cols="12" lg="2">
            <b-button class="images-button" variant="primary" @click="showImages(bedroom.images)">Imagens</b-button>
          </b-col>
          <b-col cols="6" lg="1">
            <label><strong>Tipo:</strong> {{ parseType(bedroom.type) }}</label>
          </b-col>
          <b-col cols="12" lg="2" v-if="bedroom.type === 'multiple'">
            <label><strong>Nº de pessoas:</strong> {{ bedroom.peopleAmount }}</label>
          </b-col>
          <b-col cols="6" lg="1">
            <label><strong>Área:</strong> {{ bedroom.area }} m²</label>
          </b-col>
          <b-col cols="12" lg="2">
            <b-row>
              <b-col cols="12">
                <b-form-checkbox
                  id="furnished"
                  v-model="bedroom.furnished"
                  name="checkbox-4"
                  disabled
                >Mobilado</b-form-checkbox>
              </b-col>
              <b-col cols="12">
                <b-form-checkbox
                  id="privateBathroom"
                  v-model="bedroom.privateBathroom"
                  name="checkbox-5"
                  disabled
                >Casa de banho privativa</b-form-checkbox>
              </b-col>
            </b-row>
          </b-col>
          <b-col class="avail" cols="12" lg="2">
            <label><strong>Disponibilidade:</strong> {{ bedroom.availability }}</label>
          </b-col>
          <b-col cols="12" lg="2">
            <label><strong>Mensalidade:</strong> {{ bedroom.rentPrice }} €/mês</label>
          </b-col>
          <b-col cols="12" lg="2">
            <b-button class="images-button"
              variant="primary" @click="addCompare(bedroom)">Comparar</b-button>
          </b-col>
        </b-row>
      </b-card>
    </b-card>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  name: 'Bedroom',
  props: {
    type: {
      type: String
    },
    bedrooms: {
      type: Array
    },
    property: {
      type: Object
    }
  },
  data: () => ({
    images: []
  }),
  computed: {
    ...mapState({
      props_compare: state => state.properties.props_compare
    })
  },
  methods: {
    ...mapActions('properties', [ 'addPropCompare', 'setPropertyEdit' ]),
    showImages (imgs) {
      this.images = imgs
      this.$refs['show-images-modal'].show()
    },
    parseType (type) {
      if (type === 'single') {
        return 'Individual'
      } else if (type === 'double') {
        return 'Casal'
      } else if (type === 'multiple') {
        return 'Múltiplo'
      }
    },
    addCompare (bedroom) {
      console.log('bedroom', this.property)
      var finalBedroom = {}
      finalBedroom.images = bedroom.images
      finalBedroom.type = bedroom.type
      finalBedroom.typology = ''
      finalBedroom.area = bedroom.area
      finalBedroom.furnished = bedroom.furnished
      finalBedroom.availability = bedroom.availability
      finalBedroom.rentPrice = bedroom.rentPrice
      finalBedroom.expensesIncluded = this.property.expensesIncluded
      finalBedroom.owner = this.property.owner
      finalBedroom.address = this.property.address
      finalBedroom.lat = this.property.lat
      finalBedroom.lng = this.property.lng
      finalBedroom.id = this.property.id
      finalBedroom.name = this.property.name
      this.addPropCompare(finalBedroom)
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

.images-button {
  margin-bottom: 1rem;
  width: 90%;
}

.bedroom-card {
  border: 3px solid rgba(0, 0, 0, 0.125) !important;
  margin-top: 1rem;
  margin-bottom: 1rem;
  margin-left: 1.5rem;
  margin-right: 1rem;
}

@media (max-width: 576px) {
  .avail {
    margin-top: 1rem;
  }
}
</style>
