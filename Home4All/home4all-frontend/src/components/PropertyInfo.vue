<template>
  <b-card
    border-variant="secondary"
    header="Informação Geral"
    header-border-variant="secondary"
  >
    <b-form-group id="input-group-2" label="Descrição:" label-for="input-2">
      <b-form-input
        id="input-2"
        v-model="description"
        placeholder="Insira uma descrição"
        @change="updateDescription"
      ></b-form-input>
    </b-form-group>

    <b-form-group
      id="input-group-3"
      label="Imóvel:"
      label-for="input-3"
    >
      <b-form-select
        v-model="selectedType"
        :options="optionsType"
        @change="updateSelectedType"
      ></b-form-select>
    </b-form-group>

    <b-form-group
      id="input-group-4"
      label="Tipologia:"
      label-for="input-4"
    >
      <b-form-select
        v-model="selectedTypology"
        :options="optionsTypology"
        @change="updateSelectedTypology"
      ></b-form-select>
    </b-form-group>

    <b-form-group id="input-group-5" label="Área:" label-for="input-5">
      <b-form-input
        id="input-5"
        v-model="area"
        type="number"
        placeholder="Insira a área"
        @change="updateArea"
      ></b-form-input>
    </b-form-group>

    <b-form-group id="input-group-6" label="Distrito:" label-for="input-6">
      <b-form-select
        v-model="selectedDistrict"
        :options="optionsDistrict"
        @change="updateSelectedDistrict"
      ></b-form-select>
    </b-form-group>

    <b-form-group id="input-group-7" label="Cidade:" label-for="input-7">
      <b-form-select
        v-model="selectedCity"
        :options="optionsCity"
        @change="updateSelectedCity"
      ></b-form-select>
    </b-form-group>

    <b-form-group id="input-group-8" label="Rua:" label-for="input-8">
      <b-input
        v-model="street"
        placeholder="Rua"
        @change="updateStreet"
      ></b-input>
    </b-form-group>

    <b-form-group id="input-group-9" label="Contactos:" label-for="input-9">
      <b-input
        v-model="contact"
        placeholder="Contacto telefónico ou E-mail"
        @change="updateContact"
      ></b-input>
    </b-form-group>

    <b-form-group id="input-group-10" v-if="selectedType !== 'bedrooms'" label="Mobilado:" label-for="input-10">
      <b-form-checkbox
        id="checkbox-1"
        v-model="furnished"
        name="checkbox-1"
        @change="updateFurnished"
      />
    </b-form-group>

    <b-form-group id="input-group-11" v-if="selectedType !== 'bedrooms'" label="Disponível a partir de:" label-for="input-11">
      <b-input
        v-model="availability"
        type="date"
        @change="updateAvailability"
      ></b-input>
    </b-form-group>

    <b-form-group id="input-group-12" v-if="selectedType !== 'bedrooms'" label="Operação:" label-for="input-12">
      <b-form-select
        v-model="selectedOperation"
        :options="optionsOperation"
        @change="updateSelectedOperation"
      ></b-form-select>
    </b-form-group>

    <b-form-group id="input-group-13" v-if="selectedType !== 'bedrooms'" label="Mensalidade:" label-for="input-13">
      <b-input
        v-model="rentPrice"
        type="number"
        @change="updateRentPrice"
      ></b-input>
    </b-form-group>

    <b-form-group id="input-group-14" v-if="selectedType !== 'bedrooms'" label="Preço total:" label-for="input-14">
      <b-input
        v-model="sellPrice"
        type="number"
        @change="updateSellPrice"
      ></b-input>
    </b-form-group>
  </b-card>
</template>

<script>
export default {
  name: 'PropertyInfo',
  data: () => ({
    description: '',
    selectedType: '',
    selectedTypology: null,
    area: null,
    selectedDistrict: null,
    selectedCity: null,
    street: '',
    contact: '',
    furnished: false,
    availability: '',
    selectedOperation: null,
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
  methods: {
    updateDescription (value) {
      this.$emit('updateDescription', value)
    },
    updateSelectedType (checked) {
      this.$emit('updateSelectedType', checked)
    },
    updateSelectedTypology (checked) {
      this.$emit('updateSelectedTypology', checked)
    },
    updateArea (value) {
      this.$emit('updateArea', value)
    },
    updateSelectedDistrict (checked) {
      this.$emit('updateSelectedDistrict', checked)
    },
    updateSelectedCity (checked) {
      this.$emit('updateSelectedCity', checked)
    },
    updateStreet (value) {
      this.$emit('updateStreet', value)
    },
    updateContact (value) {
      this.$emit('updateContact', value)
    },
    updateFurnished (value) {
      this.$emit('updateFurnished', value)
    },
    updateAvailability (value) {
      this.$emit('updateAvailability', value)
    },
    updateSelectedOperation (checked) {
      this.$emit('updateSelectedOperation', checked)
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
