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
        :options="optionsDivEquipInc"
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
  })
}
</script>

<style scope>
#div-equip-form-group {
  margin: 0px !important;
}
</style>
