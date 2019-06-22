<template>
  <b-container>
    <b-row class="justify-content-md-center">
      <b-form inline>
        <label class="input-location">
          Rua:
          <gmap-autocomplete
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

        <b-button @click="search" class="mb-2 ml-2" variant="primary">Pesquisar</b-button>
      </b-form>
    </b-row>
  </b-container>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'HomeSearch',
  data: () => ({
    district: '',
    city: '',
    address: '',
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
    search () {
      var payload = {
        district: this.district,
        city: this.city,
        address: this.address
      }
      this.doSearch(payload)
    }
  }
}
</script>
