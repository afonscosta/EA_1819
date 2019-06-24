<template>
  <b-card
    border-variant="secondary"
    header="Divisões e equipamentos incluídos"
    header-border-variant="secondary"
  >
    <b-form-group id="div-equip-form-group">
      <b-form-checkbox-group
        id="checkbox-group-3"
        v-model="equipmentIncluded"
        :options="optionsEquipmentIncluded"
        buttons
        button-variant="secondary"
        @change="updateEquipmentIncluded"
      ></b-form-checkbox-group>
    </b-form-group>
  </b-card>
</template>

<script>
export default {
  name: 'DivEquipInclude',
  props: {
    equipmentIncludedData: {
      required: false,
      type: Array
    }
  },
  data: () => ({
    equipmentIncluded: [],
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
  }),
  created () {
    if (this.equipmentIncludedData) {
      this.equipmentIncluded = this.equipmentIncludedData
    }
  },
  methods: {
    updateEquipmentIncluded (checked) {
      this.$emit('updateEquipmentIncluded', checked)
    }
  }
}
</script>

<style scope>
#div-equip-form-group {
  margin: 0px !important;
}
</style>
