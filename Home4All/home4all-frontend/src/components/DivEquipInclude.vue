<template>
  <b-card
    border-variant="secondary"
    header="Divisões e equipamentos incluídos"
    header-border-variant="secondary"
  >
    <b-form-group id="div-equip-form-group">
      <b-form-checkbox-group
        id="checkbox-group-3"
        v-model="selectedDivEquipInc"
        :options="optionsDivEquipInc"
        buttons
        button-variant="danger"
        @change="updateSelectedDivEquipInc"
      ></b-form-checkbox-group>
    </b-form-group>
  </b-card>
</template>

<script>
export default {
  name: 'DivEquipInclude',
  data: () => ({
    selectedDivEquipInc: [],
    optionsDivEquipInc: [
      { value: 'kitchen', text: 'Cozinha' },
      { value: 'microwave', text: 'Micro-ondas' },
      { value: 'dishwasher', text: 'Máq. lavar loiça' },
      { value: 'stove', text: 'Fogão' },
      { value: 'fridge', text: 'Frigorífico' },
      { value: 'washingMachine', text: 'Máq. lavar roupa' },
      { value: 'cableTV', text: 'TV Cabo' },
      { value: 'WiFi', text: 'Wi-Fi' },
      { value: 'computer', text: 'Computador' },
      { value: 'gym', text: 'Ginásio' },
      { value: 'pool', text: 'Piscina' },
      { value: 'elevator', text: 'Elevador' },
      { value: 'centralHeating', text: 'Aquecimento central' },
      { value: 'airConditioning', text: 'Ar condicionado' },
      { value: 'garage', text: 'Garagem' },
      { value: 'freeParking', text: 'Estacionamento gratuito' }
    ]
  }),
  methods: {
    updateSelectedDivEquipInc (checked) {
      this.$emit('updateSelectedDivEquipInc', checked)
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

#div-equip-form-group {
  margin: 0px !important;
}
</style>
