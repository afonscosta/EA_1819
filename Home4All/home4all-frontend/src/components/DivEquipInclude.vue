<template>
  <b-card
    border-variant="secondary"
    header="Divisões e equipamentos incluídos"
    header-border-variant="secondary"
  >
    <b-form-group id="input-group-17">
      <b-form-checkbox-group
        id="checkbox-group-3"
        v-model="selectedDivEquipInc"
        :options="optionsDivEquipInc"
        stacked
        buttons
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
