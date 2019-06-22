<template>
  <b-container>
    <b-row align-h="center">
      <b-col>
        <b-card bg-variant="light">
          <b-row align-h="center">
            <b-col>
              <p align="left">Localização</p>
            </b-col>
          </b-row>
          <b-row align-h="center">
            <b-col align="left">
              <label class="mb-2 mr-2">
                <gmap-autocomplete
                  class="form-control"
                  placeholder="Insira uma localização"
                  :componentRestrictions="{ country: ['pt'] }"
                  @place_changed="setPlace">
                </gmap-autocomplete>
              </label>
            </b-col>
          </b-row>
          <b-row align-h="center">
            <b-col>
              <b-card>
                <b-row align-h="center">
                  <b-col>
                    <p align="left">Filtros</p>
                  </b-col>
                </b-row>
                <b-row align-h="center">
                  <b-col>
                    <b-dropdown id="dropdown-form" variant="light" text="Imóvel" ref="dropdown">
                      <b-col>
                        <b-form-checkbox v-model="filters.bedrooms" class="mb-3">Quarto</b-form-checkbox>
                        <b-form-checkbox v-model="filters.apartment" class="mb-3">Apartamento</b-form-checkbox>
                        <b-form-checkbox v-model="filters.villa" class="mb-3">Vivenda</b-form-checkbox>
                      </b-col>
                    </b-dropdown>
                  </b-col>
                  <b-col>
                    <b-dropdown id="dropdown-form" variant="light" text="Tipologia" ref="dropdown">
                      <b-row>
                        <b-col>
                          <b-form-checkbox v-model="filters.T0" class="mb-3">T0</b-form-checkbox>
                          <b-form-checkbox v-model="filters.T1" class="mb-3">T1</b-form-checkbox>
                          <b-form-checkbox v-model="filters.T2" class="mb-3">T2</b-form-checkbox>
                          <b-form-checkbox v-model="filters.T3" class="mb-3">T3</b-form-checkbox>
                          <b-form-checkbox v-model="filters.T4" class="mb-3">T4</b-form-checkbox>
                          <b-form-checkbox v-model="filters.T5" class="mb-3">T5</b-form-checkbox>
                        </b-col>
                        <b-col>
                          <b-form-checkbox v-model="filters.T6" class="mb-3">T6</b-form-checkbox>
                          <b-form-checkbox v-model="filters.T7" class="mb-3">T7</b-form-checkbox>
                          <b-form-checkbox v-model="filters.T8" class="mb-3">T8</b-form-checkbox>
                          <b-form-checkbox v-model="filters.T9" class="mb-3">T9</b-form-checkbox>
                          <b-form-checkbox v-model="filters.T10" class="mb-3">T10</b-form-checkbox>
                          <b-form-checkbox v-model="filters.T10P" class="mb-3">T10+</b-form-checkbox>
                        </b-col>
                      </b-row>
                    </b-dropdown>
                  </b-col>
                  <b-col>
                    <b-dropdown id="dropdown-form" variant="light" text="Operação" ref="dropdown">
                      <b-col>
                        <b-form-checkbox v-model="filters.rent" class="mb-3">Arrendar</b-form-checkbox>
                        <b-form-checkbox v-model="filters.sell" class="mb-3">Comprar</b-form-checkbox>
                      </b-col>
                    </b-dropdown>
                  </b-col>
                  <b-col>
                    <b-dropdown id="dropdown-form" variant="light" text="Preço" ref="dropdown">
                      <b-col>
                        <vue-slider v-model="filters.priceRange"></vue-slider>
                      </b-col>
                    </b-dropdown>
                  </b-col>
                  <b-col>
                    <b-dropdown id="dropdown-form" variant="light" text="Ordenação" ref="dropdown">
                      <b-col>
                        <p>Preço</p>
                        <b-form-checkbox
                          v-model="filters.priceLowestFirst"
                          class="mb-3">mais baixo - mais caro</b-form-checkbox>
                        <b-form-checkbox
                          v-model="filters.priceHighestFirst"
                          class="mb-3">mais caro - mais baixo</b-form-checkbox>
                        <b-dropdown-divider></b-dropdown-divider>
                        <p>Data publicação</p>
                        <b-form-checkbox
                          v-model="filters.publicationDateNewestFirst"
                          class="mb-3">mais recente - mais antiga</b-form-checkbox>
                        <b-form-checkbox
                          v-model="filters.publicationDateOldestFirst"
                          class="mb-3">mais antiga - mais recente</b-form-checkbox>
                        <b-dropdown-divider></b-dropdown-divider>
                        <p>Login do anunciante</p>
                        <b-form-checkbox
                          v-model="filters.advertiserLoginNewestFirst"
                          class="mb-3">mais recente - mais antigo</b-form-checkbox>
                        <b-form-checkbox
                          v-model="filters.advertiserLoginOldestFirst"
                          class="mb-3">mais antigo - mais recente</b-form-checkbox>
                      </b-col>
                    </b-dropdown>
                  </b-col>
                </b-row>
              </b-card>
            </b-col>
          </b-row>
          <b-row align-h="center">
            <b-col>
              <b-button @click="search" class="search-button">Pesquisar</b-button>
            </b-col>
          </b-row>
        </b-card>
      </b-col>
    </b-row>
    <b-row align-h="center">
      <p>Resultados da pesquisa</p>
    </b-row>
  </b-container>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'search',
  data: () => ({
    district: null,
    city: null,
    address: null,
    filters: {
      bedrooms: false,
      apartment: false,
      villa: false,
      T0: false,
      T1: false,
      T2: false,
      T3: false,
      T4: false,
      T5: false,
      T6: false,
      T7: false,
      T8: false,
      T9: false,
      T10: false,
      T10P: false,
      rent: false,
      sell: false,
      priceRange: [0, 50],
      priceLowestFirst: false,
      priceHighestFirst: false,
      publicationDateNewestFirst: false,
      publicationDateOldestFirst: false,
      advertiserLoginNewestFirst: false,
      advertiserLoginOldestFirst: false
    }
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
      var filters = {}

      var types = []
      if (this.filters.bedrooms) { types.push('bedrooms') }
      if (this.filters.apartment) { types.push('apartment') }
      if (this.filters.villa) { types.push('villa') }
      filters.types = types

      var typologies = []
      if (this.filters.T0) { typologies.push('T0') }
      if (this.filters.T1) { typologies.push('T1') }
      if (this.filters.T2) { typologies.push('T2') }
      if (this.filters.T3) { typologies.push('T3') }
      if (this.filters.T4) { typologies.push('T4') }
      if (this.filters.T5) { typologies.push('T5') }
      if (this.filters.T6) { typologies.push('T6') }
      if (this.filters.T7) { typologies.push('T7') }
      if (this.filters.T8) { typologies.push('T8') }
      if (this.filters.T9) { typologies.push('T9') }
      if (this.filters.T10) { typologies.push('T10') }
      if (this.filters.T10P) { typologies.push('T10+') }
      if (typologies.length > 0) {
        filters.typologies = typologies
      }

      filters.rent = this.filters.rent
      filters.sell = this.filters.sell

      if (this.filters.rent) {
        filters.minRentPrice = this.filters.priceRange[0]
        filters.maxRentPrice = this.filters.priceRange[1]
      }
      if (this.filters.sell) {
        filters.minSellPrice = this.filters.priceRange[0]
        filters.maxSellPrice = this.filters.priceRange[1]
      }

      var ordination = null
      if (this.filters.priceLowestFirst) {
        ordination = 'Price: lowest first'
      }
      if (this.filters.priceHighestFirst) {
        ordination = 'Price: highest first'
      }
      if (this.filters.publicationDateNewestFirst) {
        ordination = 'Publication Date: newest first'
      }
      if (this.filters.publicationDateOldestFirst) {
        ordination = 'Publication Date: oldest first'
      }
      if (this.filters.advertiserLoginNewestFirst) {
        ordination = 'Advertiser Login: newest first'
      }
      if (this.filters.advertiserLoginOldestFirst) {
        ordination = 'Advertiser Login: oldest first'
      }
      if (ordination) {
        filters.ordination = ordination
      }

      payload.filters = filters

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
