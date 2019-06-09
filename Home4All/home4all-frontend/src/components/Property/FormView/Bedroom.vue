<template>
  <b-card
    v-if="type === 'bedrooms'"
    border-variant="secondary"
    header="Quartos disponíveis"
    header-border-variant="secondary"
  >
    <b-form-group
      id="bedrooms-form-group"
    >
      <b-row align-v="end">
        <b-col>
          <b-form-group id="type" label="Tipo:" label-for="input-11">
            <b-form-select
              v-model="bedroom.type"
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
    type: {
      required: true,
      type: String
    },
    bedroomsData: {
      required: false,
      type: Array
    }
  },
  data: () => ({
    bedroom: {
      type: null,
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
  created () {
    if (this.bedroomsData) {
      // TODO: Não pode ficar assim!
      this.bedroom = this.bedroomsData[0]
    }
  },
  methods: {
    updateBedroomType (checked) {
      this.$emit('updateBedroomType', checked)
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

#type,
#area,
#furnished,
#privateBathroom,
#availability,
#rentPrice {
  margin: 0px !important;
}
</style>
