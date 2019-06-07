<template>
  <b-card
    v-if="selectedType === 'bedrooms'"
    border-variant="secondary"
    header="Quartos disponíveis"
    header-border-variant="secondary"
  >
    <b-form-group
      id="bedrooms-form-group"
    >
      <b-row align-v="end">
        <b-col>
          <b-form-group id="selectedType" label="Tipo:" label-for="input-11">
            <b-form-select
              v-model="bedroom.selectedType"
              :options="optionsType"
            ></b-form-select>
          </b-form-group>
        </b-col>
        <b-col>
          <b-form-group id="area" label="Área:" label-for="input-11">
            <b-input
              v-model="bedroom.area"
              type="number"
              width="auto"
            ></b-input>
          </b-form-group>
        </b-col>
        <b-col cols="3">
          <b-row>
            <b-col cols="12">
              <b-form-checkbox
                id="furnished"
                v-model="bedroom.furnished"
                name="checkbox-4"
              >Mobilado</b-form-checkbox>
            </b-col>
            <b-col cols="12">
              <b-form-checkbox
                id="privateBathroom"
                v-model="bedroom.privateBathroom"
                name="checkbox-5"
              >Casa de banho privativa</b-form-checkbox>
            </b-col>
          </b-row>
        </b-col>
        <b-col>
          <b-form-group id="availability" label="Disponibilidade:" label-for="input-11">
            <b-input
              v-model="bedroom.availability"
              type="date"
            ></b-input>
          </b-form-group>
        </b-col>
        <b-col>
          <b-form-group id="rentPrice" label="Preço:" label-for="input-11">
            <b-input
              v-model="bedroom.rentPrice"
              type="number"
            ></b-input>
          </b-form-group>
        </b-col>
      </b-row>
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

<style scope>
#bedrooms-form-group {
  margin: 0px !important;
}

#selectedType,
#area,
#furnished,
#privateBathroom,
#availability,
#rentPrice {
  margin: 0px !important;
}
</style>
