<template>
  <b-card
    v-if="selectedType === 'bedrooms'"
    border-variant="secondary"
    header="Quartos disponíveis"
    header-border-variant="secondary"
  >
    <b-form-group
      id="input-group-18"
    >
      <b-form-group id="input-group-18-1" label="Tipo:" label-for="input-11">
        <b-form-select
          v-model="bedroom.selectedType"
          :options="optionsType"
        ></b-form-select>
      </b-form-group>
      <b-form-group id="input-group-18-1" label="Área:" label-for="input-11">
        <b-input
          v-model="bedroom.area"
          type="number"
          width="auto"
        ></b-input>
      </b-form-group>
      <b-form-group id="input-group-18-1" label="Mobilado:" label-for="input-11">
        <b-form-checkbox
          id="checkbox-4"
          v-model="bedroom.furnished"
          name="checkbox-4"
        />
      </b-form-group>
      <b-form-group id="input-group-18-1" label="Casa de banho privada:" label-for="input-11">
        <b-form-checkbox
          id="checkbox-5"
          v-model="bedroom.privateBathroom"
          name="checkbox-5"
        />
      </b-form-group>
      <b-form-group id="input-group-18-1" label="Disponibilidade:" label-for="input-11">
        <b-input
          v-model="bedroom.availability"
          type="date"
        ></b-input>
      </b-form-group>
      <b-form-group id="input-group-18-1" label="Preço:" label-for="input-11">
        <b-input
          v-model="bedroom.rentPrice"
          type="number"
        ></b-input>
      </b-form-group>
    </b-form-group>
  </b-card>
</template>

<script>
export default {
  name: 'Bedroom',
  props: {
    selectedType: {
      required: true,
      type: String
    }
  },
  data: () => ({
    bedroom: {
      selectedType: null,
      area: 0,
      furnished: false,
      privateBathroom: false,
      availability: '',
      rentPrice: 0
    },
    optionsType: [
      { value: null, text: 'Selecione um tipo de quarto' },
      { value: 'single', text: 'Individual' },
      { value: 'double', text: 'Duplo' },
      { value: 'multiple', text: 'Múltiplo' }
    ]
  }),
  methods: {
    updateBedroomSelectedType (checked) {
      this.$emit('updateBedroomSelectedType', checked)
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
    }
  }
}
</script>
