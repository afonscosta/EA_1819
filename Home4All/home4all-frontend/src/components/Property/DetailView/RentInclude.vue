<template>
  <b-card
    border-variant="secondary"
    header="Renda inclui"
    header-border-variant="secondary"
  >
    <b-form-group id="rent-inc-form-group">
      <b-form-checkbox-group
        id="rent-inc-checkbox-group"
        v-model="expensesIncluded"
        :options="optionsRentInc"
        buttons
        button-variant="secondary"
        disabled
      ></b-form-checkbox-group>
    </b-form-group>
  </b-card>
</template>

<script>
export default {
  name: 'RentInclude',
  props: {
    expensesIncluded: {
      type: Array
    }
  },
  data: () => ({
    optionsRentInc: [
      { value: 'water', text: 'Água' },
      { value: 'eletricity', text: 'Eletricidade' },
      { value: 'cableTV', text: 'TV Cabo' },
      { value: 'internet', text: 'Internet' },
      { value: 'condominium', text: 'Condomínio' },
      { value: 'telephone', text: 'Telefone' },
      { value: 'cleaning', text: 'Limpeza' }
    ]
  })
}
</script>

<style scope>
#rent-inc-form-group {
  margin: 0px !important;
}
</style>
