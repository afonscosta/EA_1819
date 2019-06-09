<template>
  <b-card
    border-variant="secondary"
    header="Renda inclui"
    header-border-variant="secondary"
  >
    <b-form-group id="rent-inc-form-group">
      <b-form-checkbox-group
        id="rent-inc-checkbox-group"
        v-model="rentInc"
        :options="optionsRentInc"
        @change="change"
        buttons
        button-variant="secondary"
      ></b-form-checkbox-group>
    </b-form-group>
  </b-card>
</template>

<script>
export default {
  name: 'RentInclude',
  props: {
    rentIncData: {
      required: false,
      type: Array
    }
  },
  data: () => ({
    rentInc: [],
    optionsRentInc: [
      { value: 'water', text: 'Água' },
      { value: 'eletricity', text: 'Eletricidade' },
      { value: 'cableTV', text: 'TV Cabo' },
      { value: 'internet', text: 'Internet' },
      { value: 'condominium', text: 'Condomínio' },
      { value: 'telephone', text: 'Telefone' },
      { value: 'cleaning', text: 'Limpeza' }
    ]
  }),
  created () {
    if (this.rentIncData) {
      this.rentInc = this.rentIncData
    }
  },
  methods: {
    change (checked) {
      this.$emit('updateRentInc', checked)
    }
  }
}
</script>

<style scope>
#rent-inc-form-group {
  margin: 0px !important;
}
</style>
