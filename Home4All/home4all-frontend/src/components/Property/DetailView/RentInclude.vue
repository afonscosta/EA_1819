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

.btn-secondary {
  background-color: rgba(220,53,69, 0.7) !important;
}

.btn-secondary:not(:disabled):not(.disabled):active,
.btn-secondary:not(:disabled):not(.disabled).active,
.show > .btn-secondary.dropdown-toggle {
  background-color: rgba(0,128,0,0.7) !important;
  border-color: rgba(0,128,0,0.7) !important;
  box-shadow: 0 0 0 0.2rem rgba(72, 180, 97, 0.5) !important;
}

.btn-group {
  display: flex !important;
  flex-wrap: wrap;
}

.btn-group > .btn.active {
  background-color: rgba(0,128,0,0.7) !important;
  border-color: rgba(0,128,0,0.7) !important;
  box-shadow: 0 0 0 0.2rem rgba(72, 180, 97, 0.5) !important;
}

.btn-group > .btn,
.btn-group > .btn-group > .btn {
  margin: 0.375rem 0.75rem;
  border-radius: 0.25rem !important;
}
</style>
