<template>
  <b-card
    border-variant="secondary"
    header="Renda inclui"
    header-border-variant="secondary"
  >
    <b-form-group id="rent-inc-form-group">
      <b-form-checkbox-group
        id="rent-inc-checkbox-group"
        v-model="selectedRentInc"
        :options="optionsRentInc"
        @change="change"
        buttons
        button-variant="danger"
      ></b-form-checkbox-group>
    </b-form-group>
  </b-card>
</template>

<script>
export default {
  name: 'RentInclude',
  data: () => ({
    selectedRentInc: [],
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
  methods: {
    change (checked) {
      this.$emit('updateSelectedRentInc', checked)
    }
  }
}
</script>

<style scope>
.btn-danger:not(:disabled):not(.disabled):active,
.btn-danger:not(:disabled):not(.disabled).active,
.show > .btn-danger.dropdown-toggle {
  background-color: green !important;
  border-color: green !important;
  box-shadow: 0 0 0 0.2rem rgba(72, 180, 97, 0.5) !important;
}

.btn-group {
  display: flex !important;
  flex-wrap: wrap;
}

.btn-group > .btn,
.btn-group > .btn-group > .btn {
  margin: 0.375rem 0.75rem;
  border-radius: 0.25rem !important;
}

#rent-inc-form-group {
  margin: 0px !important;
}
</style>
