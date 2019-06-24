<template>
  <b-card
    border-variant="secondary"
    header="Divisões e equipamentos incluídos"
    header-border-variant="secondary"
  >
    <b-form-group id="div-equip-form-group">
      <b-form-checkbox-group
        disabled
        id="checkbox-group-3"
        v-model="equipmentIncluded"
        :options="optionsEquipmentIncluded"
        buttons
        button-variant="secondary"
      ></b-form-checkbox-group>
    </b-form-group>
  </b-card>
</template>

<script>
export default {
  name: 'DivEquipInclude',
  props: {
    equipmentIncluded: {
      type: Array
    }
  },
  data: () => ({
    optionsEquipmentIncluded: [
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
  })
}
</script>

<style scope>
#div-equip-form-group {
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
