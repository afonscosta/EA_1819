<template>
  <b-card
    border-variant="secondary"
    header="Informação Geral"
    header-border-variant="secondary"
  >
    <b-form-group id="input-group-2" label="Descrição:" label-for="input-2">
      <b-form-textarea
        id="input-2"
        v-model="description"
        placeholder="Insira uma descrição"
        rows="1"
        max-rows="6"
        @change="updateDescription"
      ></b-form-textarea>
    </b-form-group>

    <b-row>
      <b-col>
        <b-form-group
          id="input-group-3"
          label="Imóvel:"
          label-for="input-3"
        >
          <b-form-select
            :disabled="disableType"
            v-model="type"
            :options="optionsType"
            @change="updateType"
          ></b-form-select>
        </b-form-group>
      </b-col>
      <b-col>
        <b-form-group
          id="input-group-4"
          label="Tipologia:"
          label-for="input-4"
        >
          <b-form-select
            v-model="typology"
            :options="optionsTypology"
            @change="updateTypology"
          ></b-form-select>
        </b-form-group>
      </b-col>
      <b-col>
        <b-form-group id="input-group-5" label="Área:" label-for="input-5">
          <b-form-input
            id="input-5"
            v-model.number="area"
            type="number"
            placeholder="Insira a área"
            @change="updateArea"
          ></b-form-input>
        </b-form-group>
      </b-col>
    </b-row>

    <label v-if="showCurrentLocation">Localização atual: {{ address }}</label>
    <label class="input-location mb-1">Localização:</label>
    <gmap-autocomplete
      class="form-control mb-3"
      placeholder="Insira uma localização"
      :componentRestrictions="{ country: ['pt'] }"
      @place_changed="setPlace">
    </gmap-autocomplete>

    <b-row class="mb-1">
      <b-col>
        <b-form-checkbox
          id="checkbox-1"
          v-model="furnished"
          name="checkbox-1"
          @change="updateFurnished"
          class="pb-2"
        >Mobilado</b-form-checkbox>
      </b-col>
      <b-col v-if="type === 'bedrooms'">
        <b-form-checkbox
          id="totalAccess"
          v-model="totalAccess"
          name="totalAccess"
          @change="updateTotalAccess"
          class="pb-2"
        >Acesso total</b-form-checkbox>
      </b-col>
      <b-col v-if="type !== 'bedrooms'">
        <b-form-checkbox
          id="checkbox-rent"
          v-model="rent"
          name="checkbox-rent"
          @change="updateRent"
        >
          Arrendar
        </b-form-checkbox>
      </b-col>
      <b-col v-if="type !== 'bedrooms'">
        <b-form-checkbox
          id="checkbox-sell"
          v-model="sell"
          name="checkbox-sell"
          @change="updateSell"
        >
          Vender
        </b-form-checkbox>
      </b-col>
    </b-row>

    <b-row>
      <b-col>
        <b-form-group id="input-group-11"
          v-if="type !== 'bedrooms'"
          label="Disponível a partir de:"
          label-for="input-11"
        >
          <b-input
            v-model="availability"
            type="date"
            @change="updateAvailability"
          ></b-input>
        </b-form-group>
      </b-col>
    </b-row>

    <b-row>
      <b-col v-if="type !== 'bedrooms' && rent">
        <b-form-group
          id="input-group-13"
          label="Mensalidade:"
          label-for="input-13"
        >
          <b-input
            v-model.number="rentPrice"
            type="number"
            @change="updateRentPrice"
          ></b-input>
        </b-form-group>
      </b-col>
      <b-col v-if="type !== 'bedrooms' && sell">
        <b-form-group
          id="input-group-14"
          label="Preço total:"
          label-for="input-14"
        >
          <b-input
            v-model.number="sellPrice"
            type="number"
            @change="updateSellPrice"
          ></b-input>
        </b-form-group>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
