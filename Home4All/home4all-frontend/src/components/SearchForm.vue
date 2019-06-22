<template>
  <b-container class="mt-3">
    <b-row align-h="center">
      <b-col>
        <b-card bg-variant="light">
          <b-row align-h="center">
            <b-col>
              <p align="left">Localização</p>
            </b-col>
          </b-row>
          <b-row align-h="center">
            <b-col>
              <b-form inline @submit="search">
                <label class="mb-2 mr-2">
                  <gmap-autocomplete
                    class="form-control"
                    placeholder="Insira uma localização"
                    :componentRestrictions="{ country: ['pt'] }"
                    @place_changed="setPlace">
                  </gmap-autocomplete>
                </label>

                <b-form-select
                  v-model="selectedDistance"
                  :options="optionsDistance"
                  class="mb-2 mr-2 ml-2"
                ></b-form-select>

                <b-button type="submit" class="search-button">Pesquisar</b-button>
              </b-form>
            </b-col>
          </b-row>
        </b-card>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'HomeSearch',
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
    ...mapActions('search', ['doSearch']),
    setPlace (place) {
      var addrComponents = place.address_components
      if (addrComponents) {
        addrComponents.forEach((comp) => {
          if (comp.types.includes('locality', 'political')) {
            this.city = comp.long_name
          }
          if (comp.types.includes('administrative_area_level_1', 'political')) {
            this.district = comp.long_name
          }
        })
        this.address = place.formatted_address
      }
    },
    search (evt) {
      evt.preventDefault()
      var payload = {
        ...(this.district && { district: this.district }),
        ...(this.city && { city: this.city }),
        ...(this.address && { address: this.address })
      }
      if (Object.keys(payload).length !== 0 && payload.constructor === Object) {
        this.doSearch(payload)
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
</style>
