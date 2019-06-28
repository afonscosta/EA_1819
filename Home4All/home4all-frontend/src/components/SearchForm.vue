<template>
  <b-container>
    <b-row align-h="center">
      <b-col class="p-0">
        <b-card class="search-form" bg-variant="light">
          <b-row align-h="center">
            <b-col>
              <p align="left">Localização</p>
            </b-col>
          </b-row>
          <b-row align-h="center">
            <b-col>
              <b-form @submit="search">
                <b-row>
                  <b-col cols="12" sm="8" md="9">
                    <gmap-autocomplete
                      class="form-control"
                      placeholder="Insira uma localização"
                      :componentRestrictions="{ country: ['pt'] }"
                      @place_changed="setPlace">
                    </gmap-autocomplete>
                  </b-col>
                  <b-col cols="12" sm="3" md="3">
                    <b-button type="submit" class="search-button">
                      <font-awesome-icon icon="search" />
                      Pesquisar
                    </b-button>
                  </b-col>
                </b-row>
              </b-form>
            </b-col>
          </b-row>
        </b-card>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  name: 'HomeSearch',
  props: {
    rent: {
      required: true,
      type: Boolean
    },
    sell: {
      required: true,
      type: Boolean
    }
  },
  computed: {
    ...mapState({
      properties: state => state.properties.properties
    })
  },
  data: () => ({
    district: null,
    city: null,
    address: null,
    selectedDistance: null,
    optionsDistance: [
      { value: null, text: 'Selecione uma distância' },
      { value: '20', text: '+20 km' },
      { value: '40', text: '+40 km' },
      { value: '60', text: '+60 km' },
      { value: '80', text: '+80 km' }
    ]
  }),
  methods: {
    ...mapActions('properties', ['doSearch']),
    setPlace (place) {
      var hasStreet = false
      var addrComponents = place.address_components
      if (addrComponents) {
        addrComponents.forEach((comp) => {
          if (comp.types.includes('route')) {
            hasStreet = true
          }
          if (comp.types.includes('locality', 'political')) {
            this.city = comp.long_name
          }
          if (comp.types.includes('administrative_area_level_1', 'political')) {
            this.district = comp.long_name
          }
        })
        if (hasStreet) {
          this.address = place.formatted_address
        }
      }
    },
    search (evt) {
      evt.preventDefault()
      var payload = {
        ...(this.district && { district: this.district }),
        ...(this.city && { city: this.city }),
        ...(this.address && { address: this.address })
      }
      payload.filters = {
        rent: this.rent,
        sell: this.sell,
        page: 0,
        perPage: 5,
        numPages: 4
      }
      if (Object.keys(payload).length !== 0 && payload.constructor === Object) {
        this.doSearch(payload)
          .then(() => {
            this.$router.push({ name: 'search' })
          })
      }
    }
  }
}
</script>

<style scoped>
.search-button {
  background-color: #FF8000 !important;
  border-color: #FF8000 !important;
  margin-bottom: 0.5rem;
  margin-left: 0.5rem;
}

.form-control {
  width: 100% !important;
}

.search-form {
  border-radius: 0px;
  border: 0px;
}

@media (max-width: 576px) {
  .search-button {
    margin-top: 1rem;
    margin-bottom: 0rem;
    margin-left: 0rem;
    width: 100%;
  }
}
</style>