export default {
  name: 'PropertyInfo',
  props: {
    disableType: {
      required: true,
      type: Boolean
    },
    showCurrentLocation: {
      required: true,
      type: Boolean
    },
    descriptionData: {
      required: false,
      type: String
    },
    typeData: {
      required: false,
      type: String
    },
    typologyData: {
      required: false,
      type: String
    },
    areaData: {
      required: false,
      type: Number
    },
    districtData: {
      required: false,
      type: String
    },
    cityData: {
      required: false,
      type: String
    },
    addressData: {
      required: false,
      type: String
    },
    latData: {
      required: false,
      type: Number
    },
    lngData: {
      required: false,
      type: Number
    },
    furnishedData: {
      required: false,
      type: Boolean
    },
    totalAccessData: {
      required: false,
      type: Boolean
    },
    availabilityData: {
      required: false,
      type: String
    },
    rentData: {
      required: false,
      type: Boolean
    },
    sellData: {
      required: false,
      type: Boolean
    },
    rentPriceData: {
      required: false,
      type: Number
    },
    sellPriceData: {
      required: false,
      type: Number
    }
  },
  data: () => ({
    description: '',
    type: '',
    typology: null,
    area: null,
    district: null,
    city: null,
    address: '',
    lat: 0,
    lng: 0,
    furnished: false,
    totalAccess: false,
    availability: '',
    rent: true,
    sell: false,
    rentPrice: 0,
    sellPrice: 0,
    optionsType: [
      { value: '', text: 'Selecione um tipo de imóvel' },
      { value: 'bedrooms', text: 'Quarto' },
      { value: 'apartment', text: 'Apartamento' },
      { value: 'villa', text: 'Vivenda' }
    ],
    optionsTypology: [
      { value: null, text: 'Selecione uma tipologia' },
      { value: 'T0', text: 'T0' },
      { value: 'T1', text: 'T1' },
      { value: 'T2', text: 'T2' },
      { value: 'T3', text: 'T3' },
      { value: 'T4', text: 'T4' },
      { value: 'T5', text: 'T5' },
      { value: 'T6', text: 'T6' },
      { value: 'T7', text: 'T7' },
      { value: 'T8', text: 'T8' },
      { value: 'T9', text: 'T9' },
      { value: 'T10', text: 'T10' },
      { value: 'T10+', text: 'T10+' }
    ],
    optionsOperation: [
      { value: null, text: 'Selecione uma operação' },
      { value: 'sell', text: 'Vender' },
      { value: 'rent', text: 'Arrendar' },
      { value: 'both', text: 'Vender/Arrendar' }
    ]
  }),
  created () {
    if (this.descriptionData) { this.description = this.descriptionData }
    if (this.typeData) { this.type = this.typeData }
    if (this.typologyData) { this.typology = this.typologyData }
    if (this.areaData) { this.area = this.areaData }
    if (this.districtData) { this.district = this.districtData }
    if (this.cityData) { this.city = this.cityData }
    if (this.addressData) { this.address = this.addressData }
    if (this.latData) { this.lat = this.latData }
    if (this.lngData) { this.lng = this.lngData }
    if (this.furnishedData) { this.furnished = this.furnishedData }
    if (this.totalAccessData) { this.totalAccess = this.totalAccessData }
    if (this.availabilityData) { this.availability = this.availabilityData }
    if (this.rentData) { this.rent = this.rentData }
    if (this.sellData) { this.sell = this.sellData }
    if (this.rentPriceData) { this.rentPrice = this.rentPriceData }
    if (this.sellPriceData) { this.sellPrice = this.sellPriceData }
  },
  methods: {
    setPlace (place) {
      var hasStreet = false
      var addrComponents = place.address_components
      if (addrComponents) {
        addrComponents.forEach((comp) => {
          if (comp.types.includes('route')) {
            hasStreet = true
          }
          if (comp.types.includes('locality', 'political')) {
            this.$emit('updateCity', comp.long_name)
          }
          if (comp.types.includes('administrative_area_level_1', 'political')) {
            this.$emit('updateDistrict', comp.long_name)
          }
        })
        this.$emit('updateLatitude', place.geometry.location.lat())
        this.$emit('updateLongitude', place.geometry.location.lng())
        if (hasStreet) {
          this.$emit('updateAddress', place.formatted_address)
        }
      }
    },
    updateDescription (value) {
      this.$emit('updateDescription', value)
    },
    updateType (checked) {
      this.$emit('updateType', checked)
      // eslint-disable-next-line
      if (checked == 'apartment' || checked == 'villa') {
        this.$emit('updateTotalAccess', true)
      // eslint-disable-next-line
      } else if (checked == 'bedrooms') {
        this.$emit('updateRent', true)
        this.$emit('updateSell', false)
      }
    },
    updateTypology (checked) {
      this.$emit('updateTypology', checked)
    },
    updateArea (value) {
      this.$emit('updateArea', value)
    },
    updateFurnished (value) {
      this.$emit('updateFurnished', value)
    },
    updateTotalAccess (value) {
      this.$emit('updateTotalAccess', value)
    },
    updateAvailability (value) {
      this.$emit('updateAvailability', value)
    },
    updateRent (checked) {
      console.log(checked)
      this.$emit('updateRent', checked)
    },
    updateSell (checked) {
      this.$emit('updateSell', checked)
    },
    updateRentPrice (value) {
      this.$emit('updateRentPrice', value)
    },
    updateSellPrice (value) {
      this.$emit('updateSellPrice', value)
    }
  }
}
</script>

<style scoped>
.input-location input {
  width: 100% !important;
}
.input-location {
  width: 100% !important;
  margin-bottom: 1rem;
}
</style>
