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
            v-model="area"
            type="number"
            placeholder="Insira a área"
            @change="updateArea"
          ></b-form-input>
        </b-form-group>
      </b-col>
    </b-row>

    <b-row>
      <b-col>
        <b-form-group id="input-group-6" label="Distrito:" label-for="input-6">
          <b-form-select
            v-model="district"
            :options="optionsDistrict"
            @change="updateDistrict"
          ></b-form-select>
        </b-form-group>
      </b-col>
      <b-col>
        <b-form-group id="input-group-7" label="Cidade:" label-for="input-7">
          <b-form-select
            v-model="city"
            :options="optionsCity"
            @change="updateCity"
          ></b-form-select>
        </b-form-group>
      </b-col>
    </b-row>

    <b-form-group id="input-group-8" label="Rua:" label-for="input-8">
      <b-input
        v-model="street"
        placeholder="Rua"
        @change="updateStreet"
      ></b-input>
    </b-form-group>

    <b-form-checkbox
      id="checkbox-1"
      v-model="furnished"
      name="checkbox-1"
      @change="updateFurnished"
      class="pb-2"
    >Mobilado</b-form-checkbox>

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
      <b-col>
        <b-form-group id="input-group-12" v-if="type !== 'bedrooms'" label="Operação:" label-for="input-12">
          <b-form-select
            v-model="operation"
            :options="optionsOperation"
            @change="updateOperation"
          ></b-form-select>
        </b-form-group>
      </b-col>
    </b-row>

    <b-row>
      <b-col>
        <b-form-group id="input-group-13" v-if="type !== 'bedrooms'" label="Mensalidade:" label-for="input-13">
          <b-input
            v-model="rentPrice"
            type="number"
            @change="updateRentPrice"
          ></b-input>
        </b-form-group>
      </b-col>
      <b-col>
        <b-form-group id="input-group-14" v-if="type !== 'bedrooms'" label="Preço total:" label-for="input-14">
          <b-input
            v-model="sellPrice"
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
    streetData: {
      required: false,
      type: String
    },
    furnishedData: {
      required: false,
      type: Boolean
    },
    availabilityData: {
      required: false,
      type: String
    },
    operationData: {
      required: false,
      type: String
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
    street: '',
    furnished: false,
    availability: '',
    operation: null,
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
    optionsDistrict: [
      { value: null, text: 'Selecione um distrito' },
      { value: 'porto', text: 'Porto' },
      { value: 'braga', text: 'Braga' },
      { value: 'lisboa', text: 'Lisboa' },
      { value: 'algarve', text: 'Algarve' }
    ],
    optionsCity: [
      { value: null, text: 'Selecione uma cidade' },
      { value: 'trofa', text: 'Trofa' },
      { value: 'valongo', text: 'Valongo' },
      { value: 'matosinhos', text: 'Matosinhos' },
      { value: 'penafiel', text: 'Penafiel' }
    ],
    optionsOperation: [
      { value: null, text: 'Selecione uma operação' },
      { value: 'sell', text: 'Vender' },
      { value: 'rent', text: 'Arrendar' },
      { value: 'both', text: 'Vender/Arrendar' }
    ]
  }),
  created () {
    if (this.descriptionData) {
      this.description = this.descriptionData
    }
    if (this.typeData) {
      this.type = this.typeData
    }
    if (this.typologyData) {
      this.typology = this.typologyData
    }
    if (this.areaData) {
      this.area = this.areaData
    }
    if (this.districtData) {
      this.district = this.districtData
    }
    if (this.cityData) {
      this.city = this.cityData
    }
    if (this.streetData) {
      this.street = this.streetData
    }
    if (this.furnishedData) {
      this.furnished = this.furnishedData
    }
    if (this.availabilityData) {
      this.availability = this.availabilityData
    }
    if (this.operationData) {
      this.operation = this.operationData
    }
    if (this.rentPriceData) {
      this.rentPrice = this.rentPriceData
    }
    if (this.sellPriceData) {
      this.sellPrice = this.sellPriceData
    }
  },
  methods: {
    updateDescription (value) {
      this.$emit('updateDescription', value)
    },
    updateType (checked) {
      this.$emit('updateType', checked)
    },
    updateTypology (checked) {
      this.$emit('updateTypology', checked)
    },
    updateArea (value) {
      this.$emit('updateArea', value)
    },
    updateDistrict (checked) {
      this.$emit('updateDistrict', checked)
    },
    updateCity (checked) {
      this.$emit('updateCity', checked)
    },
    updateStreet (value) {
      this.$emit('updateStreet', value)
    },
    updateFurnished (value) {
      this.$emit('updateFurnished', value)
    },
    updateAvailability (value) {
      this.$emit('updateAvailability', value)
    },
    updateOperation (checked) {
      this.$emit('updateOperation', checked)
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
